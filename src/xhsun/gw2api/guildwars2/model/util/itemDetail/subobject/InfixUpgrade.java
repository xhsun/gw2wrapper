package xhsun.gw2api.guildwars2.model.util.itemDetail.subobject;

/**
 * For more info on Infix upgrade API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Infix_upgrade_subobject">here</a><br/>
 * Infix upgrade model class
 * @see InfixAttribute infix attribute
 * @see Buff infix buff
 * @author xhsun
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

	public String toString(){
		String result="{Buff: "+buff;
		if (attributes!=null){
			result+=" {Flags: ";
			for (InfixAttribute att : attributes) result += att + ", ";
			result=result.substring(0, result.length()-2);
		}
		return result+"} ";
	}
}
