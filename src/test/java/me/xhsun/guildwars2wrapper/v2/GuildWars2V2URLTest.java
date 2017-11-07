package me.xhsun.guildwars2wrapper.v2;

import static org.junit.Assert.*;

import org.junit.Test;

import me.xhsun.guildwars2wrapper.*;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.*;
import me.xhsun.guildwars2wrapper.model.v2.achievement.DailyAchievement;
import me.xhsun.guildwars2wrapper.model.v2.commerce.Exchange;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.WvWMatch;
import me.xhsun.guildwars2wrapper.request.*;

/**
 * Test all supported API:2 endpoints and print out result from each endpoint
 *
 * @author xhsun
 * @since 2017-06-30
 */
public class GuildWars2V2URLTest {
	private SynchronousRequest s = GuildWars2.getInstance().getSynchronous();

	private static final int CONTINENT_ID = 1, FLOOR_ID = 1, REGION_ID = 1, MAP_ID = 26, WORLD_ID = 1001;
	private static final String SEARCH_KEY = "edit", PVP_SEASON = "44B85826-B5ED-4890-8C77-82DDF9F2CF2B", PVP_LEADERBOARD = "legendary";

	//TODO remove comment to set language
//	@Before
//	public void setUp() throws Exception {
//		GuildWars2.setLanguage(GuildWars2.LanguageSelect.Spanish);
//	}

