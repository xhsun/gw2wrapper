package me.xhsun.guildwars2wrapper;

/**
 * Class that contains some utility functions
 *
 * @author xhsun
 * @since 2017-06-28
 */
public class GuildWars2Utility {
	/**
	 * get first id in a combined id, ie, get 7 from 7-54<br/>
	 *
	 * useful for getting wvw map id from wvw objective id, or
	 * getting back story question id from back story answer id
	 *
	 * @param id combined id in the form of [0-9]+-[0-9]+
	 * @return root id | -1 for invalid input
	 */
	public int getRootID(String id) {
		if (id == null || id.equals("")) return -1;
		String[] strIds;
		if (id.contains("-")) strIds = id.split("-");
		else return -1;
		try {
			return Integer.parseInt(strIds[0]);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	/**
	 * parse given coin value into number of gold, sliver, and copper
	 *
	 * @param value coin value
	 * @return results in array: index 0 is number of gold, index 1 is number of sliver, index 2 is number of copper
	 */
	public long[] parseCoins(long value) {
		long[] result = new long[3];
		if (value < 0) return result;

		long temp = value;
		result[2] = temp % 100;
		temp = temp / 100;
		result[1] = temp % 100;
		result[0] = temp / 100;
		return result;
	}

	//TODO chatLinkToItemID

	//TODO method that striped html from string ie, "<a>this</a>, that" becomes ", that"
}
