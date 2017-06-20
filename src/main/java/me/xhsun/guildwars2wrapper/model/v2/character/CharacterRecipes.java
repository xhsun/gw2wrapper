package me.xhsun.guildwars2wrapper.model.v2.character;

import java.util.List;

/**
 * For more info on Character Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters">here</a><br/>
 * Model class for character recipes
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterRecipes {
	private List<Integer> recipes;

	public List<Integer> getRecipes() {
		return recipes;
	}
}
