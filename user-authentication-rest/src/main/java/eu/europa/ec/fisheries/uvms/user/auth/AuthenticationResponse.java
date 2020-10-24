package eu.europa.ec.fisheries.uvms.user.auth;

import java.util.Map;

/**
 * The authentication response expected by the front-end.
 * <p>
 * Flattened copy of {@code eu.europa.ec.mare.usm.administration.domain.AuthenticationJwtResponse} from USM.
 */
public class AuthenticationResponse {

	/**
	 * Indicates that the requested operation completed successfully.
	 *
	 **/
	public static final int SUCCESS = 0;
	/**
	 * Indicates an internal error.
	 * The server is unable to respond with a more specific error and is also
	 * unable to properly respond to a request. It does not indicate that the
	 * client has sent an erroneous message.
	 **/
	public static final int INTERNAL_ERROR = 1;
	/**
	 * Indicates that the client passed either an incorrect user name or password.
	 */
	public static final int INVALID_CREDENTIALS = 49;
	/**
	 * Indicates an unknown error condition.
	 */
	public static final int OTHER = 80;
	/**
	 * Indicates that the login time is invalid.
	 */
	public static final int INVALID_TIME = 530;
	/**
	 * Indicates that the Account is disabled.
	 */
	public static final int ACCOUNT_DISABLED = 533;
	/**
	 * Indicates that the password has expired.
	 */
	public static final int PASSWORD_EXPIRED = 701;
	/**
	 * Indicates that the Account is locked.
	 */
	public static final int ACCOUNT_LOCKED = 775;
	/**
	 * Indicates that the user must change password.
	 */
	public static final int MUST_CHANGE_PASSWORD = 773;

	public static final int MAXIMUM_SESSION_NUMBER_EXCEEDED = 774;

	private boolean authenticated = false;
	private int statusCode = OTHER;
	private String errorDescription = "";
	private Map<String, Object> userMap;
	private String JWToken;
	private String ip;
	private String sessionId;

	@Override
	public String toString() {
		return "AuthenticationJwtResponse [JWToken=" + JWToken + ", ip=" + ip
				+ ", sessionId=" + sessionId + "]";
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Map<String, Object> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, Object> userMap) {
		this.userMap = userMap;
	}

	public String getJWToken() {
		return JWToken;
	}

	public void setJWToken(String JWToken) {
		this.JWToken = JWToken;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
