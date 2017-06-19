package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.model.*;
import me.xhsun.guildwars2wrapper.model.account.*;
import me.xhsun.guildwars2wrapper.model.achievements.Achievement;
import me.xhsun.guildwars2wrapper.model.achievements.AchievementCategory;
import me.xhsun.guildwars2wrapper.model.achievements.AchievementGroup;
import me.xhsun.guildwars2wrapper.model.achievements.DailyAchievement;
import me.xhsun.guildwars2wrapper.model.backstory.BackStoryAnswer;
import me.xhsun.guildwars2wrapper.model.backstory.BackStoryQuestion;
import me.xhsun.guildwars2wrapper.model.character.Character;
import me.xhsun.guildwars2wrapper.model.character.*;
import me.xhsun.guildwars2wrapper.model.commerce.Exchange;
import me.xhsun.guildwars2wrapper.model.commerce.Listing;
import me.xhsun.guildwars2wrapper.model.commerce.Prices;
import me.xhsun.guildwars2wrapper.model.commerce.Transaction;
import me.xhsun.guildwars2wrapper.model.continent.Continent;
import me.xhsun.guildwars2wrapper.model.continent.ContinentFloor;
import me.xhsun.guildwars2wrapper.model.continent.ContinentMap;
import me.xhsun.guildwars2wrapper.model.continent.ContinentRegion;
import me.xhsun.guildwars2wrapper.model.guild.*;
import me.xhsun.guildwars2wrapper.model.pvp.Amulet;
import me.xhsun.guildwars2wrapper.model.pvp.Hero;
import me.xhsun.guildwars2wrapper.model.unlockable.Finisher;
import me.xhsun.guildwars2wrapper.model.unlockable.Glider;
import me.xhsun.guildwars2wrapper.model.unlockable.MailCarrier;
import me.xhsun.guildwars2wrapper.model.unlockable.Outfit;
import me.xhsun.guildwars2wrapper.model.wvw.Ability;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * API interface for different calls
 *
 * @author xhsun
 * @since 2017-02-07
 */
interface GuildWars2API {
	//token info
	@GET("/v2/tokeninfo")
	Call<TokenInfo> getAPIInfo(@Query("access_token") String token);

	//accounts
	@GET("/v2/account")
	Call<Account> getAccount(@Query("access_token") String token);

	@GET("/v2/account/achievements")
	Call<List<AchievementProgression>> getAchievementProgression(@Query("access_token") String token);

	@GET("/v2/account/bank")
	Call<List<Bank>> getBank(@Query("access_token") String token);

	@GET("/v2/account/dungeons")
	Call<List<String>> getDailyDungeonProgression(@Query("access_token") String token);

	@GET("/v2/account/dyes")
	Call<List<Integer>> getUnlockedDyes(@Query("access_token") String token);

	@GET("/v2/account/finishers")
	Call<List<UnlockedFinisher>> getUnlockedFinishers(@Query("access_token") String token);

	@GET("/v2/account/gliders")
	Call<List<Integer>> getUnlockedGliders(@Query("access_token") String token);

	@GET("/v2/account/home/cats")
	Call<List<Cat>> getUnlockedCats(@Query("access_token") String token);

	@GET("/v2/account/home/nodes")
	Call<List<String>> getUnlockedHomeNodes(@Query("access_token") String token);

	@GET("/v2/account/inventory")
	Call<List<SharedInventory>> getSharedInventory(@Query("access_token") String token);

	@GET("/v2/account/mailcarriers")
	Call<List<Integer>> getUnlockedMailCarriers(@Query("access_token") String token);

	@GET("/v2/account/masteries")
	Call<List<UnlockedMastery>> getUnlockedMasteries(@Query("access_token") String token);

	@GET("/v2/account/materials")
	Call<List<Material>> getMaterialBank(@Query("access_token") String token);

	@GET("/v2/account/minis")
	Call<List<Integer>> getUnlockedMinis(@Query("access_token") String token);

	@GET("/v2/account/outfits")
	Call<List<Integer>> getUnlockedOutfits(@Query("access_token") String token);

	@GET("/v2/account/pvp/heroes")
	Call<List<Integer>> getUnlockedPvpHeroes(@Query("access_token") String token);

