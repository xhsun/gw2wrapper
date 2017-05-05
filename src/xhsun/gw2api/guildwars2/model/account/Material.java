package xhsun.gw2api.guildwars2.model.account;

import xhsun.gw2api.guildwars2.model.Item;
import xhsun.gw2api.guildwars2.model.MaterialCategory;
import xhsun.gw2api.guildwars2.model.util.Storage;

/**
 * For more info on MaterialCategory Storage API go <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">here</a><br/>
 * Material storage item model class<br/>
 * Note: for item that is empty the count will be zero
 * @see Item item info
 * @see MaterialCategory material category info
 * @author xhsun
 * @since 2017-02-07
 */

public class Material extends Storage {
	private int category;

	public int getCategory() {
		return category;
	}

	public String toString(){
		return "{Item ID: "+super.getItemId()+" Category ID: "+category+" Count: "+super.getCount()+" Binding: "+getBinding()+"}\n";
	}
}
