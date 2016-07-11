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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class RoleConverter {
    /*
	Information-Model
	package eu.europa.ec.mare.usm.information.domain;
	  private String roleName;
      private Set<Feature> features;
      
    user-model
    package eu.europa.ec.fisheries.wsdl.user.types;
      protected String roleName;
      protected List<Feature> feature;
	
	
	
	
	*/
	
	
	public static eu.europa.ec.fisheries.wsdl.user.types.Role 
		convertInformationModelToUserModel(eu.europa.ec.mare.usm.information.domain.Role domainRole)
		{
		eu.europa.ec.fisheries.wsdl.user.types.Role typesRole =
				new eu.europa.ec.fisheries.wsdl.user.types.Role();
		typesRole.setRoleName(domainRole.getRoleName());
		
		/*List<eu.europa.ec.fisheries.wsdl.user.types.Feature> typesFeatures =
				new ArrayList<eu.europa.ec.fisheries.wsdl.user.types.Feature>();*/
		Set<eu.europa.ec.mare.usm.information.domain.Feature> domainFeatures =
				domainRole.getFeatures();
		Iterator<eu.europa.ec.mare.usm.information.domain.Feature> iterator = 
				domainFeatures.iterator();
		
		while(iterator.hasNext()) {
			eu.europa.ec.mare.usm.information.domain.Feature domainFeatureElement = iterator.next();
			eu.europa.ec.fisheries.wsdl.user.types.Feature typesFeatureElement = 
					FeatureConverter.convertDomainInformationModelToUserModel(domainFeatureElement);
			/*typesFeatures.add(typesFeatureElement);*/
			typesRole.getFeature().add(typesFeatureElement);
		}
		
		 
		
		return typesRole;
		}
	
	public static eu.europa.ec.mare.usm.information.domain.Role 
	convertUserModelToInformationService(eu.europa.ec.fisheries.wsdl.user.types.Role typesRole)
	{
		eu.europa.ec.mare.usm.information.domain.Role  domainRole = 
				new eu.europa.ec.mare.usm.information.domain.Role();
		domainRole.setRoleName(typesRole.getRoleName());
		
		Set<eu.europa.ec.mare.usm.information.domain.Feature> domainFeatures = new HashSet<eu.europa.ec.mare.usm.information.domain.Feature>();
		domainRole.setFeatures(domainFeatures);
		
		List<eu.europa.ec.fisheries.wsdl.user.types.Feature> typesFeatures = 
				typesRole.getFeature();
		Iterator<eu.europa.ec.fisheries.wsdl.user.types.Feature> iterator = typesFeatures.iterator();
		while(iterator.hasNext())
		{
			eu.europa.ec.fisheries.wsdl.user.types.Feature typesFeatureElement = iterator.next();
			eu.europa.ec.mare.usm.information.domain.Feature domainFeatureElement = FeatureConverter.convertUserModelToDomainInformationModel(typesFeatureElement);
			domainFeatures.add(domainFeatureElement);
		}
		
		return domainRole;
	}
}