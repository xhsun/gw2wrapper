package me.xhsun.guildwars2wrapper.model.character;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.util.Bag;

import java.util.List;

/**
 * For more info on character overview API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
 * Model class for character overview
 * TODO /v2/wvw/abilities
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class Character extends Core {
	private List<CraftingLevel.Discipline> crafting;
	private List<String> backstory;
	private List<WvWAbility> wvw_abilities;
	private CharacterSpecialization.Specialization specializations;
	private CharacterSkills.Skills skills;
	private List<CharacterEquipment.Equipment> equipment;
	private List<Integer> recipes;
	private PvPEquipment equipment_pvp;
	private List<CharacterTraining.Training> training;
	private List<Bag> bags;

	public List<CraftingLevel.Discipline> getCrafting() {
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

	public List<Bag> getBags() {
		return bags;
	}

	@Override
	public String toString() {
		return "Character{" +
				super.toString() +
				", crafting=" + crafting +
				", backstory=" + backstory +
				", wvw_abilities=" + wvw_abilities +
				", specializations=" + specializations +
				", skills=" + skills +
				", equipment=" + equipment +
				", recipes=" + recipes +
				", equipment_pvp=" + equipment_pvp +
				", training=" + training +
				", bags=" + bags +
				'}';
	}

	public class WvWAbility extends IdentifiableInt {
		private int rank;

		public int getRank() {
			return rank;
		}

		@Override
		public String toString() {
			return "CharacterWvW{" +
					"id=" + getId() +
					", rank=" + rank +
					'}';
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

		@Override
		public String toString() {
			return "PvPEquipment{" +
					"amulet=" + amulet +
					", rune=" + rune +
					", sigils=" + sigils +
					'}';
		}
	}
}
