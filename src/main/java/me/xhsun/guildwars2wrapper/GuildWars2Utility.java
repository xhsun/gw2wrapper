package me.xhsun.guildwars2wrapper;

/**
 * Class that contains some utility functions
 *
 * @author xhsun
 * @since 2017-06-28
 */
public class GuildWars2Utility {
	/**
	 * get the WvW map id from WvW objective id
	 *
	 * @param id objective id
	 * @return map id | -1 if input isn't in the form of [0-9]+-[0-9]+
	 */
	public int getWvWMapID(String id) {
		String[] strIds;
		if (id.contains("-")) strIds = id.split("-");
		else return -1;
		try {
			return Integer.parseInt(strIds[0]);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
}
