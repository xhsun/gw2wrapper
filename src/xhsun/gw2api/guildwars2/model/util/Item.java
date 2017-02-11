package xhsun.gw2api.guildwars2.model.util;

import xhsun.gw2api.guildwars2.model.util.itemDetail.ItemDetail;

/**
 * Item model class
 * Note: materials, trophies, and traits don't have additional details
 * @author xhsun
 * @since 2017-02-07
 */

public class Item {
	public enum Type{Armor, Back, Bag, Consumable, Container, CraftingMaterial,
		Gathering, Gizmo, MiniPet, Tool, Trait, Trinket, Trophy, UpgradeComponent, Weapon}
	public enum Rarity{Junk, Basic, Fine, Masterwork, Rare, Exotic, Ascended, Legendary}
	public enum Flag{AccountBindOnUse, AccountBound, HideSuffix, MonsterOnly, NoMysticForge,
		NoSalvage, NoSell, NotUpgradeable, NoUnderwater, SoulbindOnAcquire, SoulBindOnUse, Unique}
	public enum Restriction{Asura, Charr, Human, Norn, Sylvari, Elementalist, Engineer, Guardian,
		Mesmer, Necromancer, Ranger, Thief, Warrior}
	public enum GameType{Activity, Dungeon, Pve, Pvp, PvpLobby, Wvw}
	private long id;
	private String chat_link;
	private String name;
	private String icon;
	private String description;
	private Type type;
	private Rarity rarity;
	private int level;
	private long vendor_value;
	private long default_skin;
	private Flag[] flags;
	private GameType[] game_types;
	private Restriction[] restrictions;
	private ItemDetail details;

	public long getId() {
		return id;
	}

	public String getChat_link() {
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

	public long getVendor_value() {
		return vendor_value;
	}

	public long getDefault_skin() {
		return default_skin;
	}

	public Flag[] getFlags() {
		return flags;
	}

	public GameType[] getGame_types() {
		return game_types;
	}

	public Restriction[] getRestrictions() {
		return restrictions;
	}

	public ItemDetail getDetails() {
		return details;
	}

	@Override
	public String toString(){
		String result="{Item ID: "+id+" ChatLink: "+chat_link+" Name: "+name+" Icon: "+icon+" Description: "+description+
				" Type: "+type+" Rarity: "+rarity+" Level: "+level+" VendorValue: "+vendor_value+" DefaultSkin: "+default_skin;
		if (flags!=null){
			result+=" {Flags: ";
			for (Flag flag : flags) result += flag + ", ";
		}
		result=result.substring(0, result.length()-2)+"} ";
		if (flags!=null){
			result+=" {GameType: ";
			for (Flag flag : flags) result += flag + ", ";
		}
		result=result.substring(0, result.length()-2)+"} ";
		if (restrictions!=null){
			result+=" {Restrictions: ";
			for (Restriction restriction : restrictions) result += restriction + ", ";
		}
		result=result.substring(0, result.length()-2)+"} ";
		result+=details;
		return result;
	}
}
