package me.xhsun.guildwars2wrapper;

import me.xhsun.guildwars2wrapper.model.v1.AllWvWMatchOverview;
import me.xhsun.guildwars2wrapper.model.v1.EventDetail;
import me.xhsun.guildwars2wrapper.model.v1.SimpleName;
import me.xhsun.guildwars2wrapper.model.v2.*;
import me.xhsun.guildwars2wrapper.model.v2.account.*;
import me.xhsun.guildwars2wrapper.model.v2.achievement.Achievement;
import me.xhsun.guildwars2wrapper.model.v2.achievement.AchievementCategory;
import me.xhsun.guildwars2wrapper.model.v2.achievement.AchievementGroup;
import me.xhsun.guildwars2wrapper.model.v2.achievement.DailyAchievement;
import me.xhsun.guildwars2wrapper.model.v2.backstory.BackStoryAnswer;
import me.xhsun.guildwars2wrapper.model.v2.backstory.BackStoryQuestion;
import me.xhsun.guildwars2wrapper.model.v2.character.Character;
import me.xhsun.guildwars2wrapper.model.v2.character.*;
import me.xhsun.guildwars2wrapper.model.v2.commerce.*;
import me.xhsun.guildwars2wrapper.model.v2.continent.Continent;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentFloor;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentMap;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentRegion;
import me.xhsun.guildwars2wrapper.model.v2.guild.*;
import me.xhsun.guildwars2wrapper.model.v2.pvp.*;
import me.xhsun.guildwars2wrapper.model.v2.story.Story;
import me.xhsun.guildwars2wrapper.model.v2.story.StorySeason;
import me.xhsun.guildwars2wrapper.model.v2.util.Inventory;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWAbility;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWObjective;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWRank;
import me.xhsun.guildwars2wrapper.model.v2.wvw.WvWUpgrade;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatchDetail;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatchOverview;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatchScore;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatchStat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

/**
 * API interface for different calls
 *
 * @author xhsun
 * @since 2017-02-07
 */
interface GuildWars2API {
	//API:1
	//Event Detail (lang)
	@GET("/v1/event_details.json")
	Call<EventDetail> getAllEventDetailedInfo();

	@GET("/v1/event_details.json")
	Call<EventDetail> getEventDetailedInfo(@Query("event_id") String id);

	//Map Names (lang)
	@GET("/v1/map_names.json")
	Call<List<SimpleName>> getAllMapNames();

	//World Names (lang)
	@GET("/v1/world_names.json")
	Call<List<SimpleName>> getAllWorldNames();

	//WvW Matches
	@GET("/v1/wvw/matches.json")
	Call<AllWvWMatchOverview> getAllWvWMatchOverview();

	//WvW Objective Names (lang)
	@GET("/v1/wvw/objective_names.json")
	Call<List<SimpleName>> getAllWvWObjectiveNames();

	//API:2
	//token info
	@GET("/v2/tokeninfo")
	Call<TokenInfo> getAPIInfo(@Query("access_token") String token);

	//accounts
	@GET("/v2/account")
	Call<Account> getAccount(@Query("access_token") String token);

	@GET("/v2/account/achievement")
	Call<List<AchievementProgression>> getAchievementProgression(@Query("access_token") String token);

	@GET("/v2/account/bank")
	Call<List<Inventory>> getBank(@Query("access_token") String token);

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
	Call<List<Inventory>> getSharedInventory(@Query("access_token") String token);

	@GET("/v2/account/mailcarriers")
	Call<List<Integer>> getUnlockedMailCarriers(@Query("access_token") String token);

	@GET("/v2/account/masteries")
	Call<List<UnlockedMastery>> getUnlockedMasteries(@Query("access_token") String token);

	@GET("/v2/account/materials")
	Call<List<MaterialStorage>> getMaterialBank(@Query("access_token") String token);

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

	//Achievement (lang)
	@GET("/v2/achievements")
	Call<List<Integer>> getAllAchievementIDs();

	@GET("/v2/achievements")
	Call<List<Achievement>> getAchievementInfo(@Query("ids") String ids);

	//Achievements Categories (lang)
	@GET("/v2/achievements/categories")
	Call<List<Integer>> getAllAchievementCategoryIDs();

	@GET("/v2/achievements/categories")
	Call<List<AchievementCategory>> getAchievementCategoryInfo(@Query("ids") String ids);

	//Achievements Daily
	@GET("/v2/achievements/daily")
	Call<DailyAchievement> getCurrentDailyAchievements();

