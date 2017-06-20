package me.xhsun.guildwars2wrapper.model.v2.backstory;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;
import me.xhsun.guildwars2wrapper.model.v2.Item;

import java.util.List;

/**
 * For more info on back story answer API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/answers">here</a><br/>
 * Model class for back story answer
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class BackStoryAnswer extends IdentifiableStr {
	private String title, description, journal;
	private int question;
	private List<Item.Restriction> professions, races;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getJournal() {
		return journal;
	}

	/**
	 * @return {@link BackStoryQuestion#id}
	 */
	public int getQuestion() {
		return question;
	}

	public List<Item.Restriction> getProfessions() {
		return professions;
	}

	public List<Item.Restriction> getRaces() {
		return races;
	}
}
