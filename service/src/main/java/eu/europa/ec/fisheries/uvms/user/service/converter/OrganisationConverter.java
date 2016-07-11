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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import eu.europa.ec.mare.usm.information.domain.EndPoint;

public class OrganisationConverter {
	/*
		Information-Model:
		package eu.europa.ec.mare.usm.information.domain;
			private String name; X
			private String nation; X
			private String email; X
			private String description; X
			private boolean enabled;
			private String parentOrganisation;
		  	private List<String> childOrganisations;
			private List<EndPoint> endPoints;	
		
		user-model:
		package eu.europa.ec.fisheries.wsdl.user.types;
		    protected String parentOrganisation;
		    protected String email; X
		    protected boolean status;
		    protected String nation; X
		    protected List<String> childOrgansiation;
		    protected List<EndPoint> endPoints;
			
			
			
*/
	
	public static  eu.europa.ec.fisheries.wsdl.user.types.Organisation
	   convertInformationModelToUserModel(eu.europa.ec.mare.usm.information.domain.Organisation domainOrganisation)
	   {
		if (domainOrganisation == null) {
		    return null;
		}
	    
		eu.europa.ec.fisheries.wsdl.user.types.Organisation typesOrganisation =
				new eu.europa.ec.fisheries.wsdl.user.types.Organisation();
		
		typesOrganisation.setParentOrganisation(domainOrganisation.getParentOrganisation());
		//typesOrganisation nu are setter pt childOrganisations
		//nici pt endPoints
		typesOrganisation.setEmail(domainOrganisation.getEmail());
		typesOrganisation.setNation(domainOrganisation.getNation());
		typesOrganisation.setName(domainOrganisation.getName());
		typesOrganisation.setDescription(domainOrganisation.getDescription());
		typesOrganisation.setStatus(domainOrganisation.isEnabled());
		typesOrganisation.setParentOrganisation(domainOrganisation.getParentOrganisation());
		
		List<eu.europa.ec.fisheries.wsdl.user.types.EndPoint> typesEndPoints = typesOrganisation.getEndPoints();
		List<eu.europa.ec.mare.usm.information.domain.EndPoint> domainEndPoints = domainOrganisation.getEndPoints();
		if (domainEndPoints != null) {
			Iterator<eu.europa.ec.mare.usm.information.domain.EndPoint> iterator = domainEndPoints.iterator();
			while(iterator.hasNext())
			{
				eu.europa.ec.mare.usm.information.domain.EndPoint domainEndPointElement = iterator.next();
				eu.europa.ec.fisheries.wsdl.user.types.EndPoint typesEndPointElement = EndPointConverter.convertInformationModelToUserModel(domainEndPointElement);
				typesEndPoints.add(typesEndPointElement);
			}
		}
		
		return typesOrganisation;
	   }

	
	public static  List<eu.europa.ec.fisheries.wsdl.user.types.Organisation>
	   convertInformationModelToUserModel(List<eu.europa.ec.mare.usm.information.domain.Organisation> 
	   domainOrganisationList) {
		if (domainOrganisationList == null || domainOrganisationList.isEmpty()) {
		    return null;
		}
	    
		List<eu.europa.ec.fisheries.wsdl.user.types.Organisation> typesOrganisation =
				new ArrayList<eu.europa.ec.fisheries.wsdl.user.types.Organisation>();
		for (eu.europa.ec.mare.usm.information.domain.Organisation orgDomain: domainOrganisationList) {
			typesOrganisation.add(convertInformationModelToUserModel(orgDomain));
		}
		
		return typesOrganisation;
	}
	
}