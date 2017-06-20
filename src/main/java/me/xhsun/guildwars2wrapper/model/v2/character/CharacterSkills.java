package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.v2.Skill;

import java.util.List;

/**
 * For more info on character skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Skills">here</a><br/>
 * Model class for character skills level
 *
 * @see Skill
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterSkills {
	private Skills skills;

	public Utility getPve() {
		return skills.pve;
	}

	public Utility getPvp() {
		return skills.pvp;
	}

	public Utility getWvw() {
		return skills.wvw;
	}

	public class Skills {
		private Utility pve, pvp, wvw;

		public Utility getPve() {
			return pve;
		}

		public Utility getPvp() {
			return pvp;
		}

		public Utility getWvw() {
			return wvw;
		}
	}
	public class Utility {
		private int heal;
		private List<Integer> utilities;
		private int elite;

		public int getHeal() {
			return heal;
		}

		public List<Integer> getUtilities() {
			return utilities;
		}

		public int getElite() {
			return elite;
		}
	}
}
