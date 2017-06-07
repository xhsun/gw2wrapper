package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.comm.Type;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfixUpgrade;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfusionSlot;

import java.util.List;

/**
 * For more info on Item detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Armor">here</a><br/>
 * template for all item detail
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class ItemDetail {
	public enum Weight {Heavy, Medium, Light, Clothing}

	public enum Damage {Fire, Ice, Lightning, Physical, Choking}

	public enum Infusion {Defense, Offense, Utility, Agony}

	public enum Unlock {
		BagSlot, BankTab, CollectibleCapacity, Content, CraftingRecipe, Dye, Outfit,
		GliderSkin, Champion
	}

	public enum Attribute {
		BoonDuration, ConditionDamage, ConditionDuration, CritDamage, Healing,
		Power, Precision, Toughness, Vitality
	}

	public enum Flag {
		//Upgrade component flag
		Axe, Dagger, Mace, Pistol, Scepter, Sword, Focus, Shield, Torch, Warhorn, Greatsword, Hammer,
		LongBow, Rifle, ShortBow, Staff, Harpoon, Speargun, Trident, HeavyArmor, MediumArmor,
		LightArmor, Trinket,
		//Infusion slot flag
		Enrichment, Infusion
	}

	//Common
	Type type;
	int defense;
	List<InfusionSlot> infusion_slots;
	InfixUpgrade infix_upgrade;
	int suffix_item_id;
	String secondary_suffix_item_id;
	List<String> stat_choices;
	//Armor
	Weight weight_class;
	//Bag
	int size;
	boolean no_sell_or_sort;//invisible/safe
	//Consumable
	String description;
	long duration_ms;
	Unlock unlock_type;
	int color_id;
	int recipe_id;
	String name;
	String icon;
	int apply_count;
	//Mini
	int minipet_id;
	//Salvage kit
	int charges;
	//Upgrade component
	List<Flag> flags;
	List<Infusion> infusion_upgrade_flags;
	String suffix;
	List<String> bonuses;//for runes only
	//Weapon
	Damage damage_type;
	int min_power;
	int max_power;
}
