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
package eu.europa.ec.fisheries.uvms.user.service.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.europa.ec.fisheries.uvms.user.message.consumer.UserMessageConsumer;
import eu.europa.ec.fisheries.uvms.user.message.producer.UserMessageProducer;
import eu.europa.ec.fisheries.uvms.user.service.ParameterService;
import eu.europa.ec.fisheries.uvms.user.service.UserService;
import eu.europa.ec.fisheries.uvms.user.service.converter.ApplicationConverter;
import eu.europa.ec.fisheries.uvms.user.service.converter.ContactDetailsConverter;
import eu.europa.ec.fisheries.uvms.user.service.converter.DatasetConverter;
import eu.europa.ec.fisheries.uvms.user.service.converter.OrganisationConverter;
import eu.europa.ec.fisheries.uvms.user.service.converter.UserContextConverter;
import eu.europa.ec.fisheries.uvms.user.service.converter.UserPreferenceConverter;
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
import eu.europa.ec.mare.usm.information.domain.UserContextQuery;
import eu.europa.ec.mare.usm.information.service.DeploymentService;
import eu.europa.ec.mare.usm.information.service.InformationService;

@Stateless
public class UserServiceBean implements UserService {

    final static Logger LOG = LoggerFactory.getLogger(UserServiceBean.class);

    @EJB
    ParameterService parameterService;

    @EJB
    UserMessageConsumer consumer;

    @EJB
    UserMessageProducer producer;

    @EJB
    InformationService informationService;
    
    @EJB
    DeploymentService deploymentService;
    
    
    // final UserContextProxy userContextProxy = new UserContextProxy();

    /**
     * {@inheritDoc}
     *
     * @param getUserContextRequest
     * @throws UserServiceException
     */
    public UserContext getUserContext(UserContextId userContextId) throws UserServiceException {
        
        UserContextQuery userContextQuery = UserContextConverter.convertToContextQuery(userContextId);
        
        UserContext userContext = UserContextConverter.convertInformationModelToUserModel(informationService.getUserContext(userContextQuery));        
        
        return userContext;
    }

    @Override
    public void updateUserPreferences(UserContext request) throws UserServiceException {
        informationService.updateUserPreferences(UserContextConverter.convertUserModelToInformationModel(request));
    }

    @Override
    public void deployApplication(Application application) throws UserServiceException {
        deploymentService.deployApplication(ApplicationConverter.convertUserModelToInformationModel(application));
    }

    @Override
    public void redeployApplication(Application application) throws UserServiceException {
        deploymentService.redeployApplication(ApplicationConverter.convertUserModelToInformationModel(application));
    }

    @Override
    public void undeployApplication(String request) throws UserServiceException {
        deploymentService.undeployApplication(request);
        
    }

    @Override
    public Application getDeploymentDescriptor(String applicationName) throws UserServiceException {
        return ApplicationConverter.convertInformationModelToUserModel(deploymentService.getDeploymentDescriptor(applicationName));                
    }

    @Override
    public Organisation getOrganisation(String organisationName) throws UserServiceException {
        return OrganisationConverter.convertInformationModelToUserModel(informationService.getOrganisation(organisationName));
    }
    
    @Override
    public List<Organisation> findOrganisations(String nationIsoName) throws UserServiceException {
        return OrganisationConverter.convertInformationModelToUserModel(
        		informationService.findOrganisations(nationIsoName));
    }

    @Override
    public ContactDetails getContactDetails(String userName) throws UserServiceException {
        return ContactDetailsConverter.convertInformationModelToUserModel( informationService.getContactDetails(userName));
        
    }

	@Override
	public void putPreference(UserPreference userPreference) throws UserServiceException {
		eu.europa.ec.mare.usm.information.domain.UserPreference pref =
			UserPreferenceConverter.convertUserModelToInformationModel(userPreference);
		eu.europa.ec.mare.usm.information.domain.UserPreference prefRetrieved = 
				informationService.getUserPreference(pref);
		if (prefRetrieved.getOptionName() == null) {
			informationService.createUserPreference(pref);
		} else {
			informationService.updateUserPreference(pref);
		}
	}
    
    @Override
	public void createPreference(UserPreference userPreference) throws UserServiceException {
		informationService.createUserPreference(UserPreferenceConverter.convertUserModelToInformationModel(userPreference));
	}

	@Override
	public void deletePreference(UserPreference userPreference) throws UserServiceException {
		informationService.deleteUserPreference(UserPreferenceConverter.convertUserModelToInformationModel(userPreference));	}

	@Override
	public void updatePreference(UserPreference userPreference) throws UserServiceException {
		informationService.updateUserPreference(UserPreferenceConverter.convertUserModelToInformationModel(userPreference));
	}

	@Override
	public void createDataset(DatasetExtension dataset) throws UserServiceException {
		informationService.createDataSet(DatasetConverter.convertUserModelToDomainInformationModel(dataset));
	}

	@Override
	public void deleteDataset(DatasetExtension dataset) throws UserServiceException {
		informationService.deleteDataSet(DatasetConverter.convertUserModelToDomainInformationModel(dataset));
	}

	@Override
	public void updateDataset(DatasetExtension dataset) throws UserServiceException {
		informationService.updateDataSet(DatasetConverter.convertUserModelToDomainInformationModel(dataset));
	}

	@Override
	public DatasetList findDataset(DatasetFilter datasetFilter) throws UserServiceException {
		return DatasetConverter.convertInformationModelToUserModel(informationService.getDataSets(DatasetConverter.convertUserModelToDomainInformationModel(datasetFilter)));
	}
    
	
}