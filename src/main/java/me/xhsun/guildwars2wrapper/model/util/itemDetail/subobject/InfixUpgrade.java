package me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject;

import java.util.Arrays;

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
	private InfixAttribute[] attributes;
	private Buff buff;

	public InfixAttribute[] getAttributes() {
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

		return Arrays.equals(attributes, that.attributes) &&
				(buff != null ? buff.equals(that.buff) : that.buff == null);
	}

	@Override
	public int hashCode() {
		int result = Arrays.hashCode(attributes);
		result = 31 * result + (buff != null ? buff.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "InfixUpgrade{" +
				"attributes=" + Arrays.toString(attributes) +
				", buff=" + buff +
				'}';
	}
}
