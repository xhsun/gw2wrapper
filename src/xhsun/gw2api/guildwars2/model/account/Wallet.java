package xhsun.gw2api.guildwars2.model.account;

import xhsun.gw2api.guildwars2.model.Currency;

/**
 * For more info on Wallet API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">here</a><br/>
 * Wallet item model class<br/>
 * Note: for empty item, it can either have a value of zero or not in the list
 * @see Currency currency info
 * @author xhsun
 * @since 2017-02-07
 */

public class Wallet {
	private long id;
	private long value;

	public long getId() {
		return id;
	}

	public long getValue() {
		return value;
	}

	@Override
	public String toString(){
		return "{Currency ID: "+id+" Value: "+value+"}";
	}
}
