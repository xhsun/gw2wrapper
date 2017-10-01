package me.xhsun.guildwars2wrapper.model.v2;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableInt;

import java.util.List;

/**
 * For more info on specializations API go <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">here</a><br/>
 * Model class for specialization
 *
 * Note: Profession icon only available if the specialization is an elite specialization
 * @author xhsun
 * @since 2017-06-15
 */
public class Specialization extends NameableInt {
	private Item.Restriction profession;
	private boolean elite;
	private String background, icon, profession_icon, profession_icon_big;
	private List<Integer> minor_traits, major_traits;

	public Item.Restriction getProfession() {
		return profession;
	}

	public boolean isElite() {
		return elite;
	}

	public String getIcon() {
		return icon;
	}

	public String getBackground() {
		return background;
	}

	public List<Integer> getMinorTraits() {
		return minor_traits;
	}

	public List<Integer> getMajorTraits() {
		return major_traits;
	}

	public String getProfessionIcon() {
		return profession_icon;
	}

	public String getProfessionIconBig() {
		return profession_icon_big;
	}
}
