package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.v2.Profession;

import java.util.List;

/**
 * For more info on character training API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Training">here</a><br/>
 * Model class for character training
 * @see Profession.Training
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterTraining {
	private List<Training> training;

	public List<Training> getTraining() {
		return training;
	}

	public class Training extends IdentifiableInt {
		private int spent;
		private boolean done;

		public int getSpent() {
			return spent;
		}

		public boolean isDone() {
			return done;
		}
	}
}
