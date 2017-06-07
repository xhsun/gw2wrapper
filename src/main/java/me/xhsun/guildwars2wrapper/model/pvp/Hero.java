package me.xhsun.guildwars2wrapper.model.pvp;

import com.google.gson.annotations.SerializedName;
import me.xhsun.guildwars2wrapper.model.unlockable.Unlockable;

import java.util.Arrays;
import java.util.List;

/**
 * For more info on pvp heroes API go <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">here</a><br/>
 * Model class for pvp hero
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Hero {
	private String id;
	private String name;
	private String type;
	private Stat stats;
	private String overlay;
	private String underlay;
	private List<Skin> skins;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Stat getStats() {
		return stats;
	}

	public String getOverlay() {
		return overlay;
	}

	public String getUnderlay() {
		return underlay;
	}

	public List<Skin> getSkins() {
		return skins;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Hero hero = (Hero) o;

		return id != null ? id.equals(hero.id) : hero.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Hero{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", stats=" + stats +
				", overlay='" + overlay + '\'' +
				", underlay='" + underlay + '\'' +
				", skins=" + skins +
				'}';
	}

	public class Skin extends Unlockable {
		@SerializedName("default")
		private boolean _default;

		public boolean isDefault() {
			return _default;
		}

		@Override
		public String toString() {
			return "Skin{" +
					"id=" + super.getId() +
					", unlock_items=" + Arrays.toString(getUnlockItems()) +
					", icon='" + getIcon() + '\'' +
					", name='" + super.getName() + '\'' +
					", default=" + _default +
					'}';
		}
	}

	public class Stat {
		private int offense;
		private int defense;
		private int speed;

		public int getOffense() {
			return offense;
		}

		public int getDefense() {
			return defense;
		}

		public int getSpeed() {
			return speed;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Stat stat = (Stat) o;

			return offense == stat.offense &&
					defense == stat.defense &&
					speed == stat.speed;
		}

		@Override
		public int hashCode() {
			int result = offense;
			result = 31 * result + defense;
			result = 31 * result + speed;
			return result;
		}

		@Override
		public String toString() {
			return "Stat{" +
					"offense=" + offense +
					", defense=" + defense +
					", speed=" + speed +
					'}';
		}
	}
}
