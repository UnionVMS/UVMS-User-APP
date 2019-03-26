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

import eu.europa.ec.fisheries.uvms.commons.message.api.MessageException;
import eu.europa.ec.fisheries.uvms.commons.message.impl.AbstractProducer;
import eu.europa.ec.fisheries.uvms.user.message.event.ErrorEvent;
import eu.europa.ec.fisheries.uvms.user.message.event.carrier.EventMessage;
import eu.europa.ec.fisheries.uvms.user.model.exception.ModelMarshallException;
import eu.europa.ec.fisheries.uvms.user.model.mapper.JAXBMarshaller;
import eu.europa.ec.fisheries.wsdl.user.types.UserFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Observes;
import javax.jms.TextMessage;
import java.math.BigInteger;

@Stateless
@LocalBean
public class UserMessageProducerBean extends AbstractProducer {

    final static Logger LOG = LoggerFactory.getLogger(UserMessageProducerBean.class);


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void sendMessageBackToRecipient(TextMessage requestMessage, String returnMessage) throws MessageException {
        sendResponseMessageToSender(requestMessage, returnMessage);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void sendErrorMessageBackToRecipient(@Observes @ErrorEvent EventMessage message) throws MessageException {
        try {
            TextMessage requestMessage = message.getJmsMessage();
            UserFault userFault = new UserFault();
            userFault.setCode(BigInteger.ZERO);
            userFault.setFault(message.getErrorMessage());
            String text = JAXBMarshaller.marshallJaxBObjectToString(userFault);
            sendResponseMessageToSender(requestMessage, text);

        } catch (ModelMarshallException e) {
            LOG.error("[ Error when sending message. ] {}", e.getMessage());
            throw new MessageException("[ Error when sending message. ]", e);
        }
    }

    @Override
    public String getDestinationName() {
        return eu.europa.ec.fisheries.uvms.commons.message.api.MessageConstants.QUEUE_USER_RESPONSE;
    }

}