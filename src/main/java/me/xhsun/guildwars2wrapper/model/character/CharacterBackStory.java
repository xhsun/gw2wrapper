package me.xhsun.guildwars2wrapper.model.character;

import java.util.List;

/**
 * For more info on character back story API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Backstory">here</a><br/>
 * Model class for character back story
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class CharacterBackStory {
	private List<String> backstory;

	public List<String> getBackStory() {
		return backstory;
	}

	@Override
	public String toString() {
		return "CharacterBackStory{" +
				"backstory=" + backstory +
				'}';
	}
}
