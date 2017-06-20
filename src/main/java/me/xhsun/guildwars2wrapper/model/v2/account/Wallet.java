package me.xhsun.guildwars2wrapper.model.v2.account;

import me.xhsun.guildwars2wrapper.model.v2.Currency;

/**
 * For more info on Wallet API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">here</a><br/>
 * Wallet item model class<br/>
 * Note: for empty item, it can either have a value of zero or not in the list
 *
 * @author xhsun
 * @see Currency currency info
 * @since 2017-02-07
 */

public class Wallet {
	private int id;
	private long value;

	public int getCurrencyId() {
		return id;
	}

	public long getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Wallet wallet = (Wallet) o;

		return id == wallet.id && value == wallet.value;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (int) (value ^ (value >>> 32));
		return result;
	}
}
