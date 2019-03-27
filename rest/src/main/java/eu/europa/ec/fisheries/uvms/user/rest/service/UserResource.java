package eu.europa.ec.fisheries.uvms.user.rest.service;

import eu.europa.ec.fisheries.uvms.user.service.UserService;
import eu.europa.ec.fisheries.uvms.user.service.exception.UserServiceException;
import eu.europa.ec.fisheries.wsdl.user.module.GetAllOrganisationRequest;
import eu.europa.ec.fisheries.wsdl.user.types.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Stateless
@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class UserResource {

    private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

    @EJB
    private UserService userService;

    @Context
    private HttpServletRequest httpServletRequest;

    @PUT
    @Path("/updateUserPreferences")
    public Response updateUserPreferences(UserContext userContext) {
        LOG.info("getUserContext invoked in rest layer");
        try {
            userService.updateUserPreferences(userContext);
            return Response.ok().build();
        } catch (UserServiceException | NullPointerException ex) {
            LOG.error("[ Error when updating User Preferences. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @GET
    @Path("/getOrganisation")
    public Response getOrganisation(@QueryParam("organisationName") String organisationName) {
        try {
            Organisation organisation = userService.getOrganisation(organisationName);
            return Response.ok(organisation).build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when fetching Organisation. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @POST
    @Path("/getAllOrganisations")
    public Response getAllOrganisations(GetAllOrganisationRequest request) {
        try {
            List<Organisation> allOrganisations = userService.getAllOrganisations(request);
            return Response.ok(allOrganisations).build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when fetching all Organisations. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @GET
    @Path("/findOrganisations")
    public Response findOrganisations(@QueryParam("nationIsoName") String nationIsoName) {
        try {
            List<Organisation> organisations = userService.findOrganisations(nationIsoName);
            return Response.ok(organisations).build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when finding Organisations. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @GET
    @Path("/getContactDetails")
    public Response getContactDetails() {
        try {
            ContactDetails contactDetails = userService.getContactDetails(httpServletRequest.getRemoteUser());
            return Response.ok(contactDetails).build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when fetching ContactDetails. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @PUT
    @Path("/putPreference")
    public Response putPreference(UserPreference userPreference) {
        try {
            userService.putPreference(userPreference);
            return Response.ok().build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when updating Preferences. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @POST
    @Path("/createDataset")
    public Response createDataset(DatasetExtension dataset) {
        try {
            userService.createDataset(dataset);
            return Response.ok().build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when creating DataSet. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @DELETE
    @Path("/deleteDataset")
    public Response deleteDataset(@QueryParam("name") String name,
                                  @QueryParam("applicationName") String applicationName) {

        DatasetExtension datasetExtension = createDatasetExtension(name, applicationName);

        try {
            userService.deleteDataset(datasetExtension);
            return Response.ok().build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when deleting DataSet. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @PUT
    @Path("/updateDataset")
    public Response updateDataset(DatasetExtension dataset) {
        try {
            userService.updateDataset(dataset);
            return Response.ok().build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when updating DataSet. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    @POST
    @Path("/findDataset")
    public Response findDataset(DatasetFilter datasetFilter) {
        try {
            DatasetList datasetList = userService.findDataset(datasetFilter);
            return Response.ok(datasetList).build();
        } catch (UserServiceException ex) {
            LOG.error("[ Error when finding DataSet. ]", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
        }
    }

    private DatasetExtension createDatasetExtension(String name, String applicationName) {
        DatasetExtension datasetExtension = new DatasetExtension();
        datasetExtension.setName(name);
        datasetExtension.setApplicationName(applicationName);
        datasetExtension.setCategory("");
        datasetExtension.setDiscriminator("");
        datasetExtension.setDescription("");
        return datasetExtension;
    }

}
