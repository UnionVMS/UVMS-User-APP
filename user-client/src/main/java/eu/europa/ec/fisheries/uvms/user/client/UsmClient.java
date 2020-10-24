package eu.europa.ec.fisheries.uvms.user.client;

import java.util.List;

/**
 * Client to interesting USM services.
 */
public interface UsmClient {
	/**
	 * Find features for the given user.
	 *
	 * @param username The user name
	 * @return A list of fetures (codes)
	 */
	List<Integer> findFeatures(String username);
}
