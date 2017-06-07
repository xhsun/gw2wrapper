package me.xhsun.guildwars2wrapper.model;

import com.google.gson.annotations.Expose;
import me.xhsun.guildwars2wrapper.model.util.comm.CraftingDisciplines;
import me.xhsun.guildwars2wrapper.model.util.comm.Type;

import java.util.List;

/**
 * For more info on Recipes API go <a href="https://wiki.guildwars2.com/wiki/API:2/recipes">here</a><br/>
 * Model class for recipes
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Recipe {
	public enum Flag {AutoLearned, LearnedFromItem}

	private int id;
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

	public int getId() {
		return id;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Recipe recipe = (Recipe) o;

		return id == recipe.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "Recipe{" +
				"id=" + id +
				", type=" + type +
				", output_item_id=" + output_item_id +
				", output_item_count=" + output_item_count +
				", time_to_craft_ms=" + time_to_craft_ms +
				", disciplines=" + disciplines +
				", min_rating=" + min_rating +
				", flags=" + flags +
				", ingredients=" + ingredients +
				", guild_ingredients=" + guild_ingredients +
				", output_upgrade_id=" + output_upgrade_id +
				", chat_link='" + chat_link + '\'' +
				'}';
	}

	/**
	 * recipe ingredients
	 */
	public class Ingredient {
		@Expose
		private int item_id;
		@Expose
		private int upgrade_id;
		@Expose
		private int count;

		public int getItemId() {
			return item_id;
		}

		public int getUpgradeId() {
			return upgrade_id;
		}

		public int getCount() {
			return count;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Ingredient that = (Ingredient) o;

			return item_id == that.item_id &&
					upgrade_id == that.upgrade_id &&
					count == that.count;
		}

		@Override
		public int hashCode() {
			int result = id;
			result = 31 * result + upgrade_id;
			result = 31 * result + count;
			return result;
		}

		@Override
		public String toString() {
			return "Ingredient{" +
					"item_id=" + item_id +
					", upgrade_id=" + upgrade_id +
					", count=" + count +
					'}';
		}
	}
}
