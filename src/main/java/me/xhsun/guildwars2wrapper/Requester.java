/**
 * 
 */
package me.xhsun.guildwars2wrapper;

import java.util.*;
import java.util.function.Consumer;

import me.xhsun.guildwars2wrapper.request.*;

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
	
	public Requester getNewInstance(GuildWars2 gw2) {
		Requester r = new Requester(gw2);
		instances.add(r);
		return r;
	}

	public RequestType getRequestType() {
		return requestExecutioner.getRequestType();
	}

	public void setRequestType(RequestType requestType) {
		this.requestExecutioner.setRequestType(requestType);
	}
	
	public void setFailedAction(Consumer<Throwable> failedCallback) {
		requestExecutioner.setFailedAction(failedCallback);		
	}
	
	public Gw2Request request() {
		return requestExecutioner;
	}
}