	@GET("/v2/achievements/daily/tomorrow")
	Call<DailyAchievement> getNextDailyAchievements();

	//Achievements Group (lang)
	@GET("/v2/achievements/groups")
	Call<List<String>> getAllAchievementGroupIDs();

	@GET("/v2/achievements/groups")
	Call<List<AchievementGroup>> getAchievementGroupInfo(@Query("ids") String ids);

	//TODO Adventures (Disable, lang)

	//TODO Adventures Leaderboards (Disable)

	//TODO Adventures Leaderboards Regions (Disable)

	//Back Story  Answers (lang)
	@GET("/v2/backstory/answers")
	Call<List<String>> getAllBackStoryAnswerIDs();

	@GET("/v2/backstory/answers")
	Call<List<BackStoryAnswer>> getBackStoryAnswerInfo(@Query("ids") String ids);

	//Back Story  Questions (lang)
	@GET("/v2/backstory/questions")
	Call<List<Integer>> getAllBackStoryQuestionIDs();

	@GET("/v2/backstory/questions")
	Call<List<BackStoryQuestion>> getBackStoryQuestionInfo(@Query("ids") String ids);

	//Current PvPGame Build
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
	Call<CharacterCore> getCharacterCore(@Path("name") String name, @Query("access_token") String token);

	@GET("/v2/characters/{name}/crafting")
	Call<CharacterCraftingLevel> getCharacterCrafting(@Path("name") String name, @Query("access_token") String token);

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

	//colors (lang)
	@GET("/v2/colors")
	Call<List<Integer>> getAllColorIDs();

	@GET("/v2/colors")
	Call<List<Color>> getColorInfo(@Query("ids") String ids);

	//TP
	//TP Delivery (Disabled)
	@GET("/v2/commerce/delivery")
	Call<List<Delivery>> getTPDeliveryInfo(@Query("access_token") String token);

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

	//continents (lang)
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

	//currencies (lang)
	@GET("/v2/currencies")
	Call<List<Integer>> getAllCurrencies();

	@GET("/v2/currencies")
	Call<List<Currency>> getCurrencyInfo(@Query("ids") String ids);

	//dungeons (lang)
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

	//TODO Events (Disabled, lang)

	//TODO Events State (Disabled)

	//Files
	@GET("/v2/files")
	Call<List<String>> getAllFileIDs();

	@GET("/v2/files")
	Call<List<Asset>> getAllFileInfo(@Query("ids") String ids);

	//Finishers (lang)
	@GET("/v2/finishers")
	Call<List<Integer>> getAllFinisherIDs();

	@GET("/v2/finishers")
	Call<List<Finisher>> getFinisherInfo(@Query("ids") String ids);

	//TODO Gemstore Catalog (Disabled, lang)

	//Gliders (lang)
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

	//Guild Permissions (lang)
	@GET("/v2/guild/permissions")
	Call<List<String>> getAllGuildPermissionIDs();

	@GET("/v2/guild/permissions")
	Call<List<GuildPermission>> getGuildPermissionInfo(@Query("ids") String ids);

	//Guild Search
	@GET("/v2/guild/search")
	Call<List<String>> searchGuildID(@Query("name") String name);

	//Guild Upgrades
	@GET("/v2/guild/upgrades")
	Call<List<Integer>> getAllGuildUpgradeIDs();

	@GET("/v2/guild/upgrades")
	Call<List<GuildUpgrade>> getGuildUpgradeInfo(@Query("ids") String ids);

	//items (lang)
	@GET("/v2/items")
	Call<List<Integer>> getAllItemIDs();

	@GET("/v2/items")
	Call<List<Item>> getItemInfo(@Query("ids") String ids);

	//item stat (lang)
	@GET("/v2/itemstats")
	Call<List<Integer>> getAllItemStatIDs();

	@GET("/v2/itemstats")
	Call<List<ItemStats>> getItemStatInfo(@Query("ids") String ids);

	//Legends
	@GET("/v2/legends")
	Call<List<String>> getAllLegendIDs();

	@GET("/v2/legends")
	Call<List<Legend>> getLegendInfo(@Query("ids") String ids);

	//mail carriers (lang)
	@GET("/v2/mailcarriers")
	Call<List<Integer>> getAllMailCarrierIDs();

	@GET("/v2/mailcarriers")
	Call<List<MailCarrier>> getMailCarrierInfo(@Query("ids") String ids);

	//Map (lang)
	@GET("/v2/maps")
	Call<List<Integer>> getAllMapIDs();

