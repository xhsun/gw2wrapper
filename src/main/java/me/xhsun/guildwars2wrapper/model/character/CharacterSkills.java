package me.xhsun.guildwars2wrapper.model.character;

import java.util.List;

/**
 * For more info on character skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Skills">here</a><br/>
 * Model class for character skills level
 * TODO /v2/skills
 *
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

	@Override
	public String toString() {
		return "CharacterSkills{" +
				"skills=" + skills +
				'}';
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

		@Override
		public String toString() {
			return "CharacterSkills{" +
					"pve=" + pve +
					", pvp=" + pvp +
					", wvw=" + wvw +
					'}';
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

		@Override
		public String toString() {
			return "Utility{" +
					"heal=" + heal +
					", utilities=" + utilities +
					", elite=" + elite +
					'}';
		}
	}
}
