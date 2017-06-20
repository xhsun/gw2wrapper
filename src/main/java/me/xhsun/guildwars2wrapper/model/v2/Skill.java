package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.Linkable;
import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.v2.util.skillFact.SkillFact;
import me.xhsun.guildwars2wrapper.model.v2.util.skillFact.SkillTraitedFact;

import java.util.List;

/**
 * For more info on Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/skills">here</a><br/>
 * Model class for ProfessionSkill
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

	public Type getWeaponType() {
		return weapon_type;
	}

	public Type getDualWield() {
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

	public List<SkillTraitedFact> getTraitedFacts() {
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

	public int getFlipSkill() {
		return flip_skill;
	}

	public int getInitiative() {
		return initiative;
	}

	public int getNextChain() {
		return next_chain;
	}

	public int getPrevChain() {
		return prev_chain;
	}

	public int getToolbeltSkill() {
		return toolbelt_skill;
	}

	public List<Integer> getTransformSkills() {
		return transform_skills;
	}

	public List<Integer> getBundleSkills() {
		return bundle_skills;
	}
}
