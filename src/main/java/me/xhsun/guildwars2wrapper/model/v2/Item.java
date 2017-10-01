package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.Linkable;
import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.ItemDetail;

import java.util.List;

/**
 * Item model class
 * Note: materials, trophies, and traits don't have additional details
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class Item extends Linkable {
	public enum Type {
		Armor, Back, Bag, Consumable, Container, CraftingMaterial,
		Gathering, Gizmo, MiniPet, Tool, Trait, Trinket, Trophy, UpgradeComponent, Weapon
	}

	public enum Rarity {Junk, Basic, Fine, Masterwork, Rare, Exotic, Ascended, Legendary}

	public enum Flag {
		AccountBindOnUse, AccountBound, HideSuffix, MonsterOnly, NoMysticForge,
		NoSalvage, NoSell, NotUpgradeable, NoUnderwater, SoulbindOnAcquire, SoulBindOnUse, Unique
	}

	public enum Restriction {
		Asura, Charr, Human, Norn, Sylvari,
		Elementalist, Engineer, Guardian, Mesmer, Necromancer, Ranger, Revenant, Thief, Warrior
	}

	public enum GameType {Activity, Dungeon, Pve, Pvp, PvpLobby, Wvw}

	private String icon;
	private String description;
	private Type type;
	private Rarity rarity;
	private int level;
	private long vendor_value;
	private int default_skin;
	private List<Flag> flags;
	private List<GameType> game_types;
	private List<Restriction> restrictions;
	private ItemDetail details;

	public String getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public Type getType() {
		return type;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public int getLevel() {
		return level;
	}

	public long getVendorValue() {
		return vendor_value;
	}

	public int getDefaultSkin() {
		return default_skin;
	}

	public List<Flag> getFlags() {
		return flags;
	}

	public List<GameType> getGameTypes() {
		return game_types;
	}

	public List<Restriction> getRestrictions() {
		return restrictions;
	}

	public ItemDetail getDetails() {
		return details;
	}
}
