package xhsun.gw2api.guildwars2.model.character;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import xhsun.gw2api.guildwars2.model.Item;

/**
 * For more info on Character Core API go <a href="https://wiki.guildwars2.com/wiki/API:2/characters#Core">here</a><br/>
 * Character core information model class<br/>
 * Note: age is the amount of seconds this character was played<br/>
 * Note: guild model class and title model class don't exist as of right now
 * @see Item for race and profession enum
 * @author xhsun
 * @since 2017-03-28
 */
public class Core {
	public enum Gender{ Male, Female }
	private String name;
	private Item.Restriction race;
	private Gender gender;
	private Item.Restriction profession;
	private int level;
	private String guild;//guild id
	private long age;//in seconds
	private String created;
	private long death;
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

	public DateTime getCreated() {
		if (created==null) return null;
		DateTimeFormatter formatter= ISODateTimeFormat.dateTimeNoMillis();
		return formatter.parseDateTime(created);
	}

	public long getDeath() {
		return death;
	}

	public long getTitle() {
		return title;
	}

	public String toString(){
		return "{Name: "+name+", Race:"+race+", Gender: "+gender+", Profession: "+profession+", Level: "+level+", Guild ID:"
				+ guild +", Age(seconds): " + age+", Created: "+getCreated()+", Death: "+death+", Title ID: "+title;
	}
}
