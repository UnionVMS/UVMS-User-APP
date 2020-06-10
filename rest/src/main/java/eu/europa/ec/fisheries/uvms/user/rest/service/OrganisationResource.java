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
package eu.europa.ec.fisheries.uvms.user.rest.service;

import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseCode;
import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseDto;
import eu.europa.ec.fisheries.uvms.user.service.OrganisationService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.europa.ec.fisheries.uvms.user.service.dto.OrganisationDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * EndPoint for organisations
 */
@Path("/organisations")
@Stateless
@Slf4j
public class OrganisationResource {

    @Inject
    private OrganisationService organisationService;

    @GET
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Path("/withEndPointsAndChannels")
    public ResponseDto<List<OrganisationDto>> getOrganisationsWithEndPointsAndChannels() {
        log.debug("getOrganisationsWithEndPointsAndChannels invoked in rest layer");
        return new ResponseDto<>(organisationService.findOrganisationsWithEndPointsAndChannels(), ResponseCode.OK);
    }
}
