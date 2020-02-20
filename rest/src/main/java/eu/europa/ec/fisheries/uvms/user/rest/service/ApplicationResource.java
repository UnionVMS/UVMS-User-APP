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

import eu.europa.ec.fisheries.uvms.user.service.UserService;
import eu.europa.ec.fisheries.uvms.user.service.exception.UserServiceException;
import eu.europa.ec.fisheries.wsdl.user.types.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response getApplication(@PathParam("applicationName") String applicationName) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.getDeploymentDescriptor(applicationName);
            return Response.ok().type(MediaType.APPLICATION_XML).build();
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Path("/application")
    public Response deployApplication(Application application) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.deployApplication(application);
            return Response.ok().type(MediaType.APPLICATION_XML).build();
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/application")
    public Response redeployApplication(Application application) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.redeployApplication(application);
            return Response.ok().type(MediaType.APPLICATION_XML).build();
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/application/{applicationName}")
    public Response undeployApplication(@PathParam("applicationName") String applicationName) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.undeployApplication(applicationName);
            return Response.ok().type(MediaType.APPLICATION_XML).build();
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }
}
