package me.xhsun.guildwars2wrapper.model.character;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.indentifiable.Nameable;

import java.util.List;

/**
 * For more info on character SAB API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Super_Adventure_Box_.28sab.29">here</a><br/>
 * Model class for character SAB
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterSAB {
	private List<Zone> zones;
	private List<Nameable> unlocks, songs;

	public List<Zone> getZones() {
		return zones;
	}

	public List<Nameable> getUnlocks() {
		return unlocks;
	}

	public List<Nameable> getSongs() {
		return songs;
	}

	@Override
	public String toString() {
		return "CharacterSAB{" +
				"zones=" + zones +
				", unlocks=" + unlocks +
				", songs=" + songs +
				'}';
	}

	public class Zone extends IdentifiableInt {
		private String mode;
		private int world, zone;

		public String getMode() {
			return mode;
		}

		public int getWorld() {
			return world;
		}

		public int getZone() {
			return zone;
		}

		@Override
		public String toString() {
			return "Zone{" +
					"id=" + getId() +
					", mode='" + mode + '\'' +
					", world=" + world +
					", zone=" + zone +
					'}';
		}
	}
}
