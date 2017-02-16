package xhsun.gw2api.guildwars2.model;

/**
 * For more info on Material Category API go <a href="https://wiki.guildwars2.com/wiki/API:2/materials">here</a><br/>
 * Material category model class
 * @see Item item info
 * @author xhsun
 * @since 2017-02-07
 */

public class MaterialCategory {
	private int id;
	private String name;
	private long[] items;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long[] getItems() {
		return items;
	}

	@Override
	public String toString(){
		String result="{Category ID: "+id+" Name: "+name;
		if (items!=null){
			result+="Item IDs: ";
			for (long item : items) result += item + ", ";
		}
		return result.substring(0, result.length()-2)+"}";
	}
}
