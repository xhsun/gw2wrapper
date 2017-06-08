package me.xhsun.guildwars2wrapper.model.character;

import me.xhsun.guildwars2wrapper.model.indentifiable.IdentifiableInt;

/**
 * For more info on character training API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Training">here</a><br/>
 * Model class for character training
 * TODO /v2/professions
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterTraining extends IdentifiableInt {
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
		return "CharacterTraining{" +
				"id=" + getId() +
				", spent=" + spent +
				", done=" + done +
				'}';
	}
}
