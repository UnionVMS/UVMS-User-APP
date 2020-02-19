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
import eu.europa.ec.fisheries.uvms.user.service.UserService;
import eu.europa.ec.fisheries.uvms.user.service.exception.UserServiceException;
import eu.europa.ec.fisheries.wsdl.user.types.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Stateless
@Consumes(value = {MediaType.APPLICATION_XML})
@Produces(value = {MediaType.APPLICATION_XML})
public class ApplicationResource {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationResource.class);

    @EJB
    private UserService userService;

    @GET
    @Path("/application/{applicationName}")
    public ResponseDto<?> getApplication(@PathParam("applicationName") String applicationName) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.getDeploymentDescriptor(applicationName);
            return new ResponseDto<>(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return new ResponseDto<>(ex.getMessage(), ResponseCode.ERROR);
        }
    }

    @POST
    @Path("/application")
    public ResponseDto<?> deployApplication(Application application) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.deployApplication(application);
            return new ResponseDto<>(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return new ResponseDto<>(ex.getMessage(), ResponseCode.ERROR);
        }
    }

    @PUT
    @Path("/application")
    public ResponseDto<?> redeployApplication(Application application) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.redeployApplication(application);
            return new ResponseDto<>(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return new ResponseDto<>(ex.getMessage(), ResponseCode.ERROR);
        }
    }

    @DELETE
    @Path("/application/{applicationName}")
    public ResponseDto<?> undeployApplication(@PathParam("applicationName") String applicationName) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.undeployApplication(applicationName);
            return new ResponseDto<>(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return new ResponseDto<>(ex.getMessage(), ResponseCode.ERROR);
        }
    }
}
