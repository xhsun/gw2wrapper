package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.v2.util.comm.CraftingDisciplines;

import java.util.List;

/**
 * For more info on character crafting API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Crafting">here</a><br/>
 * Model class for character crafting level
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterCraftingLevel {
	private List<Discipline> crafting;

	public List<Discipline> getCrafting() {
		return crafting;
	}

	public class Discipline {
		private CraftingDisciplines discipline;
		private int rating;
		private boolean active;

		public CraftingDisciplines getDiscipline() {
			return discipline;
		}

		public int getRating() {
			return rating;
		}

		public boolean isActive() {
			return active;
		}
	}
}
