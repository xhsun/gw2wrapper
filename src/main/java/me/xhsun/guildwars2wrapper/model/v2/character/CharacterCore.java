package me.xhsun.guildwars2wrapper.model.v2.character;

import me.xhsun.guildwars2wrapper.model.v2.Item;

/**
 * For more info on Character CharacterCore API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
 * Character core information model class<br/>
 * Note: age is the amount of seconds this character was played<br/>
 * Note: guild model class and title model class don't exist as of right now
 *
 * @author xhsun
 * @see Item for race and profession enum
 * @since 2017-03-28
 */
public class CharacterCore {
	public enum Gender {Male, Female}

	private String name;
	private Item.Restriction race;
	private Gender gender;
	private Item.Restriction profession;
	private int level;
	private String guild;//guild id
	private long age;//in seconds
	private String created;
	private long deaths;
	private long title;//title id

	public String getName() {
		return name;
	}

	public Item.Restriction getRace() {
		return race;
	}

	public Gender getGender() {
		return gender;
	}

	public Item.Restriction getProfession() {
		return profession;
	}

	public int getLevel() {
		return level;
	}

	public String getGuild() {
		return guild;
	}

	public long getAge() {
		return age;
	}

	/**
	 * @return ISO-8601 standard timestamp
	 */
	public String getCreated() {
		return created;
	}

	public long getDeath() {
		return deaths;
	}

	public long getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CharacterCore core = (CharacterCore) o;

		return (name != null ? name.equals(core.name) : core.name == null) &&
				(created != null ? created.equals(core.created) : core.created == null);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (created != null ? created.hashCode() : 0);
		return result;
	}
}
