package me.xhsun.guildwars2wrapper.model.util.itemDetail;

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

	public long getColorID() {
		return color_id;
	}

	public long getRecipeID() {
		return recipe_id;
	}

	private String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Consumable that = (Consumable) o;

		return duration_ms == that.duration_ms &&
				color_id == that.color_id &&
				recipe_id == that.recipe_id &&
				(icon != null ? icon.equals(that.icon) : that.icon == null) &&
				type == that.type && (description != null ? description.equals(that.description) : that.description == null) &&
				unlock_type == that.unlock_type &&
				(name != null ? name.equals(that.name) : that.name == null);
	}

	@Override
	public int hashCode() {
		int result = icon != null ? icon.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (int) (duration_ms ^ (duration_ms >>> 32));
		result = 31 * result + (unlock_type != null ? unlock_type.hashCode() : 0);
		result = 31 * result + (int) (color_id ^ (color_id >>> 32));
		result = 31 * result + (int) (recipe_id ^ (recipe_id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
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