	@GET("/v2/account/raids")
	Call<List<String>> getWeeklyRaidProgression(@Query("access_token") String token);

	@GET("/v2/account/recipes")
	Call<List<Integer>> getUnlockedRecipes(@Query("access_token") String token);

	@GET("/v2/account/skins")
	Call<List<Integer>> getUnlockedSkins(@Query("access_token") String token);

	@GET("/v2/account/titles")
	Call<List<Integer>> getUnlockedTitles(@Query("access_token") String token);

	@GET("/v2/account/wallet")
	Call<List<Wallet>> getWallet(@Query("access_token") String token);

	//achievements
	@GET("/v2/achievements")
	Call<List<Integer>> getAllAchievementIDs();

	@GET("/v2/achievements")
	Call<List<Achievement>> getAchievementInfo(@Query("ids") String ids);

	@GET("/v2/achievements/categories")
	Call<List<Integer>> getAllAchievementCategoryIDs();

	@GET("/v2/achievements/categories")
	Call<List<AchievementCategory>> getAchievementCategoryInfo(@Query("ids") String ids);

	@GET("/v2/achievements/daily")
	Call<DailyAchievement> getCurrentDailyAchievements();

	@GET("/v2/achievements/daily/tomorrow")
	Call<DailyAchievement> getNextDailyAchievements();

	@GET("/v2/achievements/groups")
	Call<List<String>> getAllAchievementGroupIDs();

	@GET("/v2/achievements/groups")
	Call<List<AchievementGroup>> getAchievementGroupInfo(@Query("ids") String ids);

	//back story
	@GET("/v2/backstory/answers")
	Call<List<String>> getAllBackStoryAnswerIDs();

	@GET("/v2/backstory/answers")
	Call<List<BackStoryAnswer>> getBackStoryAnswerInfo(@Query("ids") String ids);

	@GET("/v2/backstory/questions")
	Call<List<Integer>> getAllBackStoryQuestionIDs();

	@GET("/v2/backstory/questions")
	Call<List<BackStoryQuestion>> getBackStoryQuestionInfo(@Query("ids") String ids);

	//Current Game Build
	@GET("/v2/build")
	Call<GameBuild> getCurrentGameBuild();

	//Cats
	@GET("/v2/cats")
	Call<List<Integer>> getAllCatIDs();

	@GET("/v2/cats")
	Call<List<Cat>> getCatInfo(@Query("ids") String ids);

	//characters
	@GET("/v2/characters")
	Call<List<String>> getAllCharacterName(@Query("access_token") String token);

