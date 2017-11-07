package me.xhsun.guildwars2wrapper.request;
	
import java.util.*;
import java.util.function.Consumer;

import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v1.*;
import me.xhsun.guildwars2wrapper.model.v2.*;
import me.xhsun.guildwars2wrapper.model.v2.Currency;
import me.xhsun.guildwars2wrapper.model.v2.Mastery;
import me.xhsun.guildwars2wrapper.model.v2.account.*;
import me.xhsun.guildwars2wrapper.model.v2.achievement.*;
import me.xhsun.guildwars2wrapper.model.v2.backstory.*;
import me.xhsun.guildwars2wrapper.model.v2.character.*;
import me.xhsun.guildwars2wrapper.model.v2.character.Character;
import me.xhsun.guildwars2wrapper.model.v2.commerce.*;
import me.xhsun.guildwars2wrapper.model.v2.continent.*;
import me.xhsun.guildwars2wrapper.model.v2.continent.ContinentMap.*;
import me.xhsun.guildwars2wrapper.model.v2.guild.*;
import me.xhsun.guildwars2wrapper.model.v2.pvp.*;
import me.xhsun.guildwars2wrapper.model.v2.story.*;
import me.xhsun.guildwars2wrapper.model.v2.util.Inventory;
import me.xhsun.guildwars2wrapper.model.v2.wvw.*;
import me.xhsun.guildwars2wrapper.model.v2.wvw.matches.*;
import retrofit2.*;
	
/**
 * This class contains all the method for accessing data asynchronously or
 * synchronously depending on the requestType set.
 *
 * @author Levvy
 * @since 2017-11-02
 */

final class Gw2Request {
	private RequestType requestType = RequestType.SYNC;
	private GuildWars2 gw2;
	private Consumer<Throwable> failedCallback = (t) -> {
		t.printStackTrace();
	};

	Gw2Request(GuildWars2 gw2) {
		this.gw2 = gw2;
	}

	RequestType getRequestType() {
		return requestType;
	}

	void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	void setFailedAction(Consumer<Throwable> failedCallback) {
		this.failedCallback = failedCallback;
	}

	private <T> Callback<T> createCallback(Consumer<T> callback) {
		return new Callback<T>() {
			
			@Override
			public void onResponse(Call<T> call, Response<T> response) {
				try {
					if (response.isSuccessful()) {
						callback.accept(response.body());
					}
					if (!response.isSuccessful()) {
						Request.throwError(response.code(), response.errorBody());
					}
				}catch(Throwable t) {
					fail(t);
				}
			}
			
			@Override
			public void onFailure(Call<T> call, Throwable t) {
				fail(t);
			}
		};
	}

	private <T> void execute(Consumer<T> actionToBePerformedOnApi, RequestAction<Callback<T>> async,
			RequestAction<Callback<T>> sync) {
		try {
			Callback<T> callb = createCallback(actionToBePerformedOnApi);
			switch (requestType) {
			case ASYNC:
				async.accept(callb);
				break;
			case SYNC:
				sync.accept(callb);
				break;
			default:
				break;
			}
		} catch (Throwable t) {
			fail(t);
		}
	}

	private void fail(Throwable t) {
		failedCallback.accept(t);
	}

	// API:1
	// Event Detail

	/**
	 * For more info on event detail API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is null
	 * @see EventDetail event detail
	 */
	public void getAllEventDetailedInfo(Consumer<EventDetail> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllEventDetailedInfo(c);
		}, c -> {
			EventDetail ed = gw2.getSynchronous().getAllEventDetailedInfo();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on event detail API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:1/event_details">here</a><br/>
	 *
	 * @param id
	 *            event id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid id
	 * @throws NullPointerException
	 *             if given {@link Consumer} is null
	 * @see EventDetail event detail
	 */
	public void getEventDetailedInfo(String id, Consumer<EventDetail> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getEventDetailedInfo(id, c);
		}, c -> {
			EventDetail ed = gw2.getSynchronous().getEventDetailedInfo(id);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on map names API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:1/map_names">here</a><br/>
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is null
	 * @see SimpleName map name
	 */
	public void getAllMapNames(Consumer<List<SimpleName>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllMapNames(c);
		}, c -> {
			List<SimpleName> ed = gw2.getSynchronous().getAllMapNames();
			consumer.accept(ed);
		});
	}

	// World Names

