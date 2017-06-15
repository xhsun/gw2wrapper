package me.xhsun.guildwars2wrapper.model.character;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;

import java.util.List;

/**
 * For more info on character training API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Training">here</a><br/>
 * Model class for character training
 * @see me.xhsun.guildwars2wrapper.model.Profession.Training
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterTraining {
	private List<Training> training;

	public List<Training> getTraining() {
		return training;
	}

	@Override
	public String toString() {
		return "CharacterTraining{" +
				"training=" + training +
				'}';
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

		@Override
		public String toString() {
			return "Training{" +
					"id=" + getId() +
					", spent=" + spent +
					", done=" + done +
					'}';
		}
	}
}
