package xhsun.gw2api.guildwars2.model.util;

/**
 * Character inventory bag item model class
 * @see Inventory character inventory item
 * @author xhsun
 * @since 2017-02-07
 */
public class Bag {
	private long id;
	private int size;
	private Inventory[] inventory;

	public long getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public Inventory[] getInventory() {
		return inventory;
	}

	@Override
	public String toString(){
		String result="{Bag's Item ID: "+id+" Size: "+size+"\n";
		if (inventory!=null){
			result+="Items: ";
			for (Inventory item : inventory) result += item + "\n";
		}
		return result+"}";
	}
}
