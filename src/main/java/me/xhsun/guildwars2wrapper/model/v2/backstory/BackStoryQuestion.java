package me.xhsun.guildwars2wrapper.model.v2.backstory;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableInt;
import me.xhsun.guildwars2wrapper.model.v2.Item;

import java.util.List;

/**
 * For more info on back story questions API go <a href="https://wiki.guildwars2.com/wiki/API:2/backstory/questions">here</a><br/>
 * Model class for back story question
 *
 * @author xhsun
 * @since 2017-06-07
 */
public class BackStoryQuestion extends IdentifiableInt {
	private String title, description;
	private List<String> answers;
	private int order;
	private List<Item.Restriction> professions, races;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * @return list of {@link BackStoryAnswer#id}
	 */
	public List<String> getAnswers() {
		return answers;
	}

	public int getOrder() {
		return order;
	}

	public List<Item.Restriction> getProfessions() {
		return professions;
	}

	public List<Item.Restriction> getRaces() {
		return races;
	}
}
