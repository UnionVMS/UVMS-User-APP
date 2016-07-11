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
package eu.europa.ec.fisheries.uvms.user.service.converter;

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import eu.europa.ec.mare.usm.information.domain.Channel;
import eu.europa.ec.mare.usm.information.domain.ContactDetails;

public class EndPointConverter {
	/*
	Information-Model
	eu.europa.ec.mare.usm.information.domain;
	private String name;
	private String description;
	private String uri;
    private String email;
	private boolean enabled;
    private List<Channel> channels;
	private List<ContactDetails> contactDetails;
	
	user-model	
    package eu.europa.ec.fisheries.wsdl.user.types;
    protected String uri;
    protected String email;
    protected boolean enabled;
    protected List<Channel> channels;
    protected List<ContactDetails> contactDetails;
	

	
	*/
	
	public static eu.europa.ec.fisheries.wsdl.user.types.EndPoint 
	    convertInformationModelToUserModel(eu.europa.ec.mare.usm.information.domain.EndPoint domainEndPoint)
	    {
		eu.europa.ec.fisheries.wsdl.user.types.EndPoint typesEndPoint = 
				new eu.europa.ec.fisheries.wsdl.user.types.EndPoint();
		typesEndPoint.setName(domainEndPoint.getName());
		typesEndPoint.setDescription(domainEndPoint.getDescription());
		typesEndPoint.setUri(domainEndPoint.getUri());
		typesEndPoint.setEmail(domainEndPoint.getEmail());
		typesEndPoint.setEnabled(domainEndPoint.isEnabled());
		
		List<eu.europa.ec.fisheries.wsdl.user.types.Channel> typesChannels = typesEndPoint.getChannels();
		List<eu.europa.ec.mare.usm.information.domain.Channel> domainChannels = domainEndPoint.getChannels();
		
		Iterator<eu.europa.ec.mare.usm.information.domain.Channel> channelsIterator = domainChannels.iterator();
		while(channelsIterator.hasNext())
		{
			eu.europa.ec.mare.usm.information.domain.Channel domainChannelElement = channelsIterator.next();
			eu.europa.ec.fisheries.wsdl.user.types.Channel typesChannelElement = ChannelConverter.convertInformationModelToUserModel(domainChannelElement);
			typesChannels.add(typesChannelElement);
		}
		
		List<eu.europa.ec.fisheries.wsdl.user.types.ContactDetails> typesContactDetails = typesEndPoint.getContactDetails();
		List<eu.europa.ec.mare.usm.information.domain.ContactDetails> domainContactDetails = domainEndPoint.getContactDetails();
		
		Iterator<eu.europa.ec.mare.usm.information.domain.ContactDetails> contactDetailsIterator = domainContactDetails.iterator();
		while(contactDetailsIterator.hasNext())
		{
			eu.europa.ec.mare.usm.information.domain.ContactDetails domainContactDetailsElement = contactDetailsIterator.next();
			eu.europa.ec.fisheries.wsdl.user.types.ContactDetails typesContactDetailsElement = ContactDetailsConverter.convertInformationModelToUserModel(domainContactDetailsElement);
			typesContactDetails.add(typesContactDetailsElement);
		}
		
		
		return typesEndPoint;
				
	    }

}