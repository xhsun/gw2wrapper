package me.xhsun.guildwars2wrapper.v2;

import me.xhsun.guildwars2wrapper.GuildWars2;
import me.xhsun.guildwars2wrapper.SynchronousRequest;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.Cat;
import me.xhsun.guildwars2wrapper.model.v2.TokenInfo;
import me.xhsun.guildwars2wrapper.model.v2.account.*;
import me.xhsun.guildwars2wrapper.model.v2.character.Character;
import me.xhsun.guildwars2wrapper.model.v2.character.*;
import me.xhsun.guildwars2wrapper.model.v2.commerce.Delivery;
import me.xhsun.guildwars2wrapper.model.v2.commerce.Transaction;
import me.xhsun.guildwars2wrapper.model.v2.guild.*;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPGame;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPStanding;
import me.xhsun.guildwars2wrapper.model.v2.pvp.PvPStat;
import me.xhsun.guildwars2wrapper.model.v2.util.Inventory;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * Test all supported API:2 endpoints that requires an authentication
 * and print out result from each endpoint if a valid token is provided
 *
 * @author xhsun
 * @since 2017-06-30
 */
public class GuildWars2V2AuthURLTest {
	private SynchronousRequest s = GuildWars2.getInstance().getSynchronous();
	//TODO input a valid token, character name, and guild id
	private static final String TOKEN = "API_Token";
	private static final String NAME = "characterName";
	private static final String GUILD = "guildID";
	private static final String PVP_GAME = "PvP_game_id";
	private static final int LOG_SINCE = -1;

	//TODO remove comment to set language
//	@Before
//	public void setUp() throws Exception {
//		GuildWars2.setLanguage(GuildWars2.LanguageSelect.Spanish);
//	}

	private void handleException(GuildWars2Exception e) {
		switch (e.getErrorCode()) {
			case Limit:
			case Network:
				fail("Check your network connection");
				break;
			case Server:
				fail("Wrong URL");
				break;
			case Other:
				if (e.getMessage().matches("Endpoint not available"))
					fail("Disabled Endpoint");
				break;
			default:
				fail("Encountered an error: " + e.getMessage());
		}
	}

