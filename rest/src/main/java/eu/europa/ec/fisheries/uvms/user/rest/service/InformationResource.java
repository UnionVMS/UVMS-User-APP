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

import eu.europa.ec.fisheries.uvms.commons.date.JsonBConfigurator;
import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseCode;
import eu.europa.ec.fisheries.uvms.user.rest.dto.ResponseDto;
import eu.europa.ec.fisheries.uvms.user.service.UserService;
import eu.europa.ec.fisheries.uvms.user.service.exception.UserServiceException;
import eu.europa.ec.fisheries.wsdl.user.types.UserContext;
import eu.europa.ec.fisheries.wsdl.user.types.UserContextId;
import eu.europa.ec.fisheries.wsdl.user.types.UserPreference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.bind.Jsonb;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Stateless
@Consumes(value = {MediaType.APPLICATION_XML})
@Produces(value = {MediaType.APPLICATION_XML})
public class InformationResource {
    private static final Logger LOG = LoggerFactory.getLogger(InformationResource.class);

    @EJB
    private UserService userService;

    private Jsonb jsonb;

    @PostConstruct
    public void init() {
        jsonb = new JsonBConfigurator().getContext(null);
    }

    @GET
    @Consumes(value = {MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Path("/userContext")
    public ResponseDto<?> getUserContext(@QueryParam(value = "applicationName") final String applicationName,
                                         @QueryParam(value = "userName") final String userName) {

        LOG.info("getUserContext invoked in rest layer");
        try {
            UserContextId userContextId = new UserContextId();
            userContextId.setApplicationName(applicationName);
            userContextId.setUserName(userName);
            UserContext userContext = userService.getUserContext(userContextId);
            String returnString = jsonb.toJson(userContext);
            return new ResponseDto<>(returnString, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when getUserContext. ]", ex);
            return new ResponseDto<>(ex.getMessage(), ResponseCode.ERROR);
        }
    }

    @POST
    @Path("/preference")
    public ResponseDto<?> createPeference(UserPreference userPreference) {
        LOG.info("createPreference invoked in rest layer");
        try {
            userService.createPreference(userPreference);
            return new ResponseDto<>(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when createPreference. ]", ex);
            return new ResponseDto<>(ex.getMessage(), ResponseCode.ERROR);
        }
    }

    @PUT
    @Path("/preference")
    public ResponseDto<?> updatePreference(UserPreference userPreference) {
        LOG.info("updatePreference invoked in rest layer");
        try {
            userService.updatePreference(userPreference);
            return new ResponseDto<>(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when updatePreference. ]", ex);
            return new ResponseDto<>(ex.getMessage(), ResponseCode.ERROR);
        }
    }

    @DELETE
    @Path("/preference")
    public ResponseDto<?> deletePreference(UserPreference userPreference) {
        LOG.info("deployApplication invoked in rest layer");
        try {
            userService.deletePreference(userPreference);
            return new ResponseDto<>(null, ResponseCode.OK);
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when deletePeference. ]", ex);
            return new ResponseDto<>(ex.getMessage(), ResponseCode.ERROR);
        }
    }
}
