package eu.europa.ec.fisheries.uvms.user.client.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import eu.europa.ec.fisheries.uvms.commons.message.api.MessageConstants;
import eu.europa.ec.fisheries.uvms.commons.message.impl.AbstractConsumer;

@Stateless
@LocalBean
public class UserConsumerBean extends AbstractConsumer {
	@Override
	public String getDestinationName() {
		return MessageConstants.QUEUE_USER_RESPONSE;
	}
}
