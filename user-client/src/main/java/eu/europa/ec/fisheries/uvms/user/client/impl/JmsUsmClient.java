package eu.europa.ec.fisheries.uvms.user.client.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBException;

import java.util.List;

import eu.europa.ec.fisheries.uvms.commons.message.api.MessageException;
import eu.europa.ec.fisheries.uvms.commons.message.impl.JAXBUtils;
import eu.europa.ec.fisheries.uvms.user.client.UserClientException;
import eu.europa.ec.fisheries.uvms.user.client.UsmClient;
import eu.europa.ec.fisheries.uvms.user.model.exception.ModelMarshallException;
import eu.europa.ec.fisheries.uvms.user.model.mapper.UserModuleRequestMapper;
import eu.europa.ec.fisheries.wsdl.user.module.FindFeaturesResponse;

/**
 * Implementation of the {@link UsmClient} over JMS.
 */
@ApplicationScoped
public class JmsUsmClient implements UsmClient {

	private UserProducerBean userProducerBean;
	private UserConsumerBean userConsumerBean;

	/**
	 * Constructor for injection.
	 *
	 * @param userProducerBean The JMS producer
	 * @param userConsumerBean The JMS consumer
	 */
	@Inject
	public JmsUsmClient(UserProducerBean userProducerBean, UserConsumerBean userConsumerBean) {
		this.userProducerBean = userProducerBean;
		this.userConsumerBean = userConsumerBean;
	}

	/**
	 * Default constructor for frameworks.
	 */
	@SuppressWarnings("unused")
	JmsUsmClient() {
		// NOOP
	}

	@Override
	public List<Integer> findFeatures(String username) {
		List<Integer> result = null;
		try {
			String requestString = UserModuleRequestMapper.mapToFindFeaturesRequest(username);
			String correlationID = userProducerBean.sendModuleMessage(requestString, userConsumerBean.getDestination());
			if (correlationID != null) {
				TextMessage message = userConsumerBean.getMessage(correlationID, TextMessage.class );
				FindFeaturesResponse response = JAXBUtils.unMarshallMessage(message.getText(), FindFeaturesResponse.class);
				result = response.getFeatures();
			}
		} catch (ModelMarshallException | MessageException | JMSException | JAXBException e) {
			throw new UserClientException(e);
		}
		return result;
	}
}
