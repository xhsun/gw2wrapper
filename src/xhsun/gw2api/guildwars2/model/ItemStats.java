package xhsun.gw2api.guildwars2.model;

import xhsun.gw2api.guildwars2.model.util.itemDetail.ItemAttributes;

/**
 * For more info on Itemstat API go <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">here</a><br/>
 * Itemstat model class
 * @see ItemAttributes item attribute
 * @author xhsun
 * @since 2017-02-07
 */
public class ItemStats {
	private long id;
	private String name;
	private ItemAttributes attributes;

	public long getId() {
		return id;
	}
	public String getName(){return name;}
	public ItemAttributes getAttributes() {
		return attributes;
	}

	@Override
	public String toString(){
		return "{Itemstat ID: "+id+" Name: "+name+" Attribute: "+attributes+"}";
	}
}