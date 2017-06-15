package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.indentifiable.Linkable;
import me.xhsun.guildwars2wrapper.model.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.util.skillFact.SkillFact;
import me.xhsun.guildwars2wrapper.model.util.skillFact.SkillTraitedFact;

import java.util.List;

/**
 * For more info on Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/skills">here</a><br/>
 * Model class for Skill
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class Skill extends Linkable {
	public enum Flag {GroundTargeted, NoUnderwater}

	public enum Category {
		Physical, Glyph, Signet, Shout, Well, Consecration, Meditation,
		SpiritWeapon, Symbol, Virtue, Ward, Legend, LegendaryAssassin,
		LegendaryCentaur, LegendaryDemon, LegendaryDragon, LegendaryDwarf,
		Banner, Burst, PrimalBurst, Rage, Stance, kit, Elixir, Gadget, Gyro,
		Turret, CelestialAvatar, Pet, Spirit, Survival, Deception, DualWield,
		StealthAttack, Trick, Venom, Arcane, Cantrip, Conjure, Overload,
		Clone, Glamour, Manipulation, Mantra, Phantasm, Corruption, Mark,
		Minion, Spectral, Transform
	}

	public enum Slot {
		Weapon_1, Weapon_2, Weapon_3, Weapon_4, Weapon_5,
		Profession_1, Profession_2, Profession_3, Profession_4, Profession_5,
		Downed_1, Downed_2, Downed_3, Downed_4,
		Utility, Heal, Elite, Pet
	}

	private String description, icon;
	private Type type, weapon_type, dual_wield;
	private List<Item.Restriction> professions;
	private Slot slot;
	private List<Flag> flags;
	private List<SkillFact> facts;
	private List<SkillTraitedFact> traited_facts;
	private List<Category> categories;
	private Profession.Attunement attunement;
	private int cost, flip_skill, initiative, next_chain, prev_chain, toolbelt_skill;
	private List<Integer> transform_skills, bundle_skills;//list of skill id

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public Type getType() {
		return type;
	}

	public Type getWeapon_type() {
		return weapon_type;
	}

	public Type getDual_wield() {
		return dual_wield;
	}

	public List<Item.Restriction> getProfessions() {
		return professions;
	}

	public Slot getSlot() {
		return slot;
	}

	public List<Flag> getFlags() {
		return flags;
	}

	public List<SkillFact> getFacts() {
		return facts;
	}

	public List<SkillTraitedFact> getTraited_facts() {
		return traited_facts;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public Profession.Attunement getAttunement() {
		return attunement;
	}

	public int getCost() {
		return cost;
	}

	public int getFlip_skill() {
		return flip_skill;
	}

	public int getInitiative() {
		return initiative;
	}

	public int getNext_chain() {
		return next_chain;
	}

	public int getPrev_chain() {
		return prev_chain;
	}

	public int getToolbelt_skill() {
		return toolbelt_skill;
	}

	public List<Integer> getTransform_skills() {
		return transform_skills;
	}

	public List<Integer> getBundle_skills() {
		return bundle_skills;
	}

	@Override
	public String toString() {
		return "Skill{" +
				super.toString() +
				", description='" + description + '\'' +
				", icon='" + icon + '\'' +
				", type=" + type +
				", weapon_type=" + weapon_type +
				", dual_wield=" + dual_wield +
				", professions=" + professions +
				", slot=" + slot +
				", flags=" + flags +
				", facts=" + facts +
				", traited_facts=" + traited_facts +
				", categories=" + categories +
				", attunement=" + attunement +
				", cost=" + cost +
				", flip_skill=" + flip_skill +
				", initiative=" + initiative +
				", next_chain=" + next_chain +
				", prev_chain=" + prev_chain +
				", toolbelt_skill=" + toolbelt_skill +
				", transform_skills=" + transform_skills +
				", bundle_skills=" + bundle_skills +
				'}';
	}
}
