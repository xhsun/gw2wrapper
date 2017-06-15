package me.xhsun.guildwars2wrapper.model.util.comm;

/**
 * Generic type enum
 *
 * @author xhsun
 * @since 2017-06-05
 */
public enum Type {
	//Armor type
	Boots, Coat, Gloves, Helm, HelmAquatic, Leggings, Shoulders,
	//universal
	Default,
	//Container type
	GiftBox, OpenUI,
	//Consumable type
	AppearanceChange, Booze, ContractNpc, Food, Generic, Halloween, Immediate, Transmutation, Unlock,
	UpgradeRemoval, Utility, TeleportToFriend,
	//Gathering tool type
	Foraging, Logging, Mining,
	//Gizmo type
	ContainerKey, RentableContractNpc, UnlimitedConsumable,
	//Salvage kits type
	Salvage,
	//Trinket type
	Accessory, Amulet, Ring,
	//Upgrade component type
	Gem, Rune, Sigil,
	//Weapon type
	Axe, Dagger, Mace, Pistol, Scepter, Sword, Focus, Shield, Torch, Warhorn, Greatsword, Hammer,
	LongBow, Rifle, ShortBow, Staff, Harpoon, Speargun, Trident, LargeBundle, SmallBundle, Toy, TwoHandedToy,
	//Food type
	Dessert, Feast, IngredientCooking, Meal, Seasoning, Snack, Soup,
	//Crafting Component type
	Component, Inscription, Insignia, LegendaryComponent,
	//Refinement recipes type
	Refinement, RefinementEctoplasm, RefinementObsidian,
	//Guild recipes type
	GuildConsumable, GuildDecoration, GuildConsumableWvw,
	//Other recipes type
	Backpack, Bag, Bulk, Consumable, Dye, Potion, UpgradeComponent,
	//Other
	Nothing, None,
	//Skill Type
	Profession, Heal, Elite, Bundle, Weapon
}
