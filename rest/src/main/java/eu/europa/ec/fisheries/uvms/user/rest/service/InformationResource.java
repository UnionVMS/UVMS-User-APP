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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseCode;
import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseDto;
import eu.europa.ec.fisheries.uvms.user.service.UserService;
import eu.europa.ec.fisheries.uvms.user.service.exception.UserServiceException;
import eu.europa.ec.fisheries.wsdl.user.types.Application;
import eu.europa.ec.fisheries.wsdl.user.types.UserContextId;
import eu.europa.ec.fisheries.wsdl.user.types.UserPreference;

/**
 *
 */
@Path("/user")
@Stateless
public class InformationResource {
    private static final Logger LOG = LoggerFactory.getLogger(InformationResource.class);

    @EJB
    UserService userService;

    @GET
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Path("/userContext")
    public ResponseDto getUserContext(@QueryParam(value = "applicationName") final String applicationName,
            @QueryParam(value = "userName") final String userName) { 

        LOG.info("getUserContext invoked in rest layer");
        try {
            UserContextId userContextId = new UserContextId();
            userContextId.setApplicationName(applicationName);
            userContextId.setUserName(userName);

            
            return new ResponseDto(userService.getUserContext(userContextId), ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when getUserContext. ]", ex);
            return new ResponseDto(ex.getMessage(), ResponseCode.ERROR);
        }

    }    
    
    @POST
    @Consumes(value = {MediaType.APPLICATION_XML})
    @Produces(value = {MediaType.APPLICATION_XML})
    @Path("/preference")
    public ResponseDto createPeference(UserPreference userPreference) {
        LOG.info("createPeference invoked in rest layer");
        try {
            userService.createPreference(userPreference);
            return new ResponseDto(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when createPeference. ]", ex);
            return new ResponseDto(ex.getMessage(), ResponseCode.ERROR);
        }        
        
    }
    
    @PUT
    @Consumes(value = {MediaType.APPLICATION_XML})
    @Produces(value = {MediaType.APPLICATION_XML})
    @Path("/preference")
    public ResponseDto updatePreference(UserPreference userPreference) {
        LOG.info("updatePreference invoked in rest layer");
        try {
            userService.updatePreference(userPreference);
            return new ResponseDto(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when updatePreference. ]", ex);
            return new ResponseDto(ex.getMessage(), ResponseCode.ERROR);
        }        
        
    }
    
    @DELETE
    @Produces(value = {MediaType.APPLICATION_XML})
    @Path("/preference")
    public ResponseDto deletePreference(UserPreference userPreference) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.deletePreference(userPreference);
            return new ResponseDto(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deletePeference. ]", ex);
            return new ResponseDto(ex.getMessage(), ResponseCode.ERROR);
        }        
        
    }
   
        
        
}