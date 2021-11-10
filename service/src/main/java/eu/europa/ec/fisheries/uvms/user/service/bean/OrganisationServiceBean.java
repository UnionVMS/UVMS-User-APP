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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import eu.europa.ec.fisheries.uvms.user.service.OrganisationService;
import eu.europa.ec.fisheries.uvms.user.service.converter.OrganizationMapper;
import eu.europa.ec.fisheries.uvms.user.service.dao.OrganisationDao;
import eu.europa.ec.fisheries.uvms.user.service.dto.OrganisationDto;
import eu.europa.ec.fisheries.uvms.user.service.entity.OrganisationChannelEntityId;

@ApplicationScoped
@Transactional
public class OrganisationServiceBean implements OrganisationService {

    private OrganisationDao organisationDao;
    private OrganizationMapper organizationMapper;

    @Inject
    public OrganisationServiceBean(OrganisationDao organisationDao,OrganizationMapper organizationMapper){
        this.organisationDao = organisationDao;
        this.organizationMapper = organizationMapper;
    }

    /**
     * Default constructor for frameworks.
     */
    @SuppressWarnings("unused")
    OrganisationServiceBean() {
        // NOOP
    }

    @Override
    public Optional<OrganisationChannelEntityId> findOrganizationByEndpointAndChannel(String dataFlow, String endpointName) {
        List<OrganisationChannelEntityId> result = organisationDao.findOrganizationByDataFlowAndEndpoint(dataFlow, endpointName);
        return result.stream().findFirst();
    }

    @Override
    public List<OrganisationDto> findOrganisationsWithEndPointsAndChannels() {
        return organisationDao.findOrganisations().stream()
                .map(e -> organizationMapper.organisationEntityToOrganisationDto(e))
                .collect(Collectors.toList());
    }
}
