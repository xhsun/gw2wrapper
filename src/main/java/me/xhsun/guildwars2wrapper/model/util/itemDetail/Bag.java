package me.xhsun.guildwars2wrapper.model.util.itemDetail;

/**
 * For more info on Bag detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Bag">here</a><br/>
 * Item detail for Bag
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Bag extends ItemDetail {
	public int getSize() {
		return size;
	}

	private boolean isInvisible() {
		return no_sell_or_sort;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Bag bag = (Bag) o;

		return size == bag.size && no_sell_or_sort == bag.no_sell_or_sort;
	}

	@Override
	public int hashCode() {
		int result = size;
		result = 31 * result + (no_sell_or_sort ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Bag{" +
				"size=" + size +
				", no_sell_or_sort=" + no_sell_or_sort +
				'}';
	}
}
