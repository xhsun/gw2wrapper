package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

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
	private List<SABName> unlocks, songs;

	public List<Zone> getZones() {
		return zones;
	}

	public List<SABName> getUnlocks() {
		return unlocks;
	}

	public List<SABName> getSongs() {
		return songs;
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
	}

	public class SABName extends NameableInt {
	}
}
