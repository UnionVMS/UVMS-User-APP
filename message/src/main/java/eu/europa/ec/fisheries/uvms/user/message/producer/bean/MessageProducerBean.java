/*
 * Developed by the European Commission - Directorate General for Maritime 
 * Affairs and Fisheries © European Union, 2015-2016.
 * 
 * This file is part of the Integrated Fisheries Data Management (IFDM) Suite.
 * The IFDM Suite is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or any later version.
 * The IFDM Suite is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details. You should have received a copy of the GNU General Public 
 * License along with the IFDM Suite. If not, see http://www.gnu.org/licenses/.
 */
package eu.europa.ec.fisheries.uvms.user.message.producer.bean;

import java.math.BigInteger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Observes;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.europa.ec.fisheries.uvms.commons.message.impl.JMSUtils;
import eu.europa.ec.fisheries.uvms.user.message.constants.MessageConstants;
import eu.europa.ec.fisheries.uvms.user.message.event.ErrorEvent;
import eu.europa.ec.fisheries.uvms.user.message.event.carrier.EventMessage;
import eu.europa.ec.fisheries.uvms.user.message.exception.UserMessageException;
import eu.europa.ec.fisheries.uvms.user.message.producer.UserMessageProducer;
import eu.europa.ec.fisheries.uvms.user.model.exception.ModelMarshallException;
import eu.europa.ec.fisheries.uvms.user.model.mapper.JAXBMarshaller;
import eu.europa.ec.fisheries.wsdl.user.types.UserFault;

@Stateless
public class MessageProducerBean implements UserMessageProducer {

    final static Logger LOG = LoggerFactory.getLogger(MessageProducerBean.class);

    @Resource(mappedName = MessageConstants.USER_RESPONSE_QUEUE)
    private Queue responseQueue;

    @Resource(lookup = MessageConstants.CONNECTION_FACTORY)
    private ConnectionFactory connectionFactory;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void sendMessageBackToRecipient(TextMessage requestMessage, String returnMessage) throws UserMessageException {
        Connection connection=null;
        try {
            connection = connectionFactory.createConnection();
            final Session session = JMSUtils.connectToQueue(connection);
 
            LOG.info("[ Sending message back to recipient on queue ] {}", requestMessage.getJMSReplyTo());

            TextMessage message = session.createTextMessage();
            message.setJMSDestination(requestMessage.getJMSReplyTo());
            message.setJMSCorrelationID(requestMessage.getJMSMessageID());
            message.setText(returnMessage);

            try (javax.jms.MessageProducer messageProducer = session.createProducer( message.getJMSDestination())) {

                messageProducer.send( message );
            }

        } catch (Exception e) {
            LOG.error("[ Error when sending message. ] {}", e.getMessage());
            throw new UserMessageException("[ Error when sending message. ]", e);
        } finally {
        	JMSUtils.disconnectQueue(connection);
        }
    }    
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void sendErrorMessageBackToRecipient(@Observes @ErrorEvent EventMessage message) throws UserMessageException {
        Connection connection=null;
        try {
            connection = connectionFactory.createConnection();
            final Session session = JMSUtils.connectToQueue(connection);
            
            TextMessage requestMessage = message.getJmsMessage();

            UserFault userFault = new UserFault();
            userFault.setCode(BigInteger.ZERO);
            userFault.setFault(message.getErrorMessage());

            String text = JAXBMarshaller.marshallJaxBObjectToString(userFault);

            TextMessage replyMessage = session.createTextMessage();
            replyMessage.setJMSDestination(requestMessage.getJMSReplyTo());
            replyMessage.setJMSCorrelationID(message.getJmsMessage().getJMSMessageID());
            replyMessage.setText(text);

            LOG.info("[ Sending error message back to recipient on queue ] {}", requestMessage.getJMSReplyTo());
            try (javax.jms.MessageProducer messageProducer = session.createProducer(replyMessage.getJMSDestination())) {

                messageProducer.send(replyMessage);
            }

        } catch (JMSException | ModelMarshallException e) {
            LOG.error("[ Error when sending message. ] {}", e.getMessage());
            throw new UserMessageException("[ Error when sending message. ]", e);
        } finally {
        	JMSUtils.disconnectQueue(connection);
        }
    }

}