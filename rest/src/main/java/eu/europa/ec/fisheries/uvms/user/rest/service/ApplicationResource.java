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

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseCode;
import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseDto;
import eu.europa.ec.fisheries.uvms.user.service.UserService;
import eu.europa.ec.fisheries.uvms.user.service.exception.UserServiceException;
import eu.europa.ec.fisheries.wsdl.user.types.Application;

/**
 *
 */
@Path("/user")
@Stateless
public class ApplicationResource {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationResource.class);

    @EJB
    UserService userService;
    
    @GET
    @Produces(value = {MediaType.APPLICATION_XML})
    @Path("/application/{applicationName}")
    public ResponseDto getApplication(@PathParam("applicationName") String applicationName) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.getDeploymentDescriptor(applicationName);
            return new ResponseDto(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return new ResponseDto(ex.getMessage(), ResponseCode.ERROR);
        }        
        
    }     
    
    @POST
    @Consumes(value = {MediaType.APPLICATION_XML})
    @Produces(value = {MediaType.APPLICATION_XML})
    @Path("/application")
    public ResponseDto deployApplication(Application application) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.deployApplication(application);
            return new ResponseDto(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return new ResponseDto(ex.getMessage(), ResponseCode.ERROR);
        }        
        
    }
    
    @PUT
    @Consumes(value = {MediaType.APPLICATION_XML})
    @Produces(value = {MediaType.APPLICATION_XML})
    @Path("/application")
    public ResponseDto redeployApplication(Application application) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.redeployApplication(application);
            return new ResponseDto(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return new ResponseDto(ex.getMessage(), ResponseCode.ERROR);
        }        
        
    }
    
    @DELETE
    @Produces(value = {MediaType.APPLICATION_XML})
    @Path("/application/{applicationName}")
    public ResponseDto undeployApplication(@PathParam("applicationName") String applicationName) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.undeployApplication(applicationName);
            return new ResponseDto(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deployApplication. ]", ex);
            return new ResponseDto(ex.getMessage(), ResponseCode.ERROR);
        }        
        
    }    
    
}