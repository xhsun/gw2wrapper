package me.xhsun.guildwars2wrapper;

/**
 * Class that contains some utility functions
 *
 * @author xhsun
 * @since 2017-06-28
 */
public class GuildWars2Utility {
	private static final String TAG = "<[^>]*>";
	/**
	 * get first id in a combined id, ie, get 7 from 7-54<br/>
	 *
	 * useful for getting wvw map id from wvw objective id, or
	 * getting back story question id from back story answer id
	 *
	 * @param id combined id in the form of [0-9]+-\b+
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

	/**
	 * Remove HTML tag(s) and the string enclosed by HTML tags
	 * (ie, {@literal "<a>this</a>, that"} becomes ", that")<br/>
	 *
	 * @param value string to remove HTML from
	 * @return string without HTML
	 */
	public String removeSimpleHTML(String value) {
		String rex = "<^[>]+/>|" + TAG + "[^<]*</[^>]*>|" + TAG;
		if (value == null || value.equals("")) return "";
		return value.replaceAll(rex, "");
	}

	/**
	 * remove HTML tag(s) from given string<br/>
	 * ie, "<a>this</a>, that" becomes "this, that"
	 *
	 * @param value string to strip HTML tag from
	 * @return string without HTML tag
	 */
	public String removeHTMLTag(String value) {
		if (value == null || value.equals("")) return "";
		return value.replaceAll(TAG, "");
	}

	//TODO chatLinkToItemID
}
