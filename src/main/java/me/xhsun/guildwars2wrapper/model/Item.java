package me.xhsun.guildwars2wrapper.model;

import me.xhsun.guildwars2wrapper.model.util.itemDetail.ItemDetail;

import java.util.Arrays;

/**
 * Item model class
 * Note: materials, trophies, and traits don't have additional details
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class Item {
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
		Asura, Charr, Human, Norn, Sylvari, Elementalist, Engineer, Guardian,
		Mesmer, Necromancer, Ranger, Revenant, Thief, Warrior
	}

	public enum GameType {Activity, Dungeon, Pve, Pvp, PvpLobby, Wvw}

	private int id;
	private String chat_link;
	private String name;
	private String icon;
	private String description;
	private Type type;
	private Rarity rarity;
	private int level;
	private long vendor_value;
	private int default_skin;
	private Flag[] flags;
	private GameType[] game_types;
	private Restriction[] restrictions;
	private ItemDetail details;

	public int getId() {
		return id;
	}

	public String getChatLink() {
		return chat_link;
	}

	public String getName() {
		return name;
	}

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

	public Flag[] getFlags() {
		return flags;
	}

	public GameType[] getGameTypes() {
		return game_types;
	}

	public Restriction[] getRestrictions() {
		return restrictions;
	}

	public ItemDetail getDetails() {
		return details;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Item item = (Item) o;

		return id == item.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", chat_link='" + chat_link + '\'' +
				", name='" + name + '\'' +
				", icon='" + icon + '\'' +
				", description='" + description + '\'' +
				", type=" + type +
				", rarity=" + rarity +
				", level=" + level +
				", vendor_value=" + vendor_value +
				", default_skin=" + default_skin +
				", flags=" + Arrays.toString(flags) +
				", game_types=" + Arrays.toString(game_types) +
				", restrictions=" + Arrays.toString(restrictions) +
				", details=" + details +
				'}';
	}
}
