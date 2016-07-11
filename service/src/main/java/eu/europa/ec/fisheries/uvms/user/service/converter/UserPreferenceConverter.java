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

public class UserPreferenceConverter {

	public static eu.europa.ec.fisheries.wsdl.user.types.UserPreference 
    convertInformationModelToUserModel(eu.europa.ec.mare.usm.information.domain.UserPreference domainUserPreference)
    {
    if (domainUserPreference == null) {
        return null;
    }
    
	eu.europa.ec.fisheries.wsdl.user.types.UserPreference typesUserPreference = 
			new eu.europa.ec.fisheries.wsdl.user.types.UserPreference();
	if (domainUserPreference != null) {
		typesUserPreference.setApplicationName(domainUserPreference.getApplicationName());
		typesUserPreference.setUserName(domainUserPreference.getUserName());
		typesUserPreference.setRoleName(domainUserPreference.getRoleName());   
		typesUserPreference.setScopeName(domainUserPreference.getScopeName());
		typesUserPreference.setOptionName(domainUserPreference.getOptionName());
		typesUserPreference.setOptionValue(domainUserPreference.getOptionValue());
	}
	
	return typesUserPreference;
    }

public static eu.europa.ec.mare.usm.information.domain.UserPreference 
   convertUserModelToInformationModel(eu.europa.ec.fisheries.wsdl.user.types.UserPreference typesUserPreference)
   {
	eu.europa.ec.mare.usm.information.domain.UserPreference domainUserPreference  = 
			new eu.europa.ec.mare.usm.information.domain.UserPreference();
	domainUserPreference.setApplicationName(typesUserPreference.getApplicationName());
	domainUserPreference.setUserName(typesUserPreference.getUserName());
	domainUserPreference.setRoleName(typesUserPreference.getRoleName());
	domainUserPreference.setScopeName(typesUserPreference.getScopeName());
	domainUserPreference.setOptionName(typesUserPreference.getOptionName());
	domainUserPreference.setOptionValue(typesUserPreference.getOptionValue());
	return domainUserPreference;
   }
	
	
	
}