package eu.europa.ec.fisheries.uvms.user.client;

/**
 * Exception thrown by the user client.
 */
public class UserClientException extends RuntimeException {
	public UserClientException() {
	}

	public UserClientException(Throwable throwable) {
		super(throwable);
	}
}