	@GET("/v2/maps")
	Call<List<MapOverview>> getMapInfo(@Query("ids") String ids);

	//masteries (lang)
	@GET("/v2/masteries")
	Call<List<Integer>> getAllMasteryIDs();

	@GET("/v2/masteries")
	Call<List<Mastery>> getMasteryInfo(@Query("ids") String ids);

	//material categories (lang)
	@GET("/v2/materials")
	Call<List<Integer>> getAllMaterialBankIDs();

	@GET("/v2/materials")
	Call<List<MaterialCategory>> getMaterialBankInfo(@Query("ids") String ids);

	//minis (lang)
	@GET("/v2/minis")
	Call<List<Integer>> getAllMiniIDs();

	@GET("/v2/minis")
	Call<List<Mini>> getMiniInfo(@Query("ids") String ids);

	//Nodes
	@GET("/v2/nodes")
	Call<List<String>> getAllHomeInstanceNodeIDs();

	//Outfits (lang)
	@GET("/v2/outfits")
	Call<List<Integer>> getAllOutfitIDs();

	@GET("/v2/outfits")
	Call<List<Outfit>> getOutfitInfo(@Query("ids") String ids);

	//Pets (lang)
	@GET("/v2/pets")
	Call<List<Integer>> getAllPetIDs();

	@GET("/v2/pets")
	Call<List<Pet>> getPetInfo(@Query("ids") String ids);

	//Professions (lang)
	@GET("/v2/professions")
	Call<List<String>> getAllProfessionIDs();

	@GET("/v2/professions")
	Call<List<Profession>> getProfessionInfo(@Query("ids") String ids);

	//PvP Amulets (lang)
	@GET("/v2/pvp/amulets")
	Call<List<Integer>> getAllPvPAmuletIDs();

	@GET("/v2/pvp/amulets")
	Call<List<PvPAmulet>> getPvPAmuletInfo(@Query("ids") String ids);

	//PvP Games
	@GET("/v2/pvp/games")
	Call<List<String>> getAllPvPGameIDs(@Query("access_token") String token);

	@GET("/v2/pvp/games")
	Call<List<PvPGame>> getPvPGameInfo(@Query("access_token") String token, @Query("ids") String ids);

	//PvP Heroes (lang)
	@GET("/v2/pvp/heroes")
	Call<List<String>> getAllPvPHeroIDs();

	@GET("/v2/pvp/heroes")
	Call<List<PvPHero>> getPvPHeroInfo(@Query("ids") String ids);

	//PvP Ranks (lang)
	@GET("/v2/pvp/ranks")
	Call<List<Integer>> getAllPvPRankIDs();

	@GET("/v2/pvp/ranks")
	Call<List<PvPRank>> getPvPRankInfo(@Query("ids") String ids);

	//TODO PvP Rewardtracks (Disabled, lang)

	//PvP Seasons (lang)
	@GET("/v2/pvp/seasons")
	Call<List<String>> getAllPvPSeasonIDs();

	@GET("/v2/pvp/seasons")
	Call<List<PvPSeason>> getPvPSeasonInfo(@Query("ids") String ids);

	//PvP Seasons LeaderBoard
	@GET("/v2/pvp/seasons/{id}/leaderboards/{type}/{region}")
	Call<List<PvPLeaderBoard>> getPvPSeasonLeaderBoardInfo(@Path("id") String id, @Path("type") String type, @Path("region") String region);

	//TODO PvP Sigils (Disabled, lang)

	//PvP Standings
	@GET("/v2/pvp/standings")
	Call<List<PvPStanding>> getPvPStandingInfo(@Query("access_token") String token);

	//PvP Stats
	@GET("/v2/pvp/stats")
	Call<PvPStat> getPvPStatInfo(@Query("access_token") String token);

	//Quaggans
	@GET("/v2/quaggans")
	Call<List<String>> getAllQuagganIDs();

	@GET("/v2/quaggans")
	Call<List<Map<String, String>>> getQuagganInfo(@Query("ids") String ids);

	//Races (lang)
	@GET("/v2/races")
	Call<List<String>> getAllRaceIDs();

	@GET("/v2/races")
	Call<List<Race>> getRaceInfo(@Query("ids") String ids);

	//Raids (lang)
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

	//Skills (lang)
	@GET("/v2/skills")
	Call<List<Integer>> getAllSkillIDs();

	@GET("/v2/skills")
	Call<List<Skill>> getSkillInfo(@Query("ids") String ids);

	//skins (lang)
	@GET("/v2/skins")
	Call<List<Integer>> getAllSkinIDs();

