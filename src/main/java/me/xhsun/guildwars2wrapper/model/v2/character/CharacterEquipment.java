package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.v2.Color;
import me.xhsun.guildwars2wrapper.model.v2.util.Inventory;

import java.util.List;

/**
 * For more info on character equipment API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Equipment">here</a><br/>
 * Model class for character equipment
 *
 * @author xhsun
 * @since 2017-06-07
 */

public class CharacterEquipment {
	public enum Slot {
		HelmAquatic, Backpack, Coat, Boots, Gloves, Helm, Leggings, Shoulders,
		Accessory1, Accessory2, Ring1, Ring2, Amulet,
		WeaponAquaticA, WeaponAquaticB,
		WeaponA1, WeaponA2, WeaponB1, WeaponB2,
		Sickle, Axe, Pick
	}

	private List<Equipment> equipment;

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public class Equipment extends Inventory {
		private Slot slot;
		private List<Integer> dyes;

		public Slot getSlot() {
			return slot;
		}

		/**
		 * @return list of {@link Color#id}
		 */
		public List<Integer> getDyes() {
			return dyes;
		}
	}
}

