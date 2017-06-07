package me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject;

import java.util.List;

/**
 * For more info on Infix upgrade API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Infix_upgrade_subobject">here</a><br/>
 * Infix upgrade model class
 *
 * @author xhsun
 * @see InfixAttribute infix attribute
 * @see Buff infix buff
 * @since 2017-02-10
 */

public class InfixUpgrade {
	private List<InfixAttribute> attributes;
	private Buff buff;

	public List<InfixAttribute> getAttributes() {
		return attributes;
	}

	public Buff getBuff() {
		return buff;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		InfixUpgrade that = (InfixUpgrade) o;

		return (attributes != null ? attributes.equals(that.attributes) : that.attributes == null) &&
				(buff != null ? buff.equals(that.buff) : that.buff == null);
	}

	@Override
	public int hashCode() {
		int result = attributes != null ? attributes.hashCode() : 0;
		result = 31 * result + (buff != null ? buff.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "InfixUpgrade{" +
				"attributes=" + attributes +
				", buff=" + buff +
				'}';
	}
}
