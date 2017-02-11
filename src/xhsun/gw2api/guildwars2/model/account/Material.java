package xhsun.gw2api.guildwars2.model.account;

import xhsun.gw2api.guildwars2.model.util.Item;
import xhsun.gw2api.guildwars2.model.util.MaterialCategory;

/**
 * For more info on MaterialCategory Storage API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">here</a><br/>
 * Material storage item model class<br/>
 * Note: for item that is empty the count will be zero
 * @see Item item info
 * @see MaterialCategory material category info
 * @author xhsun
 * @since 2017-02-07
 */

public class Material {
	private long id;
	private int category;
	private int count;

	public long getId() {
		return id;
	}

	public int getCategory() {
		return category;
	}

	public int getCount() {
		return count;
	}

	public String toString(){
		return "{Item ID: "+id+" Category ID: "+category+" Count: "+count+"}";
	}
}
