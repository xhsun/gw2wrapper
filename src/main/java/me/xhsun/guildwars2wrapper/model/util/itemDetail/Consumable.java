package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.comm.Type;

/**
 * For more info on Consumable detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Consumable">here</a><br/>
 * Item detail for consumable
 *
 * @author xhsun
 * @see ItemDetail item details
 * @since 2017-02-10
 */
public class Consumable extends ItemDetail {

	public String getIcon() {
		return icon;
	}

	public int getApplyCount() {
		return apply_count;
	}

	public Type getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public long getDuration() {
		return duration_ms;
	}

	public Unlock getUnlockType() {
		return unlock_type;
	}

	public int getColorID() {
		return color_id;
	}

	public int getRecipeID() {
		return recipe_id;
	}

	private String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Consumable{" +
				"icon='" + icon + '\'' +
				", type=" + type +
				", description='" + description + '\'' +
				", duration_ms=" + duration_ms +
				", unlock_type=" + unlock_type +
				", color_id=" + color_id +
				", recipe_id=" + recipe_id +
				", name='" + name + '\'' +
				'}';
	}
}
