package xhsun.gw2api.guildwars2.model.util.itemDetail;

/**
 * For more info on Consumable detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Consumable">here</a><br/>
 * Item detail for consumable
 * @see ItemDetail item details
 * @author xhsun
 * @since 2017-02-10
 */
public class Consumable extends ItemDetail{
	public Type getType() { return super.type; }
	public String getDescription(){ return super.description; }
	public long getDuration(){ return super.duration_ms; }
	public Unlock getUnlockType(){ return super.unlock_type; }
	public long getColorID(){ return super.color_id; }
	public long getRecipeID(){ return super.recipe_id; }
	private String getName(){ return super.name; }

	@Override
	public String toString(){
		return "{Type: "+getType()+" Description: "+getDescription()+" Duration(ms): "+getDuration()+
				" UnlockType: "+getUnlockType()+" ColorID: "+getColorID()+" RecipeID: "+getRecipeID()+" Name: "+getName()+"}";
	}
}
