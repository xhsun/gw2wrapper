package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on character overview API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
 * Model class for character overview
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class Character extends CharacterCore {
	private List<CharacterCraftingLevel.Discipline> crafting;
	private List<String> backstory;
	private List<WvWAbility> wvw_abilities;
	private CharacterSpecialization.Specialization specializations;
	private CharacterSkills.Skills skills;
	private List<CharacterEquipment.Equipment> equipment;
	private List<Integer> recipes;
	private PvPEquipment equipment_pvp;
	private List<CharacterTraining.Training> training;
	private List<CharacterBag> bags;

	public List<CharacterCraftingLevel.Discipline> getCrafting() {
		return crafting;
	}

	public List<String> getBackStory() {
		return backstory;
	}

	public List<WvWAbility> getWvWAbilities() {
		return wvw_abilities;
	}

	public CharacterSpecialization.Specialization getSpecializations() {
		return specializations;
	}

	public CharacterSkills.Skills getSkills() {
		return skills;
	}

	public List<CharacterEquipment.Equipment> getEquipment() {
		return equipment;
	}

	public List<Integer> getRecipes() {
		return recipes;
	}

	public PvPEquipment getEquipmentPvP() {
		return equipment_pvp;
	}

	public List<CharacterTraining.Training> getTraining() {
		return training;
	}

	public List<CharacterBag> getBags() {
		return bags;
	}

	public class WvWAbility extends IdentifiableInt {
		private int rank;

		public int getRank() {
			return rank;
		}
	}

	public class PvPEquipment {
		private int amulet, rune;
		private List<Integer> sigils;

		public int getAmulet() {
			return amulet;
		}

		public int getRune() {
			return rune;
		}

		public List<Integer> getSigils() {
			return sigils;
		}
	}
}
