package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;
import me.xhsun.guildwars2wrapper.model.identifiable.NameableStr;
import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;

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
	private List<ProfessionSkill> skills;
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

	public List<ProfessionSkill> getSkills() {
		return skills;
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
	}

	public class TrainingTrack {
		private int cost, skill_id, trait_id;
		private TrackType type;

		public int getCost() {
			return cost;
		}

		public int getSkillId() {
			return skill_id;
		}

		public int getTraitId() {
			return trait_id;
		}

		public TrackType getType() {
			return type;
		}
	}

	public class Weapon {
		private int specialization;
		private List<ProfessionSkill> skills;
		private List<Flag> flags;

		public int getSpecialization() {
			return specialization;
		}

		public List<ProfessionSkill> getSkills() {
			return skills;
		}

		public List<Flag> getFlags() {
			return flags;
		}
	}

	public class ProfessionSkill extends IdentifiableInt {
		private Skill.Slot slot;
		private Type offhand;
		private Type type;
		private Attunement attunement;
		private Item.Restriction source;

		public Skill.Slot getSlot() {
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
	}
}
