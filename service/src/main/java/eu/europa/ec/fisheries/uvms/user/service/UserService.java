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
package eu.europa.ec.fisheries.uvms.user.service;

import java.util.List;

import javax.ejb.Local;

import eu.europa.ec.fisheries.uvms.user.service.exception.UserServiceException;
import eu.europa.ec.fisheries.wsdl.user.types.Application;
import eu.europa.ec.fisheries.wsdl.user.types.ContactDetails;
import eu.europa.ec.fisheries.wsdl.user.types.DatasetExtension;
import eu.europa.ec.fisheries.wsdl.user.types.DatasetFilter;
import eu.europa.ec.fisheries.wsdl.user.types.DatasetList;
import eu.europa.ec.fisheries.wsdl.user.types.Organisation;
import eu.europa.ec.fisheries.wsdl.user.types.UserContext;
import eu.europa.ec.fisheries.wsdl.user.types.UserContextId;
import eu.europa.ec.fisheries.wsdl.user.types.UserPreference;

@Local
public interface UserService {

    /**
     * Retrieve user context based on specified request
     * 
     * @param request
     * @return
     * @throws UserServiceException
     */
    public UserContext getUserContext(UserContextId request) throws UserServiceException;
    
    public void updateUserPreferences(UserContext request) throws UserServiceException;    

    public void deployApplication(Application application) throws UserServiceException;
    
    public void redeployApplication(Application application) throws UserServiceException;
    
    public void undeployApplication(String request) throws UserServiceException;
    
    public Application getDeploymentDescriptor(String applicationName) throws UserServiceException;
    
    public Organisation getOrganisation(String organisationName) throws UserServiceException;
    
    public List<Organisation> findOrganisations(String nationIsoName) throws UserServiceException;
    
    public ContactDetails getContactDetails(String userName) throws UserServiceException;
    
    public void putPreference(UserPreference userPreference) throws UserServiceException;
    
    public void createPreference(UserPreference userPreference) throws UserServiceException;
    
    public void deletePreference(UserPreference userPreference) throws UserServiceException;
    
    public void updatePreference(UserPreference userPreference) throws UserServiceException;
    
    public void createDataset(DatasetExtension dataset) throws UserServiceException;
    
    public void deleteDataset(DatasetExtension dataset) throws UserServiceException;
    
    public void updateDataset(DatasetExtension dataset) throws UserServiceException;
    
    public DatasetList findDataset(DatasetFilter datasetFilter) throws UserServiceException;
    

}