	@GET("/v2/skins")
	Call<List<Skin>> getSkinInfo(@Query("ids") String ids);

	//Specializations (lang)
	@GET("/v2/specializations")
	Call<List<Integer>> getAllSpecializationIDs();

	@GET("/v2/specializations")
	Call<List<Specialization>> getSpecializationInfo(@Query("ids") String ids);

	//Stories (lang)
	@GET("/v2/stories")
	Call<List<Integer>> getAllStoryIDs();

	@GET("/v2/stories")
	Call<List<Story>> getStoryInfo(@Query("ids") String ids);

	//Stories Seasons (lang)
	@GET("/v2/stories/seasons")
	Call<List<String>> getAllStorySeasonIDs();

	@GET("/v2/stories/seasons")
	Call<List<StorySeason>> getStorySeasonInfo(@Query("ids") String ids);

	//Titles (lang)
	@GET("/v2/titles")
	Call<List<Integer>> getAllTitleIDs();

	@GET("/v2/titles")
	Call<List<Title>> getTitleInfo(@Query("ids") String ids);

	//Traits (lang)
	@GET("/v2/traits")
	Call<List<Integer>> getAllTraitIDs();

	@GET("/v2/traits")
	Call<List<Trait>> getTraitInfo(@Query("ids") String ids);

	//TODO Vendors (Disabled, lang)

	//worlds (lang)
	@GET("/v2/worlds")
	Call<List<Integer>> getAllWorldsIDs();

	@GET("/v2/worlds")
	Call<List<World>> getWorldsInfo(@Query("ids") String ids);

	//WvW Abilities (lang)
	@GET("/v2/wvw/abilities")
	Call<List<Integer>> getAllWvWAbilityIDs();

	@GET("/v2/wvw/abilities")
	Call<List<WvWAbility>> getWvWAbilityInfo(@Query("ids") String ids);

	//WvW Matches
	@GET("/v2/wvw/matches")
	Call<List<String>> getAllWvWMatchIDs();

	@GET("/v2/wvw/matches")
	Call<WvWMatchDetail> getWvWMatchInfoUsingWorld(@Query("world") String world);

	@GET("/v2/wvw/matches/overview")
	Call<WvWMatchOverview> getWvWMatchOverviewUsingWorld(@Query("world") String world);

	@GET("/v2/wvw/matches/scores")
	Call<WvWMatchScore> getWvWMatchScoreUsingWorld(@Query("world") String world);

	@GET("/v2/wvw/matches/stats")
	Call<WvWMatchStat> getWvWMatchStatUsingWorld(@Query("world") String world);

	@GET("/v2/wvw/matches")
	Call<List<WvWMatchDetail>> getWvWMatchInfoUsingID(@Query("ids") String ids);

	@GET("/v2/wvw/matches/overview")
	Call<List<WvWMatchOverview>> getWvWMatchOverviewUsingID(@Query("ids") String ids);

	@GET("/v2/wvw/matches/scores")
	Call<List<WvWMatchScore>> getWvWMatchScoreUsingID(@Query("ids") String ids);

	@GET("/v2/wvw/matches/stats")
	Call<List<WvWMatchStat>> getWvWMatchStatUsingID(@Query("ids") String ids);

	//WvW Teams
//  TODO this endpoint isn't returning anything, disabled for now
//	@GET("/v2/wvw/matches/stats/{id}/teams/{side}/top/{type}")
//	Call<List<WvWTeam>> getWvWMatchTeamInfo(@Path("id") String match_id, @Path("side") String side, @Path("type") String type);

	//WvW Objectives (lang)
	@GET("/v2/wvw/objectives")
	Call<List<String>> getAllWvWObjectiveIDs();

	@GET("/v2/wvw/objectives")
	Call<List<WvWObjective>> getWvWObjectiveInfo(@Query("ids") String ids);

	//WvW Ranks (lang)
	@GET("/v2/wvw/ranks")
	Call<List<Integer>> getAllWvWRankIDs();

	@GET("/v2/wvw/ranks")
	Call<List<WvWRank>> getWvWRankInfo(@Query("ids") String ids);

	//TODO WvW Rewardtacks (Disabled, lang)

	//WvW Upgrades (lang)
	@GET("/v2/wvw/upgrades")
	Call<List<Integer>> getAllWvWUpgradeIDs();

	@GET("/v2/wvw/upgrades")
	Call<List<WvWUpgrade>> getWvWUpgradeInfo(@Query("ids") String ids);
}