	@GET("/v2/characters/{name}")
	Call<Character> getCharacter(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/backstory")
	Call<CharacterBackStory> getCharacterBackStory(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/core")
	Call<Core> getCharacterCore(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/crafting")
	Call<CraftingLevel> getCharacterCrafting(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/equipment")
	Call<CharacterEquipment> getCharacterEquipment(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/heropoints")
	Call<List<String>> getCharacterHeroPoints(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/inventory")
	Call<CharacterInventory> getCharacterInventory(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/recipes")
	Call<CharacterRecipes> getCharacterUnlockedRecipes(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/sab")
	Call<CharacterSAB> getCharacterSAB(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/skills")
	Call<CharacterSkills> getCharacterSkills(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/specializations")
	Call<CharacterSpecialization> getCharacterSpecialization(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/training")
	Call<CharacterTraining> getCharacterTraining(@Path("name") String name, @Query("access_token") String token);

	//colors
	@GET("/v2/colors")
	Call<List<Integer>> getAllColorIDs();

	@GET("/v2/colors")
	Call<List<Color>> getColorInfo(@Query("ids") String ids);

	//TP
//	@GET("/v2/commerce/delivery")
//  TODO wait for endpoint to become available again
//	Call<List<Delivery>> getTPDeliveryInfo(@Query("access_token") String token);

	@GET("/v2/commerce/exchange")
	Call<List<String>> getAllExchangeCurrency();

	@GET("/v2/commerce/exchange/{currency}")
	Call<Exchange> getExchangeInfo(@Path("currency") String currency, @Query("quantity") String quantity);

	@GET("/v2/commerce/listings")
	Call<List<Integer>> getAllTPListingIDs();

	@GET("/v2/commerce/listings")
	Call<List<Listing>> getTPListingInfo(@Query("ids") String ids);

	@GET("/v2/commerce/prices")
	Call<List<Integer>> getAllTPPriceIDs();

	@GET("/v2/commerce/prices")
	Call<List<Prices>> getTPPriceInfo(@Query("ids") String ids);

	@GET("/v2/commerce/transactions/{time}/{type}")
	Call<List<Transaction>> getTPTransaction(@Path("time") String time, @Path("type") String type, @Query("access_token") String token);

	//continents
	@GET("/v2/continents")
	Call<List<Integer>> getAllContinentIDs();

	@GET("/v2/continents")
	Call<List<Continent>> getContinentInfo(@Query("ids") String ids);

	@GET("/v2/continents/{continentId}/floors")
	Call<List<Integer>> getAllContinentFloorIDs(@Path("continentId") String continent);

	@GET("/v2/continents/{continentId}/floors")
	Call<List<ContinentFloor>> getContinentFloorInfo(@Path("continentId") String continent, @Query("ids") String ids);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions")
	Call<List<Integer>> getAllContinentRegionIDs(@Path("continentId") String continent, @Path("floorId") String floor);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions")
	Call<List<ContinentRegion>> getContinentRegionInfo(@Path("continentId") String continent, @Path("floorId") String floor, @Query("ids") String ids);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions/{regionId}/maps")
	Call<List<Integer>> getAllContinentMapIDs(@Path("continentId") String continent, @Path("floorId") String floor, @Path("regionId") String region);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions/{regionId}/maps")
	Call<List<ContinentMap>> getContinentMapInfo(@Path("continentId") String continent, @Path("floorId") String floor, @Path("regionId") String region, @Query("ids") String ids);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions/{regionId}/maps/{mapId}/sectors")
	Call<List<Integer>> getAllContinentSectorIDs(@Path("continentId") String continent, @Path("floorId") String floor, @Path("regionId") String region, @Path("mapId") String map);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions/{regionId}/maps/{mapId}/sectors")
	Call<List<ContinentMap.Sector>> getContinentSectorInfo(@Path("continentId") String continent, @Path("floorId") String floor, @Path("regionId") String region, @Path("mapId") String map, @Query("ids") String ids);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions/{regionId}/maps/{mapId}/pois")
	Call<List<Integer>> getAllContinentPOIIDs(@Path("continentId") String continent, @Path("floorId") String floor, @Path("regionId") String region, @Path("mapId") String map);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions/{regionId}/maps/{mapId}/pois")
	Call<List<ContinentMap.PoI>> getContinentPOIInfo(@Path("continentId") String continent, @Path("floorId") String floor, @Path("regionId") String region, @Path("mapId") String map, @Query("ids") String ids);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions/{regionId}/maps/{mapId}/tasks")
	Call<List<Integer>> getAllContinentTaskIDs(@Path("continentId") String continent, @Path("floorId") String floor, @Path("regionId") String region, @Path("mapId") String map);

	@GET("/v2/continents/{continentId}/floors/{floorId}/regions/{regionId}/maps/{mapId}/tasks")
	Call<List<ContinentMap.Task>> getContinentTaskInfo(@Path("continentId") String continent, @Path("floorId") String floor, @Path("regionId") String region, @Path("mapId") String map, @Query("ids") String ids);

	//currencies
	@GET("/v2/currencies")
	Call<List<Integer>> getAllCurrencies();

	@GET("/v2/currencies")
	Call<List<Currency>> getCurrencyInfo(@Query("ids") String ids);

	//dungeons
	@GET("/v2/dungeons")
	Call<List<String>> getAllDungeonName();

	@GET("/v2/dungeons")
	Call<List<Dungeon>> getDungeonInfo(@Query("ids") String ids);

	//Emblem
	@GET("/v2/emblem")
	Call<List<String>> getAllEmblemType();

	@GET("/v2/emblem/{type}")
	Call<List<Integer>> getAllEmblemIDs(@Path("type") String type);

	@GET("/v2/emblem/{type}")
	Call<List<Emblem>> getAllEmblemInfo(@Path("type") String type, @Query("ids") String ids);

	//Files
	@GET("/v2/files")
	Call<List<String>> getAllFileIDs();

	@GET("/v2/files")
	Call<List<Asset>> getAllFileInfo(@Query("ids") String ids);

	//Finishers
	@GET("/v2/finishers")
	Call<List<Integer>> getAllFinisherIDs();

	@GET("/v2/finishers")
	Call<List<Finisher>> getFinisherInfo(@Query("ids") String ids);

	//Gliders
	@GET("/v2/gliders")
	Call<List<Integer>> getAllGliderIDs();

	@GET("/v2/gliders")
	Call<List<Glider>> getGliderInfo(@Query("ids") String ids);

	//Guild
	@GET("/v2/guild/{id}")
	Call<Guild> getGeneralGuildInfo(@Path("id") String id);

	@GET("/v2/guild/{id}")
	Call<Guild> getDetailedGuildInfo(@Path("id") String id, @Query("access_token") String token);

	//Guild Log
	@GET("/v2/guild/{id}/log")
	Call<List<GuildLog>> getGuildLogInfo(@Path("id") String id, @Query("access_token") String token);

	@GET("/v2/guild/{id}/log")
	Call<List<GuildLog>> getFilteredGuildLogInfo(@Path("id") String id, @Query("access_token") String token, @Query("since") String since);

	//Guild Members
	@GET("/v2/guild/{id}/members")
	Call<List<GuildMember>> getGuildMemberInfo(@Path("id") String id, @Query("access_token") String token);

	//Guild Ranks
	@GET("/v2/guild/{id}/ranks")
	Call<List<GuildRank>> getGuildRankInfo(@Path("id") String id, @Query("access_token") String token);

	//Guild Stash
	@GET("/v2/guild/{id}/stash")
	Call<List<GuildStash>> getGuildStashInfo(@Path("id") String id, @Query("access_token") String token);

	//Guild Teams
	@GET("/v2/guild/{id}/teams")
	Call<List<GuildTeam>> getGuildTeamsInfo(@Path("id") String id, @Query("access_token") String token);

	//Guild Treasury
	@GET("/v2/guild/{id}/treasury")
	Call<List<GuildTreasury>> getGuildTreasuryInfo(@Path("id") String id, @Query("access_token") String token);

	//Guild Unlocked Upgrades
	@GET("/v2/guild/{id}/upgrades")
	Call<List<Integer>> getGuildUpgradeIDs(@Path("id") String id, @Query("access_token") String token);

	//Guild Permissions
	@GET("/v2/guild/permissions")
	Call<List<String>> getAllGuildPermissionIDs();

	@GET("/v2/guild/permissions")
//TODO class
	Call<List<String>> getGuildPermissionInfo(@Query("ids") String ids);

	//Guild Search
	@GET("/v2/guild/search")
	Call<List<String>> searchGuildID(@Query("name") String name);

	//Guild Upgrades
	@GET("/v2/guild/upgrades")
	Call<List<Integer>> getAllGuildUpgradeIDs();

	@GET("/v2/guild/upgrades")
	Call<List<Upgrade>> getGuildUpgradeInfo(@Query("ids") String ids);

	//items
	@GET("/v2/items")
	Call<List<Integer>> getAllItemIDs();

	@GET("/v2/items")
	Call<List<Item>> getItemInfo(@Query("ids") String ids);

	//item stat
	@GET("/v2/itemstats")
	Call<List<Integer>> getAllItemStatIDs();

	@GET("/v2/itemstats")
	Call<List<ItemStats>> getItemStatInfo(@Query("ids") String ids);

	//Legends
	@GET("/v2/legends")
	Call<List<String>> getAllLegendIDs();

	@GET("/v2/legends")
//TODO class
	Call<List<String>> getLegendInfo(@Query("ids") String ids);

	//mail carriers
	@GET("/v2/mailcarriers")
	Call<List<Integer>> getAllMailCarrierIDs();

	@GET("/v2/mailcarriers")
	Call<List<MailCarrier>> getMailCarrierInfo(@Query("ids") String ids);

	//Map
	@GET("/v2/maps")
	Call<List<Integer>> getAllMapIDs();

	@GET("/v2/maps")
//TODO extend ContinentMap class
	Call<List<String>> getMapInfo(@Query("ids") String ids);

	//masteries
	@GET("/v2/masteries")
	Call<List<Integer>> getAllMasteryIDs();

	@GET("/v2/masteries")
	Call<List<Mastery>> getMasteryInfo(@Query("ids") String ids);

	//material categories
	@GET("/v2/materials")
	Call<List<Integer>> getAllMaterialBankIDs();

	@GET("/v2/materials")
	Call<List<MaterialCategory>> getMaterialBankInfo(@Query("ids") String ids);

	//minis
	@GET("/v2/minis")
	Call<List<Integer>> getAllMiniIDs();

	@GET("/v2/minis")
	Call<List<Mini>> getMiniInfo(@Query("ids") String ids);

	//Outfits
	@GET("/v2/outfits")
	Call<List<Integer>> getAllOutfitIDs();

	@GET("/v2/outfits")
	Call<List<Outfit>> getOutfitInfo(@Query("ids") String ids);

	//Professions
	@GET("/v2/professions")
	Call<List<String>> getAllProfessionIDs();

	@GET("/v2/professions")
	Call<List<Profession>> getProfessionInfo(@Query("ids") String ids);

	//PvP Amulets
	@GET("/v2/pvp/amulets")
	Call<List<Integer>> getAllPvPAmuletIDs();

	@GET("/v2/pvp/amulets")
	Call<List<Amulet>> getPvPAmuletInfo(@Query("ids") String ids);

	//PvP Heroes
	@GET("/v2/pvp/heroes")
	Call<List<String>> getAllPvPHeroIDs();

	@GET("/v2/pvp/heroes")
	Call<List<Hero>> getPvPHeroInfo(@Query("ids") String ids);

	//Raids
	@GET("/v2/raids")
	Call<List<String>> getAllRaidIDs();

	@GET("/v2/raids")
	Call<List<Raid>> getRaidInfo(@Query("ids") String ids);

	//recipes
	@GET("/v2/recipes")
	Call<List<Integer>> getAllRecipeIDs();

	@GET("/v2/recipes")
	Call<List<Recipe>> getRecipeInfo(@Query("ids") String ids);

	//recipes search
	@GET("/v2/recipes/search")
	Call<List<Integer>> searchInputRecipes(@Query("input") String id);

	@GET("/v2/recipes/search")
	Call<List<Integer>> searchOutputRecipes(@Query("output") String id);

	//Skills
	@GET("/v2/skills")
	Call<List<Integer>> getAllSkillIDs();

	@GET("/v2/skills")
	Call<List<Skill>> getSkillInfo(@Query("ids") String ids);

	//skins
	@GET("/v2/skins")
	Call<List<Integer>> getAllSkinIDs();

	@GET("/v2/skins")
	Call<List<Skin>> getSkinInfo(@Query("ids") String ids);

	//Specializations
	@GET("/v2/specializations")
	Call<List<Integer>> getAllSpecializationIDs();

	@GET("/v2/specializations")
	Call<List<Specialization>> getSpecializationInfo(@Query("ids") String ids);

	//Titles
	@GET("/v2/titles")
	Call<List<Integer>> getAllTitleIDs();

	@GET("/v2/titles")
	Call<List<Title>> getTitleInfo(@Query("ids") String ids);

	//Traits
	@GET("/v2/traits")
	Call<List<Integer>> getAllTraitIDs();

	@GET("/v2/traits")
	Call<List<Trait>> getTraitInfo(@Query("ids") String ids);

	//worlds
	@GET("/v2/worlds")
	Call<List<Integer>> getAllWorldsIDs();

	@GET("/v2/worlds")
	Call<List<World>> getWorldsInfo(@Query("ids") String ids);

	//WvW Abilities
	@GET("/v2/wvw/abilities")
	Call<List<Integer>> getAllWvWAbilityIDs();

	@GET("/v2/wvw/abilities")
	Call<List<Ability>> getWvWAbilityInfo(@Query("ids") String ids);
}
