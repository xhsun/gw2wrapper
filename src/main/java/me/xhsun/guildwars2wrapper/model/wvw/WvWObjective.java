package me.xhsun.guildwars2wrapper.model.wvw;

import me.xhsun.guildwars2wrapper.model.identifiable.NameableStr;
import me.xhsun.guildwars2wrapper.model.wvw.matches.WvWMatchMap;

import java.util.Arrays;

/**
 * For more info on WvW objectives API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">here</a><br/>
 * Model class for WvW objective
 *
 * @author xhsun
 * @since 2017-06-20
 */
public class WvWObjective extends NameableStr {
	public enum Type {Camp, Ruins, Keep, Spawn, Tower, Castle, Mercenary, Resource, Generic}

	private Type type;
	private int sector_id, map_id, upgrade_id;
	private WvWMatchMap.Type map_type;
	private float[] coord, label_coord;
	private String marker, chat_link;

	public Type getType() {
		return type;
	}

	public int getSectorId() {
		return sector_id;
	}

	public int getMapId() {
		return map_id;
	}

	public int getUpgradeId() {
		return upgrade_id;
	}

	public WvWMatchMap.Type getMapType() {
		return map_type;
	}

	public float[] getCoord() {
		return coord;
	}

	public float[] getLabelCoord() {
		return label_coord;
	}

	public String getMarker() {
		return marker;
	}

	public String getChatLink() {
		return chat_link;
	}

	@Override
	public String toString() {
		return "WvWObjective{" +
				super.toString() +
				", type=" + type +
				", sector_id=" + sector_id +
				", map_id=" + map_id +
				", upgrade_id=" + upgrade_id +
				", map_type=" + map_type +
				", coord=" + Arrays.toString(coord) +
				", label_coord=" + Arrays.toString(label_coord) +
				", marker='" + marker + '\'' +
				", chat_link='" + chat_link + '\'' +
				'}';
	}
}
