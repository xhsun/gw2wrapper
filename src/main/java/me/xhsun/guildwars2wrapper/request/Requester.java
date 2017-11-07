/**
 * 
 */
package me.xhsun.guildwars2wrapper.request;

import java.util.*;
import java.util.function.Consumer;

import me.xhsun.guildwars2wrapper.GuildWars2;

/**
 * The class to utilize all request handling. 
 * You can use it to handle common tasks with same error handler or/and validation.
 * 
 * @author levvy055
 * @since 2017-10-31
 *
 */
public final class Requester {
	private static List<Requester> instances = new ArrayList<>();
	private Gw2Request requestExecutioner;
	
	private Requester(GuildWars2 gw2) {
		if(gw2==null) {
			throw new NullPointerException("GuildWars2 instance can't be null");
		}
		requestExecutioner = new Gw2Request(gw2);
	}

	/**
	 * Creates new object of Requester with specified {@link GuildWars2} object
	 * 
	 * @param gw2
	 * @return new instance of {@link Requester}
	 */
	public static Requester getNewInstance(GuildWars2 gw2) {
		Requester r = new Requester(gw2);
		instances.add(r);
		return r;
	}

	/**
	 * Gets currently set {@link RequestType}
	 * 
	 * @return {@link RequestType}
	 */
	public RequestType getRequestType() {
		return requestExecutioner.getRequestType();
	}

	/**
	 * Sets {@link RequestType} to be done on next requests
	 * 
	 * @param requestType
	 *            {@link RequestType}
	 */
	public void setRequestType(RequestType requestType) {
		this.requestExecutioner.setRequestType(requestType);
	}
	
	public void setFailedAction(Consumer<Throwable> failedCallback) {
		requestExecutioner.setFailedAction(failedCallback);		
	}
	
	/**
	 * Used to make a request of sync/async type
	 * 
	 * @return object to make requests on
	 */
	public Gw2Request request() {
		return requestExecutioner;
	}

	/**
	 * Shorter name of {@link Requester#request()}
	 * 
	 * @return object to make requests on
	 */
	public Gw2Request req() {
		return request();
	}
}
