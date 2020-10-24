package eu.europa.ec.fisheries.uvms.user.auth;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/authentication")
public class UserAuthenticationApplication extends Application {

	private final Set<Object> singletons = new HashSet<>();
	private final Set<Class<?>> classes = new HashSet<>();

	public UserAuthenticationApplication() {
		classes.add(AuthenticationResource.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
