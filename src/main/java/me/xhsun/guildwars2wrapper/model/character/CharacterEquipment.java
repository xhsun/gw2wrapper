package me.xhsun.guildwars2wrapper.model.character;

import me.xhsun.guildwars2wrapper.model.util.Inventory;

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

	@Override
	public String toString() {
		return "CharacterEquipment{" +
				"equipment=" + equipment +
				'}';
	}

	public class Equipment extends Inventory {


		private Slot slot;
		private List<Integer> dyes;

		public Slot getSlot() {
			return slot;
		}

		/**
		 * @return list of {@link me.xhsun.guildwars2wrapper.model.Color#id}
		 */
		public List<Integer> getDyes() {
			return dyes;
		}

		@Override
		public String toString() {
			return "Equipment{" +
					"id=" + getId() +
					", slot=" + slot +
					", infusions=" + getInfusions() +
					", upgrades=" + getUpgrades() +
					", skin=" + getSkin() +
					", stats=" + getStats() +
					", binding=" + getBinding() +
					", charges=" + getCharges() +
					", bound_to='" + getBoundTo() + '\'' +
					", dyes=" + dyes +
					'}';
		}
	}
}

