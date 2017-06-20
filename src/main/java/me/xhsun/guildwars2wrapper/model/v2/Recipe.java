package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.v2.guild.GuildUpgrade;
import me.xhsun.guildwars2wrapper.model.v2.util.comm.CraftingDisciplines;
import me.xhsun.guildwars2wrapper.model.v2.util.comm.Type;

import java.util.List;

/**
 * For more info on Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
 * Model class for recipes
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Recipe extends IdentifiableInt {
	public enum Flag {AutoLearned, LearnedFromItem}
	private Type type;
	private int output_item_id;
	private int output_item_count;
	private int time_to_craft_ms;
	private List<CraftingDisciplines> disciplines;
	private int min_rating;
	private List<Flag> flags;
	private List<Ingredient> ingredients;
	private List<Ingredient> guild_ingredients;
	private long output_upgrade_id;
	private String chat_link;

	public Type getType() {
		return type;
	}

	public int getOutputItemId() {
		return output_item_id;
	}

	public int getOutputItemCount() {
		return output_item_count;
	}

	public int getTimeToCraftMS() {
		return time_to_craft_ms;
	}

	public List<CraftingDisciplines> getDisciplines() {
		return disciplines;
	}

	public int getMinRating() {
		return min_rating;
	}

	public List<Flag> getFlags() {
		return flags;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public List<Ingredient> getGuildIngredients() {
		return guild_ingredients;
	}

	public long getOutputUpgradeId() {
		return output_upgrade_id;
	}

	public String getChatLink() {
		return chat_link;
	}

	/**
	 * recipe ingredients
	 */
	public class Ingredient {
		private int item_id;
		private int upgrade_id;
		private int count;

		public int getItemId() {
			return item_id;
		}

		/**
		 * @return {@link GuildUpgrade#id}
		 */
		public int getUpgradeId() {
			return upgrade_id;
		}

		public int getCount() {
			return count;
		}
	}
}
