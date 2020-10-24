package eu.europa.ec.fisheries.uvms.user.auth;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import java.util.List;

import eu.europa.ec.fisheries.uvms.user.client.UsmClient;
import eu.europa.ec.mare.usm.jwt.JwtTokenHandler;

@Path("/")
@ApplicationScoped
public class AuthenticationResource {

	@Context
	private HttpServletRequest request;

	@Inject
	private UsmClient usmClient;

	@Inject
	private JwtTokenHandler tokenHandler;

	@POST
	@Path("/authenticate")
	@Produces(value = {APPLICATION_JSON})
	public AuthenticationResponse authenticate() {
		AuthenticationResponse response = new AuthenticationResponse();
		if (request.getRemoteUser() != null) {
			response.setAuthenticated(true);
			response.setStatusCode(AuthenticationResponse.SUCCESS);
			response.setIp(request.getRemoteAddr());
			List<Integer> features = usmClient.findFeatures(request.getRemoteUser());
			response.setJWToken(tokenHandler.createToken(request.getRemoteUser(), features));
		}
		return response;
	}
}