	//Achievement
	@Test
	public void getAllAchievementID() throws Exception {
		try {
			System.out.println(s.getAllAchievementID());
			System.out.println(s.getAchievementInfo(new int[]{3884}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	private void handleException(GuildWars2Exception e) {
		switch (e.getErrorCode()) {
			case Limit:
			case Network:
				fail("Check your network connection");
				break;
			case Server:
				fail("Wrong URL");
			case Other:
				if (e.getMessage().matches("Endpoint not available"))
				fail("Disabled Endpoint");
		default:
			fail("Wrong error code");
		}
	}

	@Test
	public void getAllAchievementCategoryID() throws Exception {
		try {
			System.out.println(s.getAllAchievementCategoryIDs());
			System.out.println(s.getAchievementCategoryInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCurrentDailyAchievements() throws Exception {
		try {
			DailyAchievement a = s.getCurrentDailyAchievements();

			System.out.println("DailyAchievement{" + "pve=");
			for (DailyAchievement.Daily d : a.getPve()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println(", pvp=");
			for (DailyAchievement.Daily d : a.getPvp()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println(", wvw=");
			for (DailyAchievement.Daily d : a.getWvw()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println(", fractals=");
			for (DailyAchievement.Daily d : a.getFractals()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println(", special=");
			for (DailyAchievement.Daily d : a.getSpecial()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println('}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getNextDailyAchievements() throws Exception {
		try {
			DailyAchievement a = s.getNextDailyAchievements();

			System.out.println("DailyAchievement{" + "pve=");
			for (DailyAchievement.Daily d : a.getPve()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println(", pvp=");
			for (DailyAchievement.Daily d : a.getPvp()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println(", wvw=");
			for (DailyAchievement.Daily d : a.getWvw()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println(", fractals=");
			for (DailyAchievement.Daily d : a.getFractals()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println(", special=");
			for (DailyAchievement.Daily d : a.getSpecial()) {
				System.out.println("Daily{" +
						"id=" + d.getId() +
						", level=" + "AchievementLevel{" +
						"min=" + d.getLevel().getMin() +
						", max=" + d.getLevel().getMax() +
						'}' +
						", required_access=" + d.getRequiredAccess() +
						'}');
			}
			System.out.println('}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllAchievementGroupID() throws Exception {
		try {
			System.out.println(s.getAllAchievementGroupID());
			System.out.println(s.getAchievementGroupInfo(new String[]{"A4ED8379-5B6B-4ECC-B6E1-70C350C902D2"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Back Story
	@Test
	public void getAllBackStoryAnswerID() throws Exception {
		try {
			System.out.println(s.getAllBackStoryAnswerID());
			System.out.println(s.getBackStoryAnswerInfo(new String[]{"7-54"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllBackStoryQuestionID() throws Exception {
		try {
			System.out.println(s.getAllBackStoryQuestionID());
			System.out.println(s.getBackStoryQuestionInfo(new int[]{7}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Game Build
	@Test
	public void getCurrentGameBuild() throws Exception {
		try {
			System.out.println(s.getCurrentGameBuild().getId());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllCatID() throws Exception {
		try {
			System.out.println(s.getAllCatID());
			System.out.println(s.getCatInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllColorID() throws Exception {
		try {
			System.out.println(s.getAllColorID());
			System.out.println(s.getColorInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllExchangeCurrency() throws Exception {
		try {
			System.out.println(s.getAllExchangeCurrency());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getExchangeInfoCoins() throws Exception {
		try {
			Exchange e = s.getExchangeInfo(Exchange.Type.coins, 10000);
			System.out.println("Exchange{" +
					"coins_per_gem=" + e.getCoinsPerGem() +
					", quantity=" + e.getQuantity() +
					'}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getExchangeInfoGem() throws Exception {
		try {
			Exchange e = s.getExchangeInfo(Exchange.Type.gems, 5000);
			System.out.println("Exchange{" +
					"coins_per_gem=" + e.getCoinsPerGem() +
					", quantity=" + e.getQuantity() +
					'}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllTPListingID() throws Exception {
		try {
			System.out.println(s.getAllTPListingID());
			System.out.println(s.getTPListingInfo(new int[]{24}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllPriceID() throws Exception {
		try {
			System.out.println(s.getAllPriceID());
			System.out.println(s.getPriceInfo(new int[]{24}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Continents

	@Test
	public void getAllContinentID() throws Exception {
		try {
			System.out.println(s.getAllContinentID());
			System.out.println(s.getContinentInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllContinentFloorID() throws Exception {
		try {
			System.out.println(s.getAllContinentFloorID(CONTINENT_ID));
			System.out.println(s.getContinentFloorInfo(CONTINENT_ID, new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllContinentRegionID() throws Exception {
		try {
			System.out.println(s.getAllContinentRegionID(CONTINENT_ID, FLOOR_ID));
			System.out.println(s.getContinentRegionInfo(CONTINENT_ID, FLOOR_ID, new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllContinentMapID() throws Exception {
		try {
			System.out.println(s.getAllContinentMapID(CONTINENT_ID, FLOOR_ID, REGION_ID));
			System.out.println(s.getContinentMapInfo(CONTINENT_ID, FLOOR_ID, REGION_ID, new int[]{26}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllContinentSectorID() throws Exception {
		try {
			System.out.println(s.getAllContinentSectorID(CONTINENT_ID, FLOOR_ID, REGION_ID, MAP_ID));
			System.out.println(s.getContinentSectorInfo(CONTINENT_ID, FLOOR_ID, REGION_ID, MAP_ID, new int[]{513}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllContinentPOIID() throws Exception {
		try {
			System.out.println(s.getAllContinentPOIID(CONTINENT_ID, FLOOR_ID, REGION_ID, MAP_ID));
			System.out.println(s.getContinentPOIInfo(CONTINENT_ID, FLOOR_ID, REGION_ID, MAP_ID, new int[]{554}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllContinentTaskID() throws Exception {
		try {
			System.out.println(s.getAllContinentTaskID(CONTINENT_ID, FLOOR_ID, REGION_ID, MAP_ID));
			System.out.println(s.getContinentTaskInfo(CONTINENT_ID, FLOOR_ID, REGION_ID, MAP_ID, new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Currencies
	@Test
	public void getAllCurrencyID() throws Exception {
		try {
			System.out.println(s.getAllCurrencyID());
			System.out.println(s.getCurrencyInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Dungeons
	@Test
	public void getAllDungeonName() throws Exception {
		try {
			System.out.println(s.getAllDungeonName());
			System.out.println(s.getDungeonInfo(new String[]{"ascalonian_catacombs"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Emblem
	@Test
	public void getAllEmblemType() throws Exception {
		try {
			System.out.println(s.getAllEmblemType());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllEmblemForeground() throws Exception {
		try {
			System.out.println(s.getAllEmblemIDs(Emblem.Type.foregrounds));
			System.out.println(s.getAllEmblemInfo(Emblem.Type.foregrounds, new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllEmblembackground() throws Exception {
		try {
			System.out.println(s.getAllEmblemIDs(Emblem.Type.backgrounds));
			System.out.println(s.getAllEmblemInfo(Emblem.Type.backgrounds, new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Files
	@Test
	public void getAllFileID() throws Exception {
		try {
			System.out.println(s.getAllFileID());
			System.out.println(s.getAllFileInfo(new String[]{"map_complete"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Finisher
	@Test
	public void getAllFinisherID() throws Exception {
		try {
			System.out.println(s.getAllFinisherID());
			System.out.println(s.getFinisherInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Gliders
	@Test
	public void getAllGliderID() throws Exception {
		try {
			System.out.println(s.getAllGliderID());
			System.out.println(s.getGliderInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Guild
	@Test
	public void getGuildPermissionInfo() throws Exception {
		try {
			System.out.println(s.getAllGuildPermissionID());
			System.out.println(s.getGuildPermissionInfo(new String[]{"ClaimableEditOptions"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void searchGuildID() throws Exception {
		try {
			System.out.println(s.searchGuildID(SEARCH_KEY));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAllGuildUpgradeID() throws Exception {
		try {
			System.out.println(s.getAllGuildUpgradeID());
			System.out.println(s.getGuildUpgradeInfo(new int[]{38}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Items
	@Test
	public void getAllItemID() throws Exception {
		try {
			System.out.println(s.getAllItemID());
			System.out.println(s.getItemInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Item Stats
	@Test
	public void getAllItemStatID() throws Exception {
		try {
			System.out.println(s.getAllItemStatID());
			System.out.println(s.getItemStatInfo(new int[]{1011}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Legends
	@Test
	public void getAllLegendID() throws Exception {
		try {
			System.out.println(s.getAllLegendID());
			System.out.println(s.getLegendInfo(new String[]{"Legend6"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Mail Carriers
	@Test
	public void getAllMailCarrierID() throws Exception {
		try {
			System.out.println(s.getAllMailCarrierID());
			System.out.println(s.getMailCarrierInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Maps
	@Test
	public void getAllMapID() throws Exception {
		try {
			System.out.println(s.getAllMapID());
			System.out.println(s.getMapInfo(new int[]{26}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Masteries
	@Test
	public void getAllMasteryID() throws Exception {
		try {
			System.out.println(s.getAllMasteryID());
			System.out.println(s.getMasteryInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Material Categories
	@Test
	public void getAllMaterialCategoryID() throws Exception {
		try {
			System.out.println(s.getAllMaterialCategoryID());
			System.out.println(s.getMaterialCategoryInfo(new int[]{5}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Mini
	@Test
	public void getAllMiniID() throws Exception {
		try {
			System.out.println(s.getAllMiniID());
			System.out.println(s.getMiniInfo(new int[]{26}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Nodes
	@Test
	public void getAllHomeInstanceNodeID() throws Exception {
		try {
			System.out.println(s.getAllHomeInstanceNodeID());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Outfits
	@Test
	public void getAllOutfitID() throws Exception {
		try {
			System.out.println(s.getAllOutfitID());
			System.out.println(s.getOutfitInfo(new int[]{26}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Pets
	@Test
	public void getAllPetID() throws Exception {
		try {
			System.out.println(s.getAllPetID());
			System.out.println(s.getPetInfo(new int[]{26}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Professions
	@Test
	public void getAllProfessionID() throws Exception {
		try {
			System.out.println(s.getAllProfessionID());
			System.out.println(s.getProfessionInfo(new String[]{"Guardian"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//PvP Amulets
	@Test
	public void getAllPvPAmuletID() throws Exception {
		try {
			System.out.println(s.getAllPvPAmuletID());
			System.out.println(s.getPvPAmuletInfo(new int[]{4}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//PvP Heroes
	@Test
	public void getAllPvPHeroID() throws Exception {
		try {
			System.out.println(s.getAllPvPHeroID());
			System.out.println(s.getPvPHeroInfo(new String[]{"115C140F-C2F5-40EB-8EA2-C3773F2AE468"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//PvP Ranks
	@Test
	public void getAllPvPRankID() throws Exception {
		try {
			System.out.println(s.getAllPvPRankID());
			System.out.println(s.getPvPRankInfo(new int[]{4}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//PvP Seasons
	@Test
	public void getAllPvPSeasonID() throws Exception {
		try {
			System.out.println(s.getAllPvPSeasonID());
			System.out.println(s.getPvPSeasonInfo(new String[]{"44B85826-B5ED-4890-8C77-82DDF9F2CF2B"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//PvP Seasons LeaderBoard
	@Test
	public void getPvPSeasonLeaderboardInfo() throws Exception {
		try {
			System.out.println(s.getPvPSeasonLeaderboardInfo(PVP_SEASON, PVP_LEADERBOARD, World.Region.NA));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Quaggans
	@Test
	public void getAllQuagganID() throws Exception {
		try {
			System.out.println(s.getAllQuagganID());
			System.out.println(s.getQuagganInfo(new String[]{"404"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Races
	@Test
	public void getAllRaceID() throws Exception {
		try {
			System.out.println(s.getAllRaceID());
			System.out.println(s.getRaceInfo(new String[]{"Human"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Raids
	@Test
	public void getAllRaidID() throws Exception {
		try {
			System.out.println(s.getAllRaidID());
			System.out.println(s.getRaidInfo(new String[]{"forsaken_thicket"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Recipes
	@Test
	public void getAllRecipeID() throws Exception {
		try {
			System.out.println(s.getAllRecipeID());
			System.out.println(s.getRecipeInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Recipes Search
	@Test
	public void searchRecipesInput() throws Exception {
		try {
			System.out.println(s.searchRecipes(true, 46731));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Recipes Search
	@Test
	public void searchRecipesOutput() throws Exception {
		try {
			System.out.println(s.searchRecipes(false, 50065));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Skills
	@Test
	public void getAllSkillID() throws Exception {
		try {
			System.out.println(s.getAllSkillID());
			System.out.println(s.getSkillInfo(new int[]{1110}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Skins
	@Test
	public void getAllSkinID() throws Exception {
		try {
			System.out.println(s.getAllSkinID());
			System.out.println(s.getSkinInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Specializations
	@Test
	public void getAllSpecializationID() throws Exception {
		try {
			System.out.println(s.getAllSpecializationID());
			System.out.println(s.getSpecializationInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Stories
	@Test
	public void getAllStoryID() throws Exception {
		try {
			System.out.println(s.getAllStoryID());
			System.out.println(s.getStoryInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Stories Seasons
	@Test
	public void getAllStorySeasonID() throws Exception {
		try {
			System.out.println(s.getAllStorySeasonID());
			System.out.println(s.getStorySeasonInfo(new String[]{"B8901E58-DC9D-4525-ADB2-79C93593291E"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Titles
	@Test
	public void getAllTitleID() throws Exception {
		try {
			System.out.println(s.getAllTitleID());
			System.out.println(s.getTitleInfo(new int[]{1}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Trait
	@Test
	public void getAllTraitID() throws Exception {
		try {
			System.out.println(s.getAllTraitID());
			System.out.println(s.getTraitInfo(new int[]{214}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Worlds
	@Test
	public void getAllWorldID() throws Exception {
		try {
			System.out.println(s.getAllWorldID());
			System.out.println(s.getWorldInfo(new int[]{WORLD_ID}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//WvW Abilities
	@Test
	public void getAllWvWAbilityID() throws Exception {
		try {
			System.out.println(s.getAllWvWAbilityID());
			System.out.println(s.getWvWAbilityInfo(new int[]{2}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//WvW Matches
	@Test
	public void getAllWvWMatchID() throws Exception {
		try {
			System.out.println(s.getAllWvWMatchID());
			System.out.println(s.getWvWMatchInfo(WORLD_ID, WvWMatch.Endpoint.All));
			System.out.println(s.getWvWMatchInfo(WORLD_ID, WvWMatch.Endpoint.Overview));
			System.out.println(s.getWvWMatchInfo(WORLD_ID, WvWMatch.Endpoint.Stat));
			System.out.println(s.getWvWMatchInfo(WORLD_ID, WvWMatch.Endpoint.Score));
			System.out.println(s.getWvWMatchInfo(new String[]{"1-2"}, WvWMatch.Endpoint.All));
			System.out.println(s.getWvWMatchInfo(new String[]{"1-2"}, WvWMatch.Endpoint.Overview));
			System.out.println(s.getWvWMatchInfo(new String[]{"1-2"}, WvWMatch.Endpoint.Stat));
			System.out.println(s.getWvWMatchInfo(new String[]{"1-2"}, WvWMatch.Endpoint.Score));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//WvW Objectives
	@Test
	public void getAllWvWObjectiveID() throws Exception {
		try {
			System.out.println(s.getAllWvWObjectiveID());
			System.out.println(s.getWvWObjectiveInfo(new String[]{"38-5"}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//WvW Ranks
	@Test
	public void getAllWvWRankID() throws Exception {
		try {
			System.out.println(s.getAllWvWRankID());
			System.out.println(s.getWvWRankInfo(new int[]{2}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//WvW Upgrades
	@Test
	public void getAllWvWUpgradeID() throws Exception {
		try {
			System.out.println(s.getAllWvWUpgradeID());
			System.out.println(s.getWvWUpgradeInfo(new int[]{3}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}
}
