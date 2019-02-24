package me.xhsun.guildwars2wrapper.requests.v2.characters;

import java.util.List;
import me.xhsun.guildwars2wrapper.error.GuildWars2Exception;
import me.xhsun.guildwars2wrapper.model.v2.Recipe;
import me.xhsun.guildwars2wrapper.model.v2.character.Character;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterBackStory;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterCore;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterCraftingLevel;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterEquipment;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterInventory;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterRecipes;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterSAB;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterSkills;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterSpecialization;
import me.xhsun.guildwars2wrapper.model.v2.character.CharacterTraining;
import me.xhsun.guildwars2wrapper.requests.GuildWars2API;
import me.xhsun.guildwars2wrapper.requests.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Characters extends Request {

	protected Characters(GuildWars2API gw2API) {
		super(gw2API);
	}

	//ASYNC
	/**
	 * For more info on Character API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getAllCharacterName(String API, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getAllCharacterName(API).enqueue(callback);
	}

	/**
	 * For more info on character overview API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Get character information for the given character name that is linked to given API key
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Character character info
	 */
	public void getCharacter(String API, String name, Callback<Character> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacter(name, API).enqueue(callback);
	}

	/**
	 * For more info on character overview API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Get all characters that is linked to given API key
	 *
	 * @param API      API key
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Character character info
	 */
	public void getAllCharacters(String API, Callback<List<Character>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API));
		gw2API.getAllCharacters(API).enqueue(callback);
	}

	/**
	 * For more info on character back story API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Backstory">here</a><br/>
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterBackStory back store answer info
	 */
	public void getCharacterBackStory(String API, String name, Callback<CharacterBackStory> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterBackStory(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Core API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
	 * Get basic character information for the given character name that is linked to given API key
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterCore basic character info
	 */
	public void getCharacterInformation(String API, String name, Callback<CharacterCore> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterCore(name, API).enqueue(callback);
	}

	/**
	 * For more info on character crafting API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Crafting">here</a><br/>
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterCraftingLevel character crafting info
	 */
	public void getCharacterCrafting(String API, String name, Callback<CharacterCraftingLevel> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterCrafting(name, API).enqueue(callback);
	}

	/**
	 * For more info on character equipment API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Equipment">here</a><br/>
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterEquipment equipment info
	 */
	public void getCharacterEquipment(String API, String name, Callback<CharacterEquipment> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterEquipment(name, API).enqueue(callback);
	}

	/**
	 * For more info on character hero points API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Heropoints">here</a><br/>
	 *
	 * @param API      API key
	 * @param name     name of character
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 */
	public void getCharacterHeroPoints(String API, String name, Callback<List<String>> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterHeroPoints(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Inventory API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Inventory">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterInventory character inventory info
	 */
	public void getCharacterInventory(String API, String name, Callback<CharacterInventory> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterInventory(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see Recipe recipe info
	 */
	public void getCharacterUnlockedRecipes(String API, String name, Callback<CharacterRecipes> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterUnlockedRecipes(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character SAB API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Super_Adventure_Box_.28sab.29">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterSAB character SAB info
	 */
	public void getCharacterSAB(String API, String name, Callback<CharacterSAB> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterSAB(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Skills API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Skills">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterSkills character skills info
	 */
	public void getCharacterSkills(String API, String name, Callback<CharacterSkills> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterSkills(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Specialization API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Specialization">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterSpecialization character specialization info
	 */
	public void getCharacterSpecialization(String API, String name, Callback<CharacterSpecialization> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterSpecialization(name, API).enqueue(callback);
	}

	/**
	 * For more info on Character Training API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Training">here</a><br/>
	 * Give user the access to {@link Callback#onResponse(Call, Response)} and {@link Callback#onFailure(Call, Throwable)} methods for custom interactions
	 *
	 * @param API      API key
	 * @param name     character name
	 * @param callback callback that is going to be used for {@link Call#enqueue(Callback)}
	 * @throws GuildWars2Exception  invalid API key | empty character name
	 * @throws NullPointerException if given {@link Callback} is empty
	 * @see CharacterTraining character training info
	 */
	public void getCharacterTraining(String API, String name, Callback<CharacterTraining> callback) throws GuildWars2Exception, NullPointerException {
		isParamValid(new ParamChecker(ParamType.API, API), new ParamChecker(ParamType.CHAR, name));
		gw2API.getCharacterTraining(name, API).enqueue(callback);
	}

	//SYNC
}
