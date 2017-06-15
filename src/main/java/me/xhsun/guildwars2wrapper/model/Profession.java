package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.Skill.Slot;
import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.indentifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.indentifiable.NameableStr;
import me.xhsun.guildwars2wrapper.model.util.comm.Type;

import java.util.List;
import java.util.Map;

/**
 * For more info on professions API go <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
 * Model class for professions
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class Profession extends NameableStr {
	public enum TrainingCategory {Skills, Specializations, EliteSpecializations}

	private enum TrackType {Trait, Skill}

	public enum Attunement {Fire, Water, Air, Earth}

	public enum Flag {Mainhand, Offhand, TwoHand, Aquatic, NoRacialSkills, NoWeaponSwap}

	private String icon, icon_big;
	private List<Flag> flags;
	private List<Integer> specializations;
	private List<Training> training;
	private List<Skill> skills;
	private Map<String, Weapon> weapons;

	public String getIcon() {
		return icon;
	}

	public String getIconBig() {
		return icon_big;
	}

	public List<Integer> getSpecializations() {
		return specializations;
	}

	public List<Training> getTraining() {
		return training;
	}

	public Map<String, Weapon> getWeapons() {
		return weapons;
	}

	public List<Flag> getFlags() {
		return flags;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	@Override
	public String toString() {
		return "Profession{" +
				super.toString() +
				", icon='" + icon + '\'' +
				", icon_big='" + icon_big + '\'' +
				", flags=" + flags +
				", specializations=" + specializations +
				", training=" + training +
				", skills=" + skills +
				", weapons=" + weapons +
				'}';
	}

	public class Training extends NameableInt {
		private TrainingCategory category;
		private List<TrainingTrack> track;

		public TrainingCategory getCategory() {
			return category;
		}

		public List<TrainingTrack> getTrack() {
			return track;
		}

		@Override
		public String toString() {
			return "Training{" +
					super.toString() +
					", category=" + category +
					", track=" + track +
					'}';
		}
	}

	public class TrainingTrack {
		private int cost, skill_id, trait_id;
		private TrackType type;

		public int getCost() {
			return cost;
		}

		public int getSkill_id() {
			return skill_id;
		}

		public int getTrait_id() {
			return trait_id;
		}

		public TrackType getType() {
			return type;
		}

		@Override
		public String toString() {
			return "TrainingTrack{" +
					"cost=" + cost +
					", skill_id=" + skill_id +
					", trait_id=" + trait_id +
					", type=" + type +
					'}';
		}
	}

	public class Weapon {
		private int specialization;
		private List<Skill> skills;
		private List<Flag> flags;

		public int getSpecialization() {
			return specialization;
		}

		public List<Skill> getSkills() {
			return skills;
		}

		public List<Flag> getFlags() {
			return flags;
		}

		@Override
		public String toString() {
			return "Weapon{" +
					"specialization=" + specialization +
					", skills=" + skills +
					", flags=" + flags +
					'}';
		}
	}

	public class Skill extends IdentifiableInt {
		private Slot slot;
		private Type offhand;
		private Type type;
		private Attunement attunement;
		private Item.Restriction source;

		public Slot getSlot() {
			return slot;
		}

		public Type getOffhand() {
			return offhand;
		}

		public Attunement getAttunement() {
			return attunement;
		}

		public Item.Restriction getSource() {
			return source;
		}

		public Type getType() {
			return type;
		}

		@Override
		public String toString() {
			return "Skill{" +
					"id=" + getId() +
					", slot=" + slot +
					", offhand=" + offhand +
					", type=" + type +
					", attunement=" + attunement +
					", source=" + source +
					'}';
		}
	}
}
