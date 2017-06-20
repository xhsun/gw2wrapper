package me.xhsun.guildwars2wrapper.model.v2.wvw.matches;

import me.xhsun.guildwars2wrapper.model.identifiable.IdentifiableStr;

/**
 * Template super class for:<br/>
 * - {@link WvWMatchOverview}
 * - {@link WvWMatchDetail}
 * - {@link WvWMatchScore}
 * - {@link WvWMatchStat}
 *
 * @author xhsun
 * @since 2017-06-20
 */
public class WvWMatch extends IdentifiableStr {
	public enum Endpoint {All, Overview, Score, Stat}
}
