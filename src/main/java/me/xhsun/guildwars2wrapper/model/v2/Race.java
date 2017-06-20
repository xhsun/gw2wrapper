package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

import java.util.List;

/**
 * For more info on races API go <a href="https://wiki.guildwars2.com/wiki/API:2/races">here</a><br/>
 * Model class for race
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class Race extends IdentifiableStr {
	private List<Integer> skills;

	public List<Integer> getSkills() {
		return skills;
	}
}
