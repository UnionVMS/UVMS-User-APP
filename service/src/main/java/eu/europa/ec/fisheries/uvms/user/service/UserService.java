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

import eu.europa.ec.fisheries.uvms.user.service.exception.UserServiceException;
import eu.europa.ec.fisheries.wsdl.user.types.*;

import javax.ejb.Local;
import java.util.List;

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

    public List<Organisation> getAllOrganisations() throws UserServiceException;

//    public Organisation getOrganisationDetailsById(String organisationId) throws UserServiceException;

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