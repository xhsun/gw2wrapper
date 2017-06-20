package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on character specializations API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Specialization">here</a><br/>
 * Model class for character specialization
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterSpecialization {
	private Specialization specializations;

	public List<Trait> getPve() {
		return specializations.pve;
	}

	public List<Trait> getPvp() {
		return specializations.pvp;
	}

	public List<Trait> getWvw() {
		return specializations.wvw;
	}

	public class Specialization {
		private List<Trait> pve, pvp, wvw;

		public List<Trait> getPve() {
			return pve;
		}

		public List<Trait> getPvp() {
			return pvp;
		}

		public List<Trait> getWvw() {
			return wvw;
		}
	}

	public class Trait extends IdentifiableInt {
		private List<Integer> traits;

		/**
		 * @return list of selected traits id
		 */
		public List<Integer> getTraits() {
			return traits;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Trait trait = (Trait) o;

			return getId() == trait.getId() &&
					(traits != null ? traits.equals(trait.traits) : trait.traits == null);
		}

		@Override
		public int hashCode() {
			int result = getId();
			result = 31 * result + (traits != null ? traits.hashCode() : 0);
			return result;
		}
	}
}