	/**
	 * For more info on world names API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:1/world_names">here</a><br/>
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is null
	 * @see SimpleName world name
	 */
	public void getAllWorldNames(Consumer<List<SimpleName>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWorldNames(c);
		}, c -> {
			List<SimpleName> ed = gw2.getSynchronous().getAllWorldNames();
			consumer.accept(ed);
		});
	}

	// WvW Matches

	/**
	 * For more info on v1 wvw matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:1/wvw/matches">here</a><br/>
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is null
	 * @see AllWvWMatchOverview wvw matches
	 */
	public void getAllWvWMatchOverview(Consumer<AllWvWMatchOverview> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWvWMatchOverview(c);
		}, c -> {
			AllWvWMatchOverview ed = gw2.getSynchronous().getAllWvWMatchOverview();
			consumer.accept(ed);
		});
	}

	// WvW Objective Names

	/**
	 * For more info on WvW objective names API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:1/wvw/objective_names">here</a><br/>
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is null
	 * @see SimpleName objective name
	 */
	public void getAllWvWObjectiveNames(Consumer<List<SimpleName>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWvWObjectiveNames(c);
		}, c -> {
			List<SimpleName> ed = gw2.getSynchronous().getAllWvWObjectiveNames();
			consumer.accept(ed);
		});
	}

	// API:2
	// Token info

	/**
	 * For more info on TokenInfo API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is null
	 * @see TokenInfo API info
	 */
	public void getAPIInfo(String API, Consumer<TokenInfo> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAPIInfo(API, c);
		}, c -> {
			TokenInfo ed = gw2.getSynchronous().getAPIInfo(API);
			consumer.accept(ed);
		});
	}

	// Accounts
	/**
	 * For more info on Account API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Account Account info
	 */
	public void getAccountInfo(String API, Consumer<Account> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAccountInfo(API, c);
		}, c -> {
			Account ed = gw2.getSynchronous().getAccountInfo(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Account API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see AchievementProgression Account achievement info
	 */
	public void getAchievementProgression(String API, Consumer<List<AchievementProgression>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAchievementProgression(API, c);
		}, c -> {
			List<AchievementProgression> ed = gw2.getSynchronous().getAchievementProgression(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Bank API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Inventory Bank info
	 */
	public void getBank(String API, Consumer<List<Inventory>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getBank(API, c);
		}, c -> {
			List<Inventory> ed = gw2.getSynchronous().getBank(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Dungeon progression API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/dungeons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getDailyDungeonProgression(String API, Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getDailyDungeonProgression(API, c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getDailyDungeonProgression(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Account dyes API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/dyes">here</a><br/>
	 * Get list of unlocked dyes ids linked to given API key
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Color color info
	 */
	public void getUnlockedDyes(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedDyes(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedDyes(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Account finishers API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/finishers">here</a><br/>
	 * Get list of unlocked finishers linked to given API key
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see UnlockedFinisher unlocked finisher info
	 */
	public void getUnlockedFinishers(String API, Consumer<List<UnlockedFinisher>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedFinishers(API, c);
		}, c -> {
			List<UnlockedFinisher> ed = gw2.getSynchronous().getUnlockedFinishers(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Account gliders API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/gliders">here</a><br/>
	 * Get list of unlocked glider id(s) linked to given API key
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getUnlockedGliders(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedGliders(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedGliders(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Account cats API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/home/cats">here</a><br/>
	 * Get list of unlocked cats linked to given API key
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Cat cat info
	 */
	public void getUnlockedCats(String API, Consumer<List<Cat>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedCats(API, c);
		}, c -> {
			List<Cat> ed = gw2.getSynchronous().getUnlockedCats(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Account nodes API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/home/nodes">here</a><br/>
	 * Get list of unlocked glider id(s) linked to given API key
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getUnlockedHomeNodes(String API, Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedHomeNodes(API, c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getUnlockedHomeNodes(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Shared Inventory API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/inventory">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Inventory shared inventory info
	 */
	public void getSharedInventory(String API, Consumer<List<Inventory>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getSharedInventory(API, c);
		}, c -> {
			List<Inventory> ed = gw2.getSynchronous().getSharedInventory(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on account mail carrier API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/mailcarriers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getUnlockedMailCarriers(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedMailCarriers(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedMailCarriers(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on account masteries API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/masteries">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see UnlockedMastery unlocked mastery info
	 */
	public void getUnlockedMasteries(String API, Consumer<List<UnlockedMastery>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedMasteries(API, c);
		}, c -> {
			List<UnlockedMastery> ed = gw2.getSynchronous().getUnlockedMasteries(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on MaterialCategory Storage API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/materials">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see MaterialStorage material storage info
	 */
	public void getMaterialStorage(String API, Consumer<List<MaterialStorage>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getMaterialStorage(API, c);
		}, c -> {
			List<MaterialStorage> ed = gw2.getSynchronous().getMaterialStorage(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on account minis API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/minis">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Mini mini info
	 */
	public void getUnlockedMinis(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedMinis(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedMinis(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on account outfits API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/outfits">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getUnlockedOutfits(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedOutfits(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedOutfits(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on account pvp heroes API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/account/pvp/heroes">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getUnlockedPvpHeroes(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedPvpHeroes(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedPvpHeroes(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on account raid API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getWeeklyRaidProgression(String API, Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWeeklyRaidProgression(API, c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getWeeklyRaidProgression(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on account recipes API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Recipe recipe info
	 */
	public void getUnlockedRecipes(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedRecipes(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedRecipes(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Account/Skins API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/skins">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Skin skin info
	 */
	public void getUnlockedSkins(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedSkins(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedSkins(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Account titles API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/titles">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getUnlockedTitles(String API, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getUnlockedTitles(API, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getUnlockedTitles(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Wallet API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Wallet wallet info
	 */
	public void getWallet(String API, Consumer<List<Wallet>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWallet(API, c);
		}, c -> {
			List<Wallet> ed = gw2.getSynchronous().getWallet(API);
			consumer.accept(ed);
		});
	}

	// Achievements
	/**
	 * For more info on achievement API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Achievement achievement info
	 */
	public void getAllAchievementID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllAchievementID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllAchievementID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on achievement API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of achievement id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Achievement achievement info
	 */
	public void getAchievementInfo(int[] ids, Consumer<List<Achievement>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAchievementInfo(ids, c);
		}, c -> {
			List<Achievement> ed = gw2.getSynchronous().getAchievementInfo(ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on achievement categories API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/achievements/categories">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see AchievementCategory achievement category info
	 */
	public void getAllAchievementCategoryIDs(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllAchievementCategoryIDs(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllAchievementCategoryIDs();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on achievements categories API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/achievements/categories">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of achievement category id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see AchievementCategory achievement category info
	 */
	public void getAchievementCategoryInfo(int[] ids, Consumer<List<AchievementCategory>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAchievementCategoryInfo(ids, c);
		}, c -> {
			List<AchievementCategory> ed = gw2.getSynchronous().getAchievementCategoryInfo(ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on achievements daily API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/achievements/daily">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see DailyAchievement daily achievement info
	 */
	public void getCurrentDailyAchievements(Consumer<DailyAchievement> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCurrentDailyAchievements(c);
		}, c -> {
			DailyAchievement ed = gw2.getSynchronous().getCurrentDailyAchievements();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on next achievements daily API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/achievements/daily/tomorrow">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see DailyAchievement daily achievement info
	 */
	public void getNextDailyAchievements(Consumer<DailyAchievement> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getNextDailyAchievements(c);
		}, c -> {
			DailyAchievement ed = gw2.getSynchronous().getNextDailyAchievements();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on achievements groups API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/achievements/groups">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see AchievementGroup achievement group info
	 */
	public void getAllAchievementGroupID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllAchievementGroupID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllAchievementGroupID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on achievements groups API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/achievements/groups">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of achievement group id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see AchievementGroup achievement group info
	 */
	public void getAchievementGroupInfo(String[] ids, Consumer<List<AchievementGroup>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAchievementGroupInfo(ids, c);
		}, c -> {
			List<AchievementGroup> ed = gw2.getSynchronous().getAchievementGroupInfo(ids);
			consumer.accept(ed);
		});
	}

	// Back Story
	/**
	 * For more info on back story answer API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/backstory/answers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see BackStoryAnswer back story answer info
	 */
	public void getAllBackStoryAnswerID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllBackStoryAnswerID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllBackStoryAnswerID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on back story answer API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/backstory/answers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of back story answer id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see BackStoryAnswer back story answer info
	 */
	public void getBackStoryAnswerInfo(String[] ids, Consumer<List<BackStoryAnswer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getBackStoryAnswerInfo(ids, c);
		}, c -> {
			List<BackStoryAnswer> ed = gw2.getSynchronous().getBackStoryAnswerInfo(ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on back story questions API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/backstory/questions">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see BackStoryQuestion back story question info
	 */
	public void getAllBackStoryQuestionID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllBackStoryQuestionID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllBackStoryQuestionID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on back story questions API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/backstory/questions">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of back story question id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see BackStoryQuestion back story question info
	 */
	public void getBackStoryQuestionInfo(int[] ids, Consumer<List<BackStoryQuestion>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getBackStoryQuestionInfo(ids, c);
		}, c -> {
			List<BackStoryQuestion> ed = gw2.getSynchronous().getBackStoryQuestionInfo(ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on build API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/build">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GameBuild game build info
	 */
	public void getCurrentGameBuild(Consumer<GameBuild> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCurrentGameBuild(c);
		}, c -> {
			GameBuild ed = gw2.getSynchronous().getCurrentGameBuild();
			consumer.accept(ed);
		});
	}

	// Cats

	/**
	 * For more info on cats API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Cat cat info
	 */
	public void getAllCatID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllCatID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllCatID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on cats API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/cats">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of cat id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Cat cat info
	 */
	public void getCatInfo(int[] ids, Consumer<List<Cat>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCatInfo(ids, c);
		}, c -> {
			List<Cat> ed = gw2.getSynchronous().getCatInfo(ids);
			consumer.accept(ed);
		});
	}

	// Characters
	/**
	 * For more info on Character API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getAllCharacterName(String API, Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllCharacterName(API, c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllCharacterName(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on character overview API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Get character information for the given character name that is linked to
	 * given API key
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            name of character
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Character character info
	 */
	public void getCharacter(String API, String name, Consumer<Character> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacter(API, name, c);
		}, c -> {
			Character ed = gw2.getSynchronous().getCharacter(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on character back story API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Backstory">here</a><br/>
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            name of character
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterBackStory back store answer info
	 */
	public void getCharacterBackStory(String API, String name, Consumer<CharacterBackStory> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterBackStory(API, name, c);
		}, c -> {
			CharacterBackStory ed = gw2.getSynchronous().getCharacterBackStory(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Character Core API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
	 * Get basic character information for the given character name that is linked
	 * to given API key
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            name of character
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterCore basic character info
	 */
	public void getCharacterInformation(String API, String name, Consumer<CharacterCore> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterInformation(API, name, c);
		}, c -> {
			CharacterCore ed = gw2.getSynchronous().getCharacterInformation(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on character crafting API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Crafting">here</a><br/>
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            name of character
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterCraftingLevel character crafting info
	 */
	public void getCharacterCrafting(String API, String name, Consumer<CharacterCraftingLevel> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterCrafting(API, name, c);
		}, c -> {
			CharacterCraftingLevel ed = gw2.getSynchronous().getCharacterCrafting(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on character equipment API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Equipment">here</a><br/>
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            name of character
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterEquipment equipment info
	 */
	public void getCharacterEquipment(String API, String name, Consumer<CharacterEquipment> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterEquipment(API, name, c);
		}, c -> {
			CharacterEquipment ed = gw2.getSynchronous().getCharacterEquipment(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on character hero points API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Heropoints">here</a><br/>
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            name of character
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getCharacterHeroPoints(String API, String name, Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterHeroPoints(API, name, c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getCharacterHeroPoints(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Character Inventory API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            character name
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterInventory character inventory info
	 */
	public void getCharacterInventory(String API, String name, Consumer<CharacterInventory> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterInventory(API, name, c);
		}, c -> {
			CharacterInventory ed = gw2.getSynchronous().getCharacterInventory(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Character Recipes API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            character name
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Recipe recipe info
	 */
	public void getCharacterUnlockedRecipes(String API, String name, Consumer<CharacterRecipes> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterUnlockedRecipes(API, name, c);
		}, c -> {
			CharacterRecipes ed = gw2.getSynchronous().getCharacterUnlockedRecipes(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Character SAB API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Super_Adventure_Box_.28sab.29">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            character name
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterSAB character SAB info
	 */
	public void getCharacterSAB(String API, String name, Consumer<CharacterSAB> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterSAB(API, name, c);
		}, c -> {
			CharacterSAB ed = gw2.getSynchronous().getCharacterSAB(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Character Skills API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Skills">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            character name
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterSkills character skills info
	 */
	public void getCharacterSkills(String API, String name, Consumer<CharacterSkills> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterSkills(API, name, c);
		}, c -> {
			CharacterSkills ed = gw2.getSynchronous().getCharacterSkills(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Character Specialization API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Specialization">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            character name
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterSpecialization character specialization info
	 */
	public void getCharacterSpecialization(String API, String name, Consumer<CharacterSpecialization> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterSpecialization(API, name, c);
		}, c -> {
			CharacterSpecialization ed = gw2.getSynchronous().getCharacterSpecialization(API, name);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Character Training API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/characters#Training">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param name
	 *            character name
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key | empty character name
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see CharacterTraining character training info
	 */
	public void getCharacterTraining(String API, String name, Consumer<CharacterTraining> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCharacterTraining(API, name, c);
		}, c -> {
			CharacterTraining ed = gw2.getSynchronous().getCharacterTraining(API, name);
			consumer.accept(ed);
		});
	}

	// Colors
	/**
	 * For more info on Color API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Color color info
	 */
	public void getAllColorID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllColorID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllColorID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Color API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of color id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Color color info
	 */
	public void getColorInfo(int[] ids, Consumer<List<Color>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getColorInfo(ids, c);
		}, c -> {
			List<Color> ed = gw2.getSynchronous().getColorInfo(ids);
			consumer.accept(ed);
		});
	}

	// TP

	/**
	 * For more info on delivery API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/commerce/delivery">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Delivery devlivery info
	 */
	public void getTPDeliveryInfo(String API, Consumer<Delivery> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getTPDeliveryInfo(API, c);
		}, c -> {
			Delivery ed = gw2.getSynchronous().getTPDeliveryInfo(API);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on exchange API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/commerce/exchange">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getAllExchangeCurrency(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllExchangeCurrency(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllExchangeCurrency();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on exchange coins API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/commerce/exchange/coins">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param currency
	 *            exchange currency type
	 * @param quantity
	 *            The amount to exchange
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid value
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Exchange Exchange info
	 */
	public void getExchangeInfo(Exchange.Type currency, long quantity, Consumer<Exchange> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getExchangeInfo(currency, quantity, c);
		}, c -> {
			Exchange ed = gw2.getSynchronous().getExchangeInfo(currency, quantity);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Listing Price API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getAllTPListingID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllTPListingID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllTPListingID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Listing Price API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of item id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Listing listing item price info
	 */
	public void getTPListingInfo(int[] ids, Consumer<List<Listing>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getTPListingInfo(ids, c);
		}, c -> {
			List<Listing> ed = gw2.getSynchronous().getTPListingInfo(ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Listing Price API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getAllPriceID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllPriceID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllPriceID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Listing Price API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/commerce/prices">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of item id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Prices listing item price info
	 */
	public void getPriceInfo(int[] ids, Consumer<List<Prices>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPriceInfo(ids, c);
		}, c -> {
			List<Prices> ed = gw2.getSynchronous().getPriceInfo(ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on transactions API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/commerce/transactions">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API
	 *            API key
	 * @param time
	 *            current | History
	 * @param type
	 *            buy | sell
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Transaction transaction info
	 */
	public void getTPTransaction(String API, Transaction.Time time, Transaction.Type type,
			Consumer<List<Transaction>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getTPTransaction(API, time, type, c);
		}, c -> {
			List<Transaction> ed = gw2.getSynchronous().getTPTransaction(API, time, type);
			consumer.accept(ed);
		});
	}

	// Continents
	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Continent continents info
	 */
	public void getAllContinentID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllContinentID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllContinentID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of continents id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Continent continents info
	 */
	public void getContinentInfo(int[] ids, Consumer<List<Continent>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getContinentInfo(ids, c);
		}, c -> {
			List<Continent> ed = gw2.getSynchronous().getContinentInfo(ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentFloor continents floor info
	 */
	public void getAllContinentFloorID(int continentID, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllContinentFloorID(continentID, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllContinentFloorID(continentID);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param ids
	 *            list of floor id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentFloor continents floor info
	 */
	public void getContinentFloorInfo(int continentID, int[] ids, Consumer<List<ContinentFloor>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getContinentFloorInfo(continentID, ids, c);
		}, c -> {
			List<ContinentFloor> ed = gw2.getSynchronous().getContinentFloorInfo(continentID, ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentRegion continents region info
	 */
	public void getAllContinentRegionID(int continentID, int floorID, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllContinentRegionID(continentID, floorID, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllContinentRegionID(continentID, floorID);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param ids
	 *            list of region id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentRegion continents region info
	 */
	public void getContinentRegionInfo(int continentID, int floorID, int[] ids,
			Consumer<List<ContinentRegion>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getContinentRegionInfo(continentID, floorID, ids, c);
		}, c -> {
			List<ContinentRegion> ed = gw2.getSynchronous().getContinentRegionInfo(continentID, floorID, ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param regionID
	 *            {@link ContinentRegion#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentMap continents map info
	 */
	public void getAllContinentMapID(int continentID, int floorID, int regionID, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllContinentMapID(continentID, floorID, regionID, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllContinentMapID(continentID, floorID, regionID);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param regionID
	 *            {@link ContinentRegion#id}
	 * @param ids
	 *            list of region map id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentMap continents map info
	 */
	public void getContinentMapInfo(int continentID, int floorID, int regionID, int[] ids,
			Consumer<List<ContinentMap>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getContinentMapInfo(continentID, floorID, regionID, ids, c);
		}, c -> {
			List<ContinentMap> ed = gw2.getSynchronous().getContinentMapInfo(continentID, floorID, regionID, ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param regionID
	 *            {@link ContinentRegion#id}
	 * @param mapID
	 *            {@link ContinentMap#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentMap.Sector continents map sector info
	 */
	public void getAllContinentSectorID(int continentID, int floorID, int regionID, int mapID,
			Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllContinentSectorID(continentID, floorID, regionID, mapID, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllContinentSectorID(continentID, floorID, regionID, mapID);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param regionID
	 *            {@link ContinentRegion#id}
	 * @param mapID
	 *            {@link ContinentMap#id}
	 * @param ids
	 *            list of region map sector id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentMap.Sector continents map sector info
	 */
	public void getContinentSectorInfo(int continentID, int floorID, int regionID, int mapID, int[] ids,
			Consumer<List<ContinentMap.Sector>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getContinentSectorInfo(continentID, floorID, regionID, mapID, ids, c);
		}, c -> {
			List<Sector> ed = gw2.getSynchronous().getContinentSectorInfo(continentID, floorID, regionID, mapID, ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param regionID
	 *            {@link ContinentRegion#id}
	 * @param mapID
	 *            {@link ContinentMap#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentMap.PoI continents map PoI info
	 */
	public void getAllContinentPOIID(int continentID, int floorID, int regionID, int mapID,
			Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllContinentPOIID(continentID, floorID, regionID, mapID, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllContinentPOIID(continentID, floorID, regionID, mapID);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param regionID
	 *            {@link ContinentRegion#id}
	 * @param mapID
	 *            {@link ContinentMap#id}
	 * @param ids
	 *            list of region map PoI id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentMap.PoI continents map PoI info
	 */
	public void getContinentPOIInfo(int continentID, int floorID, int regionID, int mapID, int[] ids,
			Consumer<List<ContinentMap.PoI>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getContinentPOIInfo(continentID, floorID, regionID, mapID, ids, c);
		}, c -> {
			List<PoI> ed = gw2.getSynchronous().getContinentPOIInfo(continentID, floorID, regionID, mapID, ids);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param regionID
	 *            {@link ContinentRegion#id}
	 * @param mapID
	 *            {@link ContinentMap#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentMap.Task continents map task info
	 */
	public void getAllContinentTaskID(int continentID, int floorID, int regionID, int mapID,
			Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllContinentTaskID(continentID, floorID, regionID, mapID, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllContinentTaskID(continentID, floorID, regionID, mapID);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on continents API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/continents">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param continentID
	 *            {@link Continent#id}
	 * @param floorID
	 *            {@link ContinentFloor#id}
	 * @param regionID
	 *            {@link ContinentRegion#id}
	 * @param mapID
	 *            {@link ContinentMap#id}
	 * @param ids
	 *            list of region map task id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ContinentMap.Task continents map task info
	 */
	public void getContinentTaskInfo(int continentID, int floorID, int regionID, int mapID, int[] ids,
			Consumer<List<ContinentMap.Task>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getContinentTaskInfo(continentID, floorID, regionID, mapID, ids, c);
		}, c -> {
			List<Task> ed = gw2.getSynchronous().getContinentTaskInfo(continentID, floorID, regionID, mapID, ids);
			consumer.accept(ed);
		});
	}

	// Currencies
	/**
	 * For more info on Currency API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Currency currency info
	 */
	public void getAllCurrencyID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllCurrencyID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllCurrencyID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Currency API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/currencies">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of currency id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Currency currency info
	 */
	public void getCurrencyInfo(int[] ids, Consumer<List<Currency>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getCurrencyInfo(ids, c);
		}, c -> {
			List<Currency> ed = gw2.getSynchronous().getCurrencyInfo(ids);
			consumer.accept(ed);
		});
	}

	// Dungeons

	/**
	 * For more info on Dungeons API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Dungeon dungeon info
	 */
	public void getAllDungeonName(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllDungeonName(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllDungeonName();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Dungeons API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/dungeons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of dungeon id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Dungeon dungeon info
	 */
	public void getDungeonInfo(String[] ids, Consumer<List<Dungeon>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getDungeonInfo(ids, c);
		}, c -> {
			List<Dungeon> ed = gw2.getSynchronous().getDungeonInfo(ids);
			consumer.accept(ed);
		});
	}

	// Emblem

	/**
	 * For more info on emblem API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Emblem Emblem info
	 */
	public void getAllEmblemType(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllEmblemType(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllEmblemType();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on emblem API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param type
	 *            foregrounds/backgrounds
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Emblem Emblem info
	 */
	public void getAllEmblemIDs(Emblem.Type type, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllEmblemIDs(type, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllEmblemIDs(type);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on emblem API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param type
	 *            foregrounds/backgrounds
	 * @param ids
	 *            list of emblem id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list | exceeds ID list limit (ie, ids.length>200)
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Emblem Emblem info
	 */
	public void getAllEmblemInfo(Emblem.Type type, int[] ids, Consumer<List<Emblem>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllEmblemInfo(type, ids, c);
		}, c -> {
			List<Emblem> ed = gw2.getSynchronous().getAllEmblemInfo(type, ids);
			consumer.accept(ed);
		});
	}

	// Files

	/**
	 * For more info on files API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/files">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Asset file info
	 */
	public void getAllFileID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllFileID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllFileID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on files API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/files">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of file id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Asset file info
	 */
	public void getAllFileInfo(String[] ids, Consumer<List<Asset>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllFileInfo(ids, c);
		}, c -> {
			List<Asset> ed = gw2.getSynchronous().getAllFileInfo(ids);
			consumer.accept(ed);
		});
	}

	// Finishers

	/**
	 * For more info on Finishers API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Finisher finisher info
	 */
	public void getAllFinisherID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllFinisherID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllFinisherID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Finishers API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of finisher id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Finisher finisher info
	 */
	public void getFinisherInfo(int[] ids, Consumer<List<Finisher>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getFinisherInfo(ids, c);
		}, c -> {
			List<Finisher> ed = gw2.getSynchronous().getFinisherInfo(ids);
			consumer.accept(ed);
		});
	}

	// Gliders

	/**
	 * For more info on gliders API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Glider glider info
	 */
	public void getAllGliderID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllGliderID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllGliderID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on gliders API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/gliders">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of glider id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Glider glider info
	 */
	public void getGliderInfo(int[] ids, Consumer<List<Glider>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGliderInfo(ids, c);
		}, c -> {
			List<Glider> ed = gw2.getSynchronous().getGliderInfo(ids);
			consumer.accept(ed);
		});
	}

	// Guild

	/**
	 * For more info on guild upgrades API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param id
	 *            guild id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Guild guild info
	 */
	public void getGeneralGuildInfo(String id, Consumer<Guild> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGeneralGuildInfo(id, c);
		}, c -> {
			Guild ed = gw2.getSynchronous().getGeneralGuildInfo(id);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on guild upgrades API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 * Note: if the given account is not a member, sometime endpoint will return
	 * general guild info instead of detailed info
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Guild guild info
	 */
	public void getDetailedGuildInfo(String id, String api, Consumer<Guild> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getDetailedGuildInfo(id, api, c);
		}, c -> {
			Guild ed = gw2.getSynchronous().getDetailedGuildInfo(id, api);
			consumer.accept(ed);
		});
	}

	// Guild Log

	/**
	 * For more info on guild log API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild leader's Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildLog guild log info
	 */
	public void getGuildLogInfo(String id, String api, Consumer<List<GuildLog>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildLogInfo(id, api, c);
		}, c -> {
			List<GuildLog> ed = gw2.getSynchronous().getGuildLogInfo(id, api);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on guild log API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild leader's Guild Wars 2 API key
	 * @param since
	 *            log id used to filter log entries
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildLog guild log info
	 */
	public void getFilteredGuildLogInfo(String id, String api, int since, Consumer<List<GuildLog>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getFilteredGuildLogInfo(id, api, since, c);
		}, c -> {
			List<GuildLog> ed = gw2.getSynchronous().getFilteredGuildLogInfo(id, api, since);
			consumer.accept(ed);
		});
	}

	// Guild Members

	/**
	 * For more info on guild member API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/guild/:id/members">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild leader's Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildMember guild member info
	 */
	public void getGuildMemberInfo(String id, String api, Consumer<List<GuildMember>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildMembersInfo(id, api, c);
		}, c -> {
			List<GuildMember> ed = gw2.getSynchronous().getGuildMembersInfo(id, api);
			consumer.accept(ed);
		});
	}

	// Guild Ranks

	/**
	 * For more info on guild rank API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild leader's Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildRank guild rank info
	 */
	public void getGuildRankInfo(String id, String api, Consumer<List<GuildRank>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildRankInfo(id, api, c);
		}, c -> {
			List<GuildRank> ed = gw2.getSynchronous().getGuildRankInfo(id, api);
			consumer.accept(ed);
		});
	}

	// Guild Stash

	/**
	 * For more info on guild stash API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/guild/:id/stash">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild leader's Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildStash guild stash info
	 */
	public void getGuildStashInfo(String id, String api, Consumer<List<GuildStash>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildStashInfo(id, api, c);
		}, c -> {
			List<GuildStash> ed = gw2.getSynchronous().getGuildStashInfo(id, api);
			consumer.accept(ed);
		});
	}

	// Guild Teams

	/**
	 * For more info on guild teams API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/guild/:id/teams">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild leader's Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildTeam guild team info
	 */
	public void getGuildTeamsInfo(String id, String api, Consumer<List<GuildTeam>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildTeamsInfo(id, api, c);
		}, c -> {
			List<GuildTeam> ed = gw2.getSynchronous().getGuildTeamsInfo(id, api);
			consumer.accept(ed);
		});
	}

	// Guild Treasury

	/**
	 * For more info on guild treasury API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/guild/:id/treasury">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild leader's Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildTreasury guild treasury info
	 */
	public void getGuildTreasuryInfo(String id, String api, Consumer<List<GuildTreasury>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildTreasuryInfo(id, api, c);
		}, c -> {
			List<GuildTreasury> ed = gw2.getSynchronous().getGuildTreasuryInfo(id, api);
			consumer.accept(ed);
		});
	}

	// Guild Unlocked Upgrades

	/**
	 * For more info on guild unlocked upgrades API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/guild/:id/upgrades">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom
	 * interactions<br/>
	 *
	 * @param id
	 *            guild id
	 * @param api
	 *            Guild leader's Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getGuildUnlockedUpgradesID(String id, String api, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildUnlockedUpgradesID(id, api, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getGuildUnlockedUpgradesID(id, api);
			consumer.accept(ed);
		});
	}

	// Guild Permissions

	/**
	 * For more info on guild permissions API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/guild/permissions">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildPermission guild permission info
	 */
	public void getAllGuildPermissionID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllGuildPermissionID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllGuildPermissionID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on guild permissions API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/guild/permissions">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of guild permission id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildPermission guild permission info
	 */
	public void getGuildPermissionInfo(String[] ids, Consumer<List<GuildPermission>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildPermissionInfo(ids, c);
		}, c -> {
			List<GuildPermission> ed = gw2.getSynchronous().getGuildPermissionInfo(ids);
			consumer.accept(ed);
		});
	}

	// Guild Search

	/**
	 * For more info on guild Search API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/guild/search">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param name
	 *            guild name
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildPermission guild permission info
	 */
	public void searchGuildID(String name, Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().searchGuildID(name, c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().searchGuildID(name);
			consumer.accept(ed);
		});
	}

	// Guild Upgrades

	/**
	 * For more info on guild upgrades API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildUpgrade guild upgrade info
	 */
	public void getGuildUpgradeID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildUpgradeID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllGuildUpgradeID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on guild upgrades API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of guild upgrade id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see GuildUpgrade guild upgrade info
	 */
	public void getGuildUpgradeInfo(int[] ids, Consumer<List<GuildUpgrade>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getGuildUpgradeInfo(ids, c);
		}, c -> {
			List<GuildUpgrade> ed = gw2.getSynchronous().getGuildUpgradeInfo(ids);
			consumer.accept(ed);
		});
	}

	// Items

	/**
	 * For more info on Item API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Item item info
	 */
	public void getAllItemID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllItemID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllItemID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Item API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/items">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of item id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Item item info
	 */
	public void getItemInfo(int[] ids, Consumer<List<Item>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getItemInfo(ids, c);
		}, c -> {
			List<Item> ed = gw2.getSynchronous().getItemInfo(ids);
			consumer.accept(ed);
		});
	}

	// Item Stats

	/**
	 * For more info on Itemstat API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ItemStats itemstat info
	 */
	public void getAllItemStatID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllItemStatID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllItemStatID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Itemstat API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of itemstat id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see ItemStats itemstat info
	 */
	public void getItemStatInfo(int[] ids, Consumer<List<ItemStats>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getItemStatInfo(ids, c);
		}, c -> {
			List<ItemStats> ed = gw2.getSynchronous().getItemStatInfo(ids);
			consumer.accept(ed);
		});
	}

	// Legends

	/**
	 * For more info on legends API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/legends">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Legend legend info
	 */
	public void getAllLegendID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllLegendID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllLegendID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on legends API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/legends">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of legend id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Legend legend info
	 */
	public void getLegendInfo(String[] ids, Consumer<List<Legend>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getLegendInfo(ids, c);
		}, c -> {
			List<Legend> ed = gw2.getSynchronous().getLegendInfo(ids);
			consumer.accept(ed);
		});
	}

	// Mail Carriers

	/**
	 * For more info on mail carriers API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see MailCarrier mail carrier info
	 */
	public void getAllMailCarrierID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllMailCarrierID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllMailCarrierID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on mail carriers API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of mail carrier id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see MailCarrier mail carrier info
	 */
	public void getMailCarrierInfo(int[] ids, Consumer<List<MailCarrier>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getMailCarrierInfo(ids, c);
		}, c -> {
			List<MailCarrier> ed = gw2.getSynchronous().getMailCarrierInfo(ids);
			consumer.accept(ed);
		});
	}

	// Maps

	/**
	 * For more info on mail carriers API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see MapOverview map info
	 */
	public void getAllMapID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllMapID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllMapID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on map API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/mailcarriers">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of map id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see MapOverview map info
	 */
	public void getMapInfo(int[] ids, Consumer<List<MapOverview>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getMapInfo(ids, c);
		}, c -> {
			List<MapOverview> ed = gw2.getSynchronous().getMapInfo(ids);
			consumer.accept(ed);
		});
	}

	// Masteries

	/**
	 * or more info on masteries API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Mastery mastery info
	 */
	public void getAllMasteryID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllMasteryID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllMasteryID();
			consumer.accept(ed);
		});
	}

	/**
	 * or more info on masteries API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of mastery id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Mastery mastery info
	 */
	public void getMasteryInfo(int[] ids, Consumer<List<Mastery>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getMasteryInfo(ids, c);
		}, c -> {
			List<Mastery> ed = gw2.getSynchronous().getMasteryInfo(ids);
			consumer.accept(ed);
		});
	}

	// Material Categories

	/**
	 * For more info on Material MaterialCategory API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see MaterialCategory material category info
	 */
	public void getAllMaterialCategoryID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllMaterialCategoryID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllMaterialCategoryID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Material MaterialCategory API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of category id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see MaterialCategory material category info
	 */
	public void getMaterialCategoryInfo(int[] ids, Consumer<List<MaterialCategory>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getMaterialCategoryInfo(ids, c);
		}, c -> {
			List<MaterialCategory> ed = gw2.getSynchronous().getMaterialCategoryInfo(ids);
			consumer.accept(ed);
		});
	}

	// Minis

	/**
	 * For more info on Mini API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Mini mini info
	 */
	public void getAllMiniID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllMiniID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllMiniID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Mini API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/minis">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of mini id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Mini mini info
	 */
	public void getMiniInfo(int[] ids, Consumer<List<Mini>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getMiniInfo(ids, c);
		}, c -> {
			List<Mini> ed = gw2.getSynchronous().getMiniInfo(ids);
			consumer.accept(ed);
		});
	}

	// Nodes

	/**
	 * For more info on nodes API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/nodes">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getAllHomeInstanceNodeID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllHomeInstanceNodeID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllHomeInstanceNodeID();
			consumer.accept(ed);
		});
	}

	// Outfits

	/**
	 * For more info on Outfits API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Outfit outfit info
	 */
	public void getAllOutfitID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllOutfitID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllOutfitID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Outfits API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/outfits">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of outfit id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Outfit outfit info
	 */
	public void getOutfitInfo(int[] ids, Consumer<List<Outfit>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getOutfitInfo(ids, c);
		}, c -> {
			List<Outfit> ed = gw2.getSynchronous().getOutfitInfo(ids);
			consumer.accept(ed);
		});
	}

	// Pets

	/**
	 * For more info on pets API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pets">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Pet pet info
	 */
	public void getAllPetID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllPetID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllPetID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on pets API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pets">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of pet id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Pet pet info
	 */
	public void getPetInfo(int[] ids, Consumer<List<Pet>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPetInfo(ids, c);
		}, c -> {
			List<Pet> ed = gw2.getSynchronous().getPetInfo(ids);
			consumer.accept(ed);
		});
	}

	// Professions

	/**
	 * For more info on professions API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Profession profession info
	 */
	public void getAllProfessionID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllProfessionID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllProfessionID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on professions API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/professions">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of profession id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Profession profession info
	 */
	public void getProfessionInfo(String[] ids, Consumer<List<Profession>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getProfessionInfo(ids, c);
		}, c -> {
			List<Profession> ed = gw2.getSynchronous().getProfessionInfo(ids);
			consumer.accept(ed);
		});
	}

	// PvP Amulets

	/**
	 * For more info on pvp amulets API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPAmulet amulet info
	 */
	public void getAllPvPAmuletID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllPvPAmuletID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllPvPAmuletID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on pvp amulets API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of amulet id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPAmulet amulet info
	 */
	public void getPvPAmuletInfo(int[] ids, Consumer<List<PvPAmulet>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPvPAmuletInfo(ids, c);
		}, c -> {
			List<PvPAmulet> ed = gw2.getSynchronous().getPvPAmuletInfo(ids);
			consumer.accept(ed);
		});
	}

	// PvP Games

	/**
	 * For more info on pvp games API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param api
	 *            Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @throws GuildWars2Exception
	 *             invalid API key
	 * @see PvPGame pvp game info
	 */
	public void getAllPvPGameID(String api, Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllPvPGameID(api, c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllPvPGameID(api);
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on pvp games API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param api
	 *            Guild Wars 2 API key
	 * @param ids
	 *            list of pvp game id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPGame pvp game info
	 */
	public void getPvPGameInfo(String api, String[] ids, Consumer<List<PvPGame>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPvPGameInfo(api, ids, c);
		}, c -> {
			List<PvPGame> ed = gw2.getSynchronous().getPvPGameInfo(api, ids);
			consumer.accept(ed);
		});
	}

	// PvP Heroes

	/**
	 * For more info on pvp heroes API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPHero pvp hero info
	 */
	public void getAllPvPHeroID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllPvPHeroID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllPvPHeroID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on pvp heroes API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of pvp hero id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPHero pvp hero info
	 */
	public void getPvPHeroInfo(String[] ids, Consumer<List<PvPHero>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPvPHeroInfo(ids, c);
		}, c -> {
			List<PvPHero> ed = gw2.getSynchronous().getPvPHeroInfo(ids);
			consumer.accept(ed);
		});
	}

	// PvP Ranks

	/**
	 * For more info on pvp ranks API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPRank PvP rank info
	 */
	public void getAllPvPRankID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllPvPRankID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllPvPRankID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on pvp ranks API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of PvP rank id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPRank PvP rank info
	 */
	public void getPvPRankInfo(int[] ids, Consumer<List<PvPRank>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPvPRankInfo(ids, c);
		}, c -> {
			List<PvPRank> ed = gw2.getSynchronous().getPvPRankInfo(ids);
			consumer.accept(ed);
		});
	}

	// PvP Seasons

	/**
	 * For more info on pvp season API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPSeason pvp season info
	 */
	public void getAllPvPSeasonID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllPvPSeasonID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllPvPSeasonID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on pvp season API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of pvp season id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPSeason pvp season info
	 */
	public void getPvPSeasonInfo(String[] ids, Consumer<List<PvPSeason>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPvPSeasonInfo(ids, c);
		}, c -> {
			List<PvPSeason> ed = gw2.getSynchronous().getPvPSeasonInfo(ids);
			consumer.accept(ed);
		});
	}

	// PvP Seasons LeaderBoard

	/**
	 * For more info on pvp season API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param id
	 *            Season id
	 * @param type
	 *            ladder/legendary/guild
	 * @param region
	 *            na/eu
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see PvPLeaderBoard pvp season info
	 */
	public void getPvPSeasonLeaderBoardInfo(String id, String type, World.Region region,
			Consumer<List<PvPLeaderBoard>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPvPSeasonLeaderboardInfo(id, type, region, c);
		}, c -> {
			List<PvPLeaderBoard> ed = gw2.getSynchronous().getPvPSeasonLeaderboardInfo(id, type, region);
			consumer.accept(ed);
		});
	}

	// PvP Standings

	/**
	 * For more info on pvp season API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param api
	 *            Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @throws GuildWars2Exception
	 *             invalid api key
	 * @see PvPLeaderBoard pvp season info
	 */
	public void getPvPStandingInfo(String api, Consumer<List<PvPStanding>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPvPStandingInfo(api, c);
		}, c -> {
			List<PvPStanding> ed = gw2.getSynchronous().getPvPStandingInfo(api);
			consumer.accept(ed);
		});
	}

	// PvP Stats

	/**
	 * For more info on pvp stat API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/stats">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param api
	 *            Guild Wars 2 API key
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @throws GuildWars2Exception
	 *             invalid api key
	 * @see PvPStat pvp stat info
	 */
	public void getPvPStatInfo(String api, Consumer<PvPStat> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getPvPStatInfo(api, c);
		}, c -> {
			PvPStat ed = gw2.getSynchronous().getPvPStatInfo(api);
			consumer.accept(ed);
		});
	}

	// Quaggan

	/**
	 * For more info on quaggans API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getAllQuagganID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllQuagganID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllQuagganID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on quaggans API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/quaggans">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of quaggan id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 */
	public void getQuagganInfo(String[] ids, Consumer<List<Map<String, String>>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getQuagganInfo(ids, c);
		}, c -> {
			List<Map<String, String>> ed = gw2.getSynchronous().getQuagganInfo(ids);
			consumer.accept(ed);
		});
	}

	// Races

	/**
	 * For more info on races API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/races">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Race race info
	 */
	public void getAllRaceID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllRaceID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllRaceID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on races API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/races">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of race id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Race race info
	 */
	public void getRaceInfo(String[] ids, Consumer<List<Race>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getRaceInfo(ids, c);
		}, c -> {
			List<Race> ed = gw2.getSynchronous().getRaceInfo(ids);
			consumer.accept(ed);
		});
	}

	// Raids

	/**
	 * For more info on raids API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/raids">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Raid raid info
	 */
	public void getAllRaidID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllRaidID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllRaidID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on raids API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/raids">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of raid id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Raid raid info
	 */
	public void getRaidInfo(String[] ids, Consumer<List<Raid>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getRaidInfo(ids, c);
		}, c -> {
			List<Raid> ed = gw2.getSynchronous().getRaidInfo(ids);
			consumer.accept(ed);
		});
	}

	// Recipes

	/**
	 * For more info on Recipes API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Recipe recipe info
	 */
	public void getAllRecipeID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllRecipeID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllRecipeID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Recipes API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of recipe id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Recipe recipe info
	 */
	public void getRecipeInfo(int[] ids, Consumer<List<Recipe>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getRecipeInfo(ids, c);
		}, c -> {
			List<Recipe> ed = gw2.getSynchronous().getRecipeInfo(ids);
			consumer.accept(ed);
		});
	}

	// Recipes Search

	/**
	 * For more info on Recipes search API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/recipes/search">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Recipe recipe info
	 */
	public void searchRecipes(boolean isInput, int id, Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().searchRecipes(isInput, id, c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().searchRecipes(isInput, id);
			consumer.accept(ed);
		});
	}

	// Skills

	/**
	 * For more info on Skills API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/skills">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Skill skill info
	 */
	public void getAllSkillID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllSkillID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllSkillID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Skills API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/skills">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of skill id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Skill skill info
	 */
	public void getSkillInfo(int[] ids, Consumer<List<Skill>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getSkillInfo(ids, c);
		}, c -> {
			List<Skill> ed = gw2.getSynchronous().getSkillInfo(ids);
			consumer.accept(ed);
		});
	}

	// Skins

	/**
	 * For more info on Skin API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Skin skin info
	 */
	public void getAllSkinID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllSkinID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllSkinID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on Skin API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/skins">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of skin id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Skin skin info
	 */
	public void getSkinInfo(int[] ids, Consumer<List<Skin>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getSkinInfo(ids, c);
		}, c -> {
			List<Skin> ed = gw2.getSynchronous().getSkinInfo(ids);
			consumer.accept(ed);
		});
	}

	// Specializations

	/**
	 * For more info on specializations API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/specializations">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Specialization specialization info
	 */
	public void getAllSpecializationID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllSpecializationID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllSpecializationID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on specializations API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/specializations">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of specialization id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Specialization specialization info
	 */
	public void getSpecializationInfo(int[] ids, Consumer<List<Specialization>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getSpecializationInfo(ids, c);
		}, c -> {
			List<Specialization> ed = gw2.getSynchronous().getSpecializationInfo(ids);
			consumer.accept(ed);
		});
	}

	// Stories

	/**
	 * For more info on stories API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/stories">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Story story info
	 */
	public void getAllStoryID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllStoryID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllStoryID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on stories API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/stories">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of story id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Story story info
	 */
	public void getStoryInfo(int[] ids, Consumer<List<Story>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getStoryInfo(ids, c);
		}, c -> {
			List<Story> ed = gw2.getSynchronous().getStoryInfo(ids);
			consumer.accept(ed);
		});
	}

	// Stories Seasons

	/**
	 * For more info on stories seasons API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/stories/seasons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see StorySeason story season info
	 */
	public void getAllStorySeasonID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllStorySeasonID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllStorySeasonID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on stories seasons API go <a href=
	 * "https://wiki.guildwars2.com/wiki/API:2/stories/seasons">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of story season id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see StorySeason story season info
	 */
	public void getStorySeasonInfo(String[] ids, Consumer<List<StorySeason>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getStorySeasonInfo(ids, c);
		}, c -> {
			List<StorySeason> ed = gw2.getSynchronous().getStorySeasonInfo(ids);
			consumer.accept(ed);
		});
	}

	// Titles

	/**
	 * For more info on titles API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/titles">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Title title info
	 */
	public void getAllTitleID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllTitleID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllTitleID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on titles API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/titles">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of title id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Title title info
	 */
	public void getTitleInfo(int[] ids, Consumer<List<Title>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getTitleInfo(ids, c);
		}, c -> {
			List<Title> ed = gw2.getSynchronous().getTitleInfo(ids);
			consumer.accept(ed);
		});
	}

	// Traits

/**
 * For more info on traits API go
 * <a href="https://wiki.guildwars2.com/wiki/API:2/traits">here</a><br/>
 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
 *
 * @param consumer
 *            consumer that is going to be used for
 *            {@link Call#enqueue(Consumer)}
 * @throws NullPointerException
 *             if given {@link Consumer} is empty
 * @see Trait trait info
 */
public void getAllTraitID(Consumer<List<Integer>> consumer) {
	execute(consumer, c -> {
		gw2.getAsynchronous().getAllTraitID(c);
	}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllTraitID();
		consumer.accept(ed);
	});
	}

	/**
	 * For more info on traits API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/traits">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of trait id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see Trait trait info
	 */
	public void getTraitInfo(int[] ids, Consumer<List<Trait>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getTraitInfo(ids, c);
		}, c -> {
			List<Trait> ed = gw2.getSynchronous().getTraitInfo(ids);
			consumer.accept(ed);
		});
	}

	// Worlds

	/**
	 * For more info on World API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see World world info
	 */
	public void getAllWorldID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWorldID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllWorldID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on World API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of world id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see World world info
	 */
	public void getWorldInfo(int[] ids, Consumer<List<World>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWorldInfo(ids, c);
		}, c -> {
			List<World> ed = gw2.getSynchronous().getWorldInfo(ids);
			consumer.accept(ed);
		});
	}

	// WvW Abilities

	/**
	 * For more info on WvW abilities API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWAbility WvW abilities info
	 */
	public void getAllWvWAbilityID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWvWAbilityID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllWvWAbilityID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW abilities API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of WvW abilities id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWAbility WvW abilities info
	 */
	public void getWvWAbilityInfo(int[] ids, Consumer<List<WvWAbility>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWAbilityInfo(ids, c);
		}, c -> {
			List<WvWAbility> ed = gw2.getSynchronous().getWvWAbilityInfo(ids);
			consumer.accept(ed);
		});
	}

	// WvW Matches

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWAbility WvW match info
	 */
	public void getAllWvWMatchID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWvWMatchID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllWvWMatchID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param worldID
	 *            {@link World#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWMatchDetail WvW match detailed info
	 */
	public void getWvWMatchDetail(int worldID, Consumer<WvWMatchDetail> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWMatchDetail(worldID, c);
		}, c -> {
			// TODO: implement method in SynchronousRequest
			// WvWMatchDetail ed = gw2.getSynchronous().getWvWMatchDetail(worldID);
			// consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of wvw match id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @see WvWMatchDetail WvW match detailed info
	 */
	public void getWvWMatchDetail(String[] ids, Consumer<List<WvWMatchDetail>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWMatchDetail(ids, c);
		}, c -> {
			// TODO: implement method in SynchronousRequest
			// List<WvWMatchDetail> ed = gw2.getSynchronous().getWvWMatchDetail(ids);
			// consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param worldID
	 *            {@link World#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWMatchOverview WvW match overview info
	 */
	public void getWvWMatchOverview(int worldID, Consumer<WvWMatchOverview> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWMatchOverview(worldID, c);
		}, c -> {// TODO: implement method in SynchronousRequest
			// WvWMatchOverview ed = gw2.getSynchronous().getWvWMatchOverview(worldID);
			// consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of wvw match id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @see WvWMatchOverview WvW match overview info
	 */
	public void getWvWMatchOverview(String[] ids, Consumer<List<WvWMatchOverview>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWMatchOverview(ids, c);
		}, c -> {// TODO: implement method in SynchronousRequest
			// List<WvWMatchOverview> ed = gw2.getSynchronous().getWvWMatchOverview(ids);
			// consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param worldID
	 *            {@link World#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWMatchScore WvW match score info
	 */
	public void getWvWMatchScore(int worldID, Consumer<WvWMatchScore> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWMatchScore(worldID, c);
		}, c -> {
			// TODO: implement method in SynchronousRequest
			// WvWMatchScore ed = gw2.getSynchronous().getWvWMatchScore(worldID);
			// consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of wvw match id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @see WvWMatchScore WvW match score info
	 */
	public void getWvWMatchScore(String[] ids, Consumer<List<WvWMatchScore>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWMatchScore(ids, c);
		}, c -> {// TODO: implement method in SynchronousRequest
			// List<WvWMatchScore> ed = gw2.getSynchronous().getWvWMatchScore(ids);
			// consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param worldID
	 *            {@link World#id}
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWMatchStat WvW match stat info
	 */
	public void getWvWMatchStat(int worldID, Consumer<WvWMatchStat> consumer) throws NullPointerException {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWMatchStat(worldID, c);
		}, c -> {
			// TODO: implement method in SynchronousRequest
			// WvWMatchStat ed = gw2.getSynchronous().getWvWMatchStat(worldID);
			// consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW matches API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of wvw match id(s)
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @see WvWMatchStat WvW match stat info
	 */
	public void getWvWMatchStat(String[] ids, Consumer<List<WvWMatchStat>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWMatchStat(ids, c);
		}, c -> {
			// TODO: implement method in SynchronousRequest
			// List<WvWMatchStat> ed = gw2.getSynchronous().getWvWMatchStat(ids);
			// consumer.accept(ed);
		});
	}

	// WvW Objectives

	/**
	 * For more info on WvW abilities API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWObjective WvW objective info
	 */
	public void getAllWvWObjectiveID(Consumer<List<String>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWvWObjectiveID(c);
		}, c -> {
			List<String> ed = gw2.getSynchronous().getAllWvWObjectiveID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW abilities API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of WvW objective id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWObjective WvW objective info
	 */
	public void getWvWObjectiveInfo(String[] ids, Consumer<List<WvWObjective>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWObjectiveInfo(ids, c);
		}, c -> {
			List<WvWObjective> ed = gw2.getSynchronous().getWvWObjectiveInfo(ids);
			consumer.accept(ed);
		});
	}

	// WvW Ranks

	/**
	 * For more info on WvW ranks API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWRank WvW rank info
	 */
	public void getAllWvWRankID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWvWRankID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllWvWRankID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW ranks API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of WvW rank id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWRank WvW rank info
	 */
	public void getWvWRankInfo(int[] ids, Consumer<List<WvWRank>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWRankInfo(ids, c);
		}, c -> {
			List<WvWRank> ed = gw2.getSynchronous().getWvWRankInfo(ids);
			consumer.accept(ed);
		});
	}

	// WvW Upgrades

	/**
	 * For more info on WvW upgrades API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWUpgrade WvW upgrade info
	 */
	public void getAllWvWUpgradeID(Consumer<List<Integer>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getAllWvWUpgradeID(c);
		}, c -> {
			List<Integer> ed = gw2.getSynchronous().getAllWvWUpgradeID();
			consumer.accept(ed);
		});
	}

	/**
	 * For more info on WvW upgrades API go
	 * <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">here</a><br/>
	 * Give user the access to {@link Consumer#onResponse(Call, Response)} and
	 * {@link Consumer#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param ids
	 *            list of WvW upgrade id
	 * @param consumer
	 *            consumer that is going to be used for
	 *            {@link Call#enqueue(Consumer)}
	 * @throws GuildWars2Exception
	 *             empty ID list
	 * @throws NullPointerException
	 *             if given {@link Consumer} is empty
	 * @see WvWUpgrade WvW upgrade info
	 */
	public void getWvWUpgradeInfo(int[] ids, Consumer<List<WvWUpgrade>> consumer) {
		execute(consumer, c -> {
			gw2.getAsynchronous().getWvWUpgradeInfo(ids, c);
		}, c -> {
			List<WvWUpgrade> ed = gw2.getSynchronous().getWvWUpgradeInfo(ids);
			consumer.accept(ed);
		});
	}
}