	//Token Info
	@Test
	public void getAPIInfo() {
		try {
			TokenInfo t = s.getAPIInfo(TOKEN);
			System.out.println("TokenInfo{" +
					"id='" + t.getId() + '\'' +
					", name='" + t.getName() + '\'' +
					", permissions=" + t.getPermissions() +
					'}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Account
	@Test
	public void getAccountInfo() {
		try {
			Account a = s.getAccountInfo(TOKEN);
			System.out.println("Account{" +
					"id='" + a.getId() + '\'' +
					", age=" + a.getAge() +
					", name='" + a.getName() + '\'' +
					", world=" + a.getWorldId() +
					", guilds=" + a.getGuilds() +
					", guild_leader=" + a.getGuildLeader() +
					", created='" + a.getCreated() + '\'' +
					", access=" + a.getAccess() +
					", commander=" + a.isCommander() +
					", fractal_level=" + a.getFractalLevel() +
					", daily_ap=" + a.getDailyAP() +
					", monthly_ap=" + a.getMonthlyAP() +
					", wvw_rank=" + a.getWvwRank() +
					'}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getAchievementProgression() {
		try {
			for (AchievementProgression a : s.getAchievementProgression(TOKEN)) {
				System.out.println("AchievementProgression{" +
						"id='" + a.getId() + '\'' +
						", current=" + a.getCurrent() +
						", max=" + a.getMax() +
						", done=" + a.isDone() +
						", repeated=" + a.getRepeated() +
						", bits=" + Arrays.toString(a.getBits()) +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getBank() {
		try {
			for (Inventory i : s.getBank(TOKEN)) {
				if (i == null) {
					System.out.println("NULL");
					continue;
				}
				System.out.println("Inventory{" +
						"id='" + i.getId() + '\'' +
						", infusions=" + i.getInfusions() +
						", upgrades=" + i.getUpgrades() +
						", skin=" + i.getSkin() +
						", stats=" + i.getStats() +
						", count=" + i.getCount() +
						", charges=" + i.getCharges() +
						", binding=" + i.getBinding() +
						", bound_to='" + i.getBoundTo() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getDailyDungeonProgression() {
		try {
			System.out.println(s.getDailyDungeonProgression(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedDyes() {
		try {
			System.out.println(s.getUnlockedDyes(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedFinishers() {
		try {
			for (UnlockedFinisher f : s.getUnlockedFinishers(TOKEN)) {
				System.out.println("UnlockedFinisher{" +
						"id='" + f.getId() + '\'' +
						", permanent=" + f.isPermanent() +
						", quantity=" + f.getQuantity() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedGliders() {
		try {
			System.out.println(s.getUnlockedGliders(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedCats() {
		try {
			for (Cat c : s.getUnlockedCats(TOKEN)) {
				System.out.println("Cat{" +
						"id='" + c.getId() + '\'' +
						", hint='" + c.getHint() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedHomeNodes() {
		try {
			System.out.println(s.getUnlockedHomeNodes(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getSharedInventory() {
		try {
			for (Inventory i : s.getSharedInventory(TOKEN)) {
				if (i == null) {
					System.out.println("NULL");
					continue;
				}
				System.out.println("Inventory{" +
						"id='" + i.getId() + '\'' +
						", infusions=" + i.getInfusions() +
						", upgrades=" + i.getUpgrades() +
						", skin=" + i.getSkin() +
						", stats=" + i.getStats() +
						", count=" + i.getCount() +
						", charges=" + i.getCharges() +
						", binding=" + i.getBinding() +
						", bound_to='" + i.getBoundTo() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedMailCarriers() {
		try {
			System.out.println(s.getUnlockedMailCarriers(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedMasteries() {
		try {
			for (UnlockedMastery m : s.getUnlockedMasteries(TOKEN)) {
				if (m == null) {
					System.out.println("NULL");
					continue;
				}
				System.out.println("UnlockedMastery{" +
						"id='" + m.getId() + '\'' +
						", level=" + m.getLevel() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getMaterialStorage() {
		try {
			for (MaterialStorage m : s.getMaterialStorage(TOKEN)) {
				if (m == null) {
					System.out.println("NULL");
					continue;
				}
				System.out.println("MaterialStorage{" +
						"id='" + m.getId() + '\'' +
						", category=" + m.getCategory() +
						", count=" + m.getCount() +
						", charges=" + m.getCharges() +
						", binding=" + m.getBinding() +
						", bound_to='" + m.getBoundTo() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedMinis() {
		try {
			System.out.println(s.getUnlockedMinis(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedOutfits() {
		try {
			System.out.println(s.getUnlockedOutfits(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedPvpHeroes() {
		try {
			System.out.println(s.getUnlockedPvpHeroes(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getWeeklyRaidProgression() {
		try {
			System.out.println(s.getWeeklyRaidProgression(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedRecipes() {
		try {
			System.out.println(s.getUnlockedRecipes(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedSkins() {
		try {
			System.out.println(s.getUnlockedSkins(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getUnlockedTitles() {
		try {
			System.out.println(s.getUnlockedTitles(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getWallet() {
		try {
			for (Wallet w : s.getWallet(TOKEN)) {
				if (w == null) {
					System.out.println("NULL");
					continue;
				}
				System.out.println("Wallet{" +
						"id=" + w.getCurrencyId() +
						", value=" + w.getValue() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Character

	@Test
	public void getAllCharacterName() {
		try {
			System.out.println(s.getAllCharacterName(TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacter() {
		try {
			Character c = s.getCharacter(TOKEN, NAME);
			CharacterSpecialization.Specialization sp = c.getSpecializations();
			CharacterSkills.Skills sk = c.getSkills();
			Character.PvPEquipment pe = c.getEquipmentPvP();

			System.out.println("Character{" +
					"name='" + c.getName() + '\'' +
					", race=" + c.getRace() +
					", gender=" + c.getGender() +
					", profession=" + c.getProfession() +
					", level=" + c.getLevel() +
					", guild='" + c.getGuild() + '\'' +
					", age=" + c.getAge() +
					", created='" + c.getCreated() + '\'' +
					", deaths=" + c.getDeath() +
					", title=" + c.getTitle() +
					", crafting=");
			for (CharacterCraftingLevel.Discipline d : c.getCrafting()) {
				System.out.println("Discipline{" +
						"discipline=" + d.getDiscipline() +
						", rating=" + d.getRating() +
						", active=" + d.isActive() +
						'}');
			}
			System.out.println(", backstory=" + c.getBackStory());
			for (Character.WvWAbility a : c.getWvWAbilities()) {
				System.out.println("WvWAbility{" +
						"id='" + a.getId() + '\'' +
						", rank=" + a.getRank() +
						'}');
			}
			System.out.println(", specializations=" + "Specialization{" + "pve=");
			for (CharacterSpecialization.Trait t : sp.getPve()) {
				System.out.println("Trait{" +
						"id='" + t.getId() + '\'' +
						", traits=" + t.getTraits() +
						'}');
			}
			System.out.println(", pvp=");
			for (CharacterSpecialization.Trait t : sp.getPvp()) {
				System.out.println("Trait{" +
						"id='" + t.getId() + '\'' +
						", traits=" + t.getTraits() +
						'}');
			}
			System.out.println(", wvw=");
			for (CharacterSpecialization.Trait t : sp.getWvw()) {
				System.out.println("Trait{" +
						"id='" + t.getId() + '\'' +
						", traits=" + t.getTraits() +
						'}');
			}
			System.out.println('}');
			System.out.println(", skills=" + "Skills{" +
					"pve=" + "Utility{" +
					"heal=" + sk.getPve().getHeal() +
					", utilities=" + sk.getPve().getUtilities() +
					", elite=" + sk.getPve().getElite() +
					'}' +
					", pvp=" + "Utility{" +
					"heal=" + sk.getPvp().getHeal() +
					", utilities=" + sk.getPvp().getUtilities() +
					", elite=" + sk.getPvp().getElite() +
					'}' +
					", wvw=" + "Utility{" +
					"heal=" + sk.getWvw().getHeal() +
					", utilities=" + sk.getWvw().getUtilities() +
					", elite=" + sk.getWvw().getElite() +
					'}' +
					'}');
			System.out.println(", equipment=");
			for (CharacterEquipment.Equipment ce : c.getEquipment()) {
				if (ce == null) {
					System.out.println("NULL");
					continue;
				}
				System.out.println("Equipment{" +
						"id='" + ce.getId() + '\'' +
						", slot=" + ce.getSlot() +
						", dyes=" + ce.getDyes() +
						", infusions=" + ce.getInfusions() +
						", upgrades=" + ce.getUpgrades() +
						", skin=" + ce.getSkin() +
						", stats=" + ce.getStats() +
						", count=" + ce.getCount() +
						", charges=" + ce.getCharges() +
						", binding=" + ce.getBinding() +
						", bound_to='" + ce.getBoundTo() + '\'' +
						'}');
			}
			System.out.println(", recipes=" + c.getRecipes() +
					", equipment_pvp=" + "PvPEquipment{" +
					"amulet=" + pe.getAmulet() +
					", rune=" + pe.getRune() +
					", sigils=" + pe.getSigils() +
					'}' + ", training=");
			for (CharacterTraining.Training t : c.getTraining()) {
				System.out.println("Trait{" +
						"id='" + t.getId() + '\'' +
						", spent=" + t.getSpent() +
						", done=" + t.isDone() +
						'}');
			}
			System.out.println(", bags=");
			for (CharacterBag b : c.getBags()) {
				System.out.println("CharacterBag{" +
						"id='" + b.getId() + '\'' +
						", size=" + b.getSize() +
						", inventory=");
				for (Inventory i : b.getInventory()) {
					if (i == null) {
						System.out.println("NULL");
						continue;
					}
					System.out.println("Inventory{" +
							"id='" + i.getId() + '\'' +
							", infusions=" + i.getInfusions() +
							", upgrades=" + i.getUpgrades() +
							", skin=" + i.getSkin() +
							", stats=" + i.getStats() +
							", count=" + i.getCount() +
							", charges=" + i.getCharges() +
							", binding=" + i.getBinding() +
							", bound_to='" + i.getBoundTo() + '\'' +
							'}');
				}
				System.out.println('}');
			}
			System.out.println('}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterBackStory() {
		try {
			System.out.println(s.getCharacterBackStory(TOKEN, NAME).getBackStory());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterInformation() {
		try {
			CharacterCore c = s.getCharacterInformation(TOKEN, NAME);
			System.out.println();
			System.out.println("CharacterCore{" +
					"name='" + c.getName() + '\'' +
					", race=" + c.getRace() +
					", gender=" + c.getGender() +
					", profession=" + c.getProfession() +
					", level=" + c.getLevel() +
					", guild='" + c.getGuild() + '\'' +
					", age=" + c.getAge() +
					", created='" + c.getCreated() + '\'' +
					", deaths=" + c.getDeath() +
					", title=" + c.getTitle() + '}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterCrafting() {
		try {
			for (CharacterCraftingLevel.Discipline d : s.getCharacterCrafting(TOKEN, NAME).getCrafting()) {
				System.out.println("Discipline{" +
						"discipline=" + d.getDiscipline() +
						", rating=" + d.getRating() +
						", active=" + d.isActive() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterEquipment() {
		try {
			for (CharacterEquipment.Equipment e : s.getCharacterEquipment(TOKEN, NAME).getEquipment()) {
				if (e == null) {
					System.out.println("NULL");
					continue;
				}
				System.out.println("Equipment{" +
						"id='" + e.getId() + '\'' +
						", slot=" + e.getSlot() +
						", dyes=" + e.getDyes() +
						", infusions=" + e.getInfusions() +
						", upgrades=" + e.getUpgrades() +
						", skin=" + e.getSkin() +
						", stats=" + e.getStats() +
						", count=" + e.getCount() +
						", charges=" + e.getCharges() +
						", binding=" + e.getBinding() +
						", bound_to='" + e.getBoundTo() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterHeroPoints() {
		try {
			System.out.println(s.getCharacterHeroPoints(TOKEN, NAME));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterInventory() {
		try {
			System.out.println();
			for (CharacterBag b : s.getCharacterInventory(TOKEN, NAME).getBags()) {
				System.out.println("CharacterBag{" +
						"id='" + b.getId() + '\'' +
						", size=" + b.getSize() +
						", inventory=");
				for (Inventory i : b.getInventory()) {
					if (i == null) {
						System.out.println("NULL");
						continue;
					}
					System.out.println("Inventory{" +
							"id='" + i.getId() + '\'' +
							", infusions=" + i.getInfusions() +
							", upgrades=" + i.getUpgrades() +
							", skin=" + i.getSkin() +
							", stats=" + i.getStats() +
							", count=" + i.getCount() +
							", charges=" + i.getCharges() +
							", binding=" + i.getBinding() +
							", bound_to='" + i.getBoundTo() + '\'' +
							'}');
				}
				System.out.println('}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterUnlockedRecipes() {
		try {
			System.out.println(s.getCharacterUnlockedRecipes(TOKEN, NAME).getRecipes());
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterSAB() {
		try {
			CharacterSAB sab = s.getCharacterSAB(TOKEN, NAME);
			System.out.println("CharacterSAB{" +
					"zones=");
			for (CharacterSAB.Zone z : sab.getZones()) {
				System.out.println("Zone{" +
						"mode='" + z.getMode() + '\'' +
						", world=" + z.getWorld() +
						", zone=" + z.getZone() +
						'}');
			}
			System.out.println(", unlocks=" + sab.getUnlocks() +
					", songs=" + sab.getSongs() + '}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterSkills() {
		try {
			CharacterSkills sk = s.getCharacterSkills(TOKEN, NAME);
			System.out.println("Skills{" +
					"pve=" + "Utility{" +
					"heal=" + sk.getPve().getHeal() +
					", utilities=" + sk.getPve().getUtilities() +
					", elite=" + sk.getPve().getElite() +
					'}' +
					", pvp=" + "Utility{" +
					"heal=" + sk.getPvp().getHeal() +
					", utilities=" + sk.getPvp().getUtilities() +
					", elite=" + sk.getPvp().getElite() +
					'}' +
					", wvw=" + "Utility{" +
					"heal=" + sk.getWvw().getHeal() +
					", utilities=" + sk.getWvw().getUtilities() +
					", elite=" + sk.getWvw().getElite() +
					'}' + '}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterSpecialization() {
		try {
			CharacterSpecialization sp = s.getCharacterSpecialization(TOKEN, NAME);
			System.out.println("Specialization{" + "pve=");
			for (CharacterSpecialization.Trait t : sp.getPve()) {
				System.out.println("Trait{" +
						"id='" + t.getId() + '\'' +
						", traits=" + t.getTraits() +
						'}');
			}
			System.out.println(", pvp=");
			for (CharacterSpecialization.Trait t : sp.getPvp()) {
				System.out.println("Trait{" +
						"id='" + t.getId() + '\'' +
						", traits=" + t.getTraits() +
						'}');
			}
			System.out.println(", wvw=");
			for (CharacterSpecialization.Trait t : sp.getWvw()) {
				System.out.println("Trait{" +
						"id='" + t.getId() + '\'' +
						", traits=" + t.getTraits() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getCharacterTraining() {
		try {
			for (CharacterTraining.Training t : s.getCharacterTraining(TOKEN, NAME).getTraining()) {
				System.out.println("Trait{" +
						"id='" + t.getId() + '\'' +
						", spent=" + t.getSpent() +
						", done=" + t.isDone() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//TP
	@Test
	public void getTPDeliveryInfo() {
		try {
			Delivery d = s.getTPDeliveryInfo(TOKEN);
			System.out.println("Delivery{" +
					"coins=" + d.getCoins() + ", items=");
			for (Delivery.Item i : d.getItems()) {
				System.out.println("Item{" +
						"id=" + i.getId() +
						", count=" + i.getCount() +
						'}');
			}
			System.out.println('}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getTPTransactionHistorySell() {
		try {
			for (Transaction t : s.getTPTransaction(TOKEN, Transaction.Time.History, Transaction.Type.Sell)) {
				System.out.println("Transaction{" +
						"id=" + t.getId() +
						", item_id=" + t.getItemId() +
						", price=" + t.getPrice() +
						", quantity=" + t.getQuantity() +
						", created='" + t.getCreated() + '\'' +
						", purchased='" + t.getPurchased() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getTPTransactionHistoryBuy() {
		try {
			for (Transaction t : s.getTPTransaction(TOKEN, Transaction.Time.History, Transaction.Type.Buy)) {
				System.out.println("Transaction{" +
						"id=" + t.getId() +
						", item_id=" + t.getItemId() +
						", price=" + t.getPrice() +
						", quantity=" + t.getQuantity() +
						", created='" + t.getCreated() + '\'' +
						", purchased='" + t.getPurchased() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getTPTransactionCurrentSell() {
		try {
			for (Transaction t : s.getTPTransaction(TOKEN, Transaction.Time.Current, Transaction.Type.Sell)) {
				System.out.println("Transaction{" +
						"id=" + t.getId() +
						", item_id=" + t.getItemId() +
						", price=" + t.getPrice() +
						", quantity=" + t.getQuantity() +
						", created='" + t.getCreated() + '\'' +
						", purchased='" + t.getPurchased() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getTPTransactionCurrentBuy() {
		try {
			for (Transaction t : s.getTPTransaction(TOKEN, Transaction.Time.Current, Transaction.Type.Buy)) {
				System.out.println("Transaction{" +
						"id=" + t.getId() +
						", item_id=" + t.getItemId() +
						", price=" + t.getPrice() +
						", quantity=" + t.getQuantity() +
						", created='" + t.getCreated() + '\'' +
						", purchased='" + t.getPurchased() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//Guild
	@Test
	public void getGeneralGuildInfo() {
		try {
			Guild g = s.getGeneralGuildInfo(GUILD);
			System.out.println("Guild{" +
					"id='" + g.getId() + '\'' +
					", name='" + g.getName() + '\'' +
					", level=" + g.getLevel() +
					", aetherium=" + g.getAetherium() +
					", motd='" + g.getMotd() + '\'' +
					", tag='" + g.getTag() + '\'' +
					", influence=" + g.getInfluence() +
					", favor=" + g.getFavor() +
					", emblem=" + "Emblem{" +
					"background=" + "EmblemDetail{" +
					"id='" + g.getEmblem().getBackground().getId() + '\'' +
					", colors=" + g.getEmblem().getBackground().getColors() +
					'}' +
					", foreground=" + "EmblemDetail{" +
					"id='" + g.getEmblem().getForeground().getId() + '\'' +
					", colors=" + g.getEmblem().getForeground().getColors() +
					'}' +
					", flags=" + g.getEmblem().getFlags() +
					'}' +
					'}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getDetailedGuildInfo() {
		try {
			Guild g = s.getDetailedGuildInfo(GUILD, TOKEN);
			System.out.println("Guild{" +
					"id='" + g.getId() + '\'' +
					", name='" + g.getName() + '\'' +
					", level=" + g.getLevel() +
					", aetherium=" + g.getAetherium() +
					", motd='" + g.getMotd() + '\'' +
					", tag='" + g.getTag() + '\'' +
					", influence=" + g.getInfluence() +
					", favor=" + g.getFavor() +
					", emblem=" + "Emblem{" +
					"background=" + "EmblemDetail{" +
					"id='" + g.getEmblem().getBackground().getId() + '\'' +
					", colors=" + g.getEmblem().getBackground().getColors() +
					'}' +
					", foreground=" + "EmblemDetail{" +
					"id='" + g.getEmblem().getForeground().getId() + '\'' +
					", colors=" + g.getEmblem().getForeground().getColors() +
					'}' +
					", flags=" + g.getEmblem().getFlags() +
					'}' +
					'}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getGuildLogInfo() {
		try {
			for (GuildLog l : s.getGuildLogInfo(GUILD, TOKEN)) {
				System.out.println("GuildLog{" +
						"id=" + l.getId() +
						", time='" + l.getTime() + '\'' +
						", user='" + l.getUser() + '\'' +
						", invited_by='" + l.getInvitedBy() + '\'' +
						", kicked_by='" + l.getKickedBy() + '\'' +
						", changed_by='" + l.getChangedBy() + '\'' +
						", old_rank='" + l.getOldRank() + '\'' +
						", new_rank='" + l.getNewRank() + '\'' +
						", motd='" + l.getMotd() + '\'' +
						", item_id=" + l.getItemId() +
						", upgrade_id=" + l.getUpgradeId() +
						", recipe_id=" + l.getRecipeId() +
						", count=" + l.getCount() +
						", coins=" + l.getCoins() +
						", type=" + l.getType() +
						", operation=" + l.getOperation() +
						", action=" + l.getAction() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getGuildLogInfoSince() {
		try {
			for (GuildLog l : s.getFilteredGuildLogInfo(GUILD, TOKEN, LOG_SINCE)) {
				System.out.println("GuildLog{" +
						"id=" + l.getId() +
						", time='" + l.getTime() + '\'' +
						", user='" + l.getUser() + '\'' +
						", invited_by='" + l.getInvitedBy() + '\'' +
						", kicked_by='" + l.getKickedBy() + '\'' +
						", changed_by='" + l.getChangedBy() + '\'' +
						", old_rank='" + l.getOldRank() + '\'' +
						", new_rank='" + l.getNewRank() + '\'' +
						", motd='" + l.getMotd() + '\'' +
						", item_id=" + l.getItemId() +
						", upgrade_id=" + l.getUpgradeId() +
						", recipe_id=" + l.getRecipeId() +
						", count=" + l.getCount() +
						", coins=" + l.getCoins() +
						", type=" + l.getType() +
						", operation=" + l.getOperation() +
						", action=" + l.getAction() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getGuildMembersInfo() {
		try {
			for (GuildMember m : s.getGuildMembersInfo(GUILD, TOKEN)) {
				System.out.println("GuildMember{" +
						"name='" + m.getName() + '\'' +
						", rank='" + m.getRank() + '\'' +
						", joined='" + m.getJoined() + '\'' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getGuildRankInfo() {
		try {
			for (GuildRank r : s.getGuildRankInfo(GUILD, TOKEN)) {
				System.out.println("GuildRank{" +
						"id='" + r.getId() + '\'' +
						", order=" + r.getOrder() +
						", icon='" + r.getIcon() + '\'' +
						", permissions=" + r.getPermissions() +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getGuildStashInfo() {
		try {
			for (GuildStash st : s.getGuildStashInfo(GUILD, TOKEN)) {
				System.out.println("GuildStash{" +
						"upgrade_id=" + st.getUpgradeId() +
						", size=" + st.getSize() +
						", coins=" + st.getCoins() +
						", note='" + st.getNote() + '\'' +
						", inventory=");
				for (GuildStash.Inventory i : st.getInventory()) {
					if (i == null) continue;
					System.out.println("Inventory{" +
							"id=" + i.getId() +
							", count=" + i.getCount() +
							'}');
				}
				System.out.println('}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getGuildTeamsInfo() {
		try {
			for (GuildTeam t : s.getGuildTeamsInfo(GUILD, TOKEN)) {
				System.out.println("GuildTeam{" +
						"id=" + t.getId() +
						", name='" + t.getName() + '\'' +
						", members=");
				for (GuildTeam.Member m : t.getMembers()) {
					System.out.println("Member{" +
							"name='" + m.getName() + '\'' +
							", role='" + m.getRole() + '\'' +
							'}');
				}
				System.out.println(", aggregate=" + "WinLoss{" +
						"wins=" + t.getAggregate().getWins() +
						", losses=" + t.getAggregate().getLosses() +
						", desertions=" + t.getAggregate().getDesertions() +
						", byes=" + t.getAggregate().getByes() +
						", forfeits=" + t.getAggregate().getForfeits() +
						'}' + ", ladders=");
				for (Map.Entry<String, PvPStat.WinLoss> e : t.getLadders().entrySet()) {
					PvPStat.WinLoss w = e.getValue();
					System.out.println(e.getKey() + ": WinLoss{" +
							"wins=" + w.getWins() +
							", losses=" + w.getLosses() +
							", desertions=" + w.getDesertions() +
							", byes=" + w.getByes() +
							", forfeits=" + w.getForfeits() +
							'}');
				}
				System.out.println(", games=");
				for (PvPGame g : t.getGames()) {
					System.out.println("PvPGame{" +
							"map_id=" + g.getMapId() +
							", rating_change=" + g.getRatingChange() +
							", started='" + g.getStarted() + '\'' +
							", ended='" + g.getEnded() + '\'' +
							", result='" + g.getResult() + '\'' +
							", team='" + g.getTeam() + '\'' +
							", season='" + g.getSeason() + '\'' +
							", profession=" + g.getProfession() +
							", scores=" + "Score{" +
							"red=" + g.getScores().getRed() +
							", blue=" + g.getScores().getBlue() +
							'}' +
							", rating_type=" + g.getRatingType() +
							'}');
				}
				System.out.println(", seasons=");
				for (GuildTeam.Season s : t.getSeasons()) {
					System.out.println("Season{" +
							"id='" + s.getId() + '\'' +
							", wins=" + s.getWins() +
							", losses=" + s.getLosses() +
							", rating=" + s.getRating() +
							'}');
				}
				System.out.println('}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getGuildTreasuryInfo() {
		try {
			for (GuildTreasury t : s.getGuildTreasuryInfo(GUILD, TOKEN)) {
				System.out.println("GuildTreasury{" +
						"item_id=" + t.getItemId() +
						", count=" + t.getCount() +
						", needed_by=");
				for (GuildTreasury.NeedBy n : t.getNeededBy()) {
					System.out.println("NeedBy{" +
							"upgrade_id=" + n.getUpgradeId() +
							", count=" + n.getCount() +
							'}');
				}
				System.out.println('}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getGuildUnlockedUpgradesID() {
		try {
			System.out.println(s.getGuildUnlockedUpgradesID(GUILD, TOKEN));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	//PvP
	@Test
	public void getAllPvPGameID() {
		try {
			System.out.println(s.getAllPvPGameID(TOKEN));
			System.out.println(s.getPvPGameInfo(TOKEN, new String[]{PVP_GAME}));
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getPvPStandingInfo() {
		try {
			for (PvPStanding p : s.getPvPStandingInfo(TOKEN)) {
				System.out.println("PvPStanding{" +
						"season_id='" + p.getSeasonId() + '\'' +
						", current=" + "Standing{" +
						"total_points=" + p.getCurrent().getTotalPoints() +
						", division=" + p.getCurrent().getDivision() +
						", tier=" + p.getCurrent().getTier() +
						", points=" + p.getCurrent().getPoints() +
						", repeats=" + p.getCurrent().getRepeats() +
						", rating=" + p.getCurrent().getRating() +
						", decay=" + p.getCurrent().getDecay() +
						'}' +
						", best=" + "Standing{" +
						"total_points=" + p.getBest().getTotalPoints() +
						", division=" + p.getBest().getDivision() +
						", tier=" + p.getBest().getTier() +
						", points=" + p.getBest().getPoints() +
						", repeats=" + p.getBest().getRepeats() +
						", rating=" + p.getBest().getRating() +
						", decay=" + p.getBest().getDecay() +
						'}' +
						'}');
			}
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}

	@Test
	public void getPvPStatInfo() {
		try {
			PvPStat p = s.getPvPStatInfo(TOKEN);
			System.out.println("PvPStat{" +
					"pvp_rank=" + p.getPvPRank() +
					", pvp_rank_points=" + p.getPvpRankPoints() +
					", pvp_rank_rollovers=" + p.getPvPRankRollovers() +
					", aggregate=" + "WinLoss{" +
					"wins=" + p.getAggregate().getWins() +
					", losses=" + p.getAggregate().getLosses() +
					", desertions=" + p.getAggregate().getDesertions() +
					", byes=" + p.getAggregate().getByes() +
					", forfeits=" + p.getAggregate().getForfeits() +
					'}' + ", professions=");
			for (Map.Entry<String, PvPStat.WinLoss> e : p.getProfessions().entrySet()) {
				PvPStat.WinLoss w = e.getValue();
				System.out.println(e.getKey() + ": WinLoss{" +
						"wins=" + w.getWins() +
						", losses=" + w.getLosses() +
						", desertions=" + w.getDesertions() +
						", byes=" + w.getByes() +
						", forfeits=" + w.getForfeits() +
						'}');
			}
			System.out.println(", ladders=");
			for (Map.Entry<String, PvPStat.WinLoss> e : p.getLadders().entrySet()) {
				PvPStat.WinLoss w = e.getValue();
				System.out.println(e.getKey() + ": WinLoss{" +
						"wins=" + w.getWins() +
						", losses=" + w.getLosses() +
						", desertions=" + w.getDesertions() +
						", byes=" + w.getByes() +
						", forfeits=" + w.getForfeits() +
						'}');
			}
			System.out.println('}');
		} catch (GuildWars2Exception e) {
			handleException(e);
		}
	}
}
