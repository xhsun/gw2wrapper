package me.xhsun.guildwars2wrapper.model.character;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on character specializations API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Specialization">here</a><br/>
 * Model class for character specialization
 * TODO /v2/specializations
 * TODO /v2/traits
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterSpecialization {
	private Trait pve, pvp, wvw;

	public Trait getPve() {
		return pve;
	}

	public Trait getPvp() {
		return pvp;
	}

	public Trait getWvw() {
		return wvw;
	}

	@Override
	public String toString() {
		return "CharacterSpecialization{" +
				"pve=" + pve +
				", pvp=" + pvp +
				", wvw=" + wvw +
				'}';
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

		@Override
		public String toString() {
			return "Trait{" +
					"SpecializationId=" + getId() +
					", traits=" + traits +
					'}';
		}
	}
}