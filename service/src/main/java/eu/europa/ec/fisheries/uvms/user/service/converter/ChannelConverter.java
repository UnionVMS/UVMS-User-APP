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

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;

public class ChannelConverter {

	/*
	
	Information-Model
	package eu.europa.ec.mare.usm.information.domain;
		private String dataFlow;
		private String service;
		private Integer priority;
	  
	user-model
	package eu.europa.ec.fisheries.wsdl.user.types;   
		protected String dataFlow;
	    protected String service;
	    protected BigInteger priority;
	
	
	*/
	
	public static eu.europa.ec.fisheries.wsdl.user.types.Channel
	       convertInformationModelToUserModel(eu.europa.ec.mare.usm.information.domain.Channel domainChannel)
	       {
		eu.europa.ec.fisheries.wsdl.user.types.Channel typesChannel = 
				new eu.europa.ec.fisheries.wsdl.user.types.Channel();
		
		typesChannel.setDataFlow(domainChannel.getDataFlow());
		typesChannel.setService(domainChannel.getService());
		BigInteger bigIntegerPriority = BigInteger.valueOf(domainChannel.getPriority().intValue());
		typesChannel.setPriority(bigIntegerPriority);
		
		return typesChannel;
		
	       }
}