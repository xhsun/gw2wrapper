package me.xhsun.guildwars2wrapper.model.util.itemDetail;

/**
 * Item detail for Container, Gathering tools, Gizmo, Salvage kits<br/>
 * Note: getChrages() for Slavage kits only
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Utility extends ItemDetail {
	public Type getType() {
		return type;
	}

	public int getCharges() {
		return charges;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Utility utility = (Utility) o;

		return charges == utility.charges && type == utility.type;
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + charges;
		return result;
	}

	@Override
	public String toString() {
		return "Utility{" +
				"type=" + type +
				", charges=" + charges +
				'}';
	}
}
