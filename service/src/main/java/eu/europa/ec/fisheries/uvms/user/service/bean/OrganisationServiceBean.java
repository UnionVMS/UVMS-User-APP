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

import eu.europa.ec.fisheries.uvms.user.service.OrganisationService;
import eu.europa.ec.fisheries.uvms.user.service.dao.OrganisationDao;
import eu.europa.ec.fisheries.uvms.user.service.dto.OrganizationByEndpointAndChannelDto;
import eu.europa.ec.fisheries.uvms.user.service.entity.OrganisationChannelEntityId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class OrganisationServiceBean implements OrganisationService {

    private OrganisationDao organisationDao;

    @Inject
    public OrganisationServiceBean(OrganisationDao organisationDao){
        this.organisationDao = organisationDao;
    }

    @Override
    public OrganizationByEndpointAndChannelDto findOrganizationByEndpointAndChannel(String dataFlow,String endpointName) {
        List<OrganisationChannelEntityId> channelByDataFlow = organisationDao.findOrganizationByDataFlowAndEndpointName(dataFlow,endpointName);
        OrganizationByEndpointAndChannelDto responseDTO = new OrganizationByEndpointAndChannelDto();

        if(channelByDataFlow.isEmpty() ) {
            return  responseDTO;
        }

        if(channelByDataFlow.size() > 1 ) {
            throw new IllegalArgumentException("There are more than one results for the given argument. Cannot return a single Object.");
        }

        responseDTO.setChannelId(channelByDataFlow.get(0).getChannelId());
        responseDTO.setEndpointId(channelByDataFlow.get(0).getEndpointId());
        responseDTO.setOrganisationId(channelByDataFlow.get(0).getOrganisationId());
        return  responseDTO;
    }

}
