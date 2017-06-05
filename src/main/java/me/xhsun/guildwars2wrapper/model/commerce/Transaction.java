package me.xhsun.guildwars2wrapper.model.commerce;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * For more info on Transaction API go <a href="https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">here</a><br/>
 * Player but/sell list model class<br/>
 * Note: purchased only applied in history<br/>
 * Note: price are in coins
 *
 * @author xhsun
 * @see me.xhsun.guildwars2wrapper.model.Item item info
 * @since 2017-02-07
 */

public class Transaction {
	public enum Time {Current, History}

	public enum Type {Buy, Sell}

	private long id;
	private long item_id;
	private long price;
	private int quantity;
	private String created;
	private String purchased;//not applied in current

	public long getId() {
		return id;
	}

	public long getItem_id() {
		return item_id;
	}

	public long getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public DateTime getCreated() {
		if (created == null) return null;
		DateTimeFormatter formatter = ISODateTimeFormat.dateTimeNoMillis();
		return formatter.parseDateTime(created);
	}

	public DateTime getPurchased() {
		if (purchased == null) return null;
		DateTimeFormatter formatter = ISODateTimeFormat.dateTimeNoMillis();
		return formatter.parseDateTime(purchased);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Transaction that = (Transaction) o;

		return id == that.id;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"id=" + id +
				", item_id=" + item_id +
				", price=" + price +
				", quantity=" + quantity +
				", created='" + created + '\'' +
				", purchased='" + purchased + '\'' +
				'}';
	}
}
