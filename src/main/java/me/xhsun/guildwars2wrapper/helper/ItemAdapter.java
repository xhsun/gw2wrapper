package me.xhsun.guildwars2wrapper.helper;

import com.google.gson.*;
import me.xhsun.guildwars2wrapper.model.v2.Item;
import me.xhsun.guildwars2wrapper.model.v2.util.itemDetail.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

/**
 * For casting {@link Item#details} to the correct type of {@link ItemDetail}
 */
public class ItemAdapter implements JsonDeserializer<Item> {
	//NOTE: don't forget to change those if they ever got changed
	private static final String ITEM_DETAIL = "details", ITEM_TYPE = "type";

	@Override
	public Item deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		System.out.println(json);
		JsonObject obj = json.getAsJsonObject();
		Gson gson = new GsonBuilder().create();

		Item item = new Item();

		//Yep, I know using reflection to set the fields is bad
		//but I don't want to make Item an exception (in terms of availability of methods to set the fields)
		Set<Field> fields = getItemFields();

		for (Field f : fields) {
			if (obj.get(f.getName()) != null) {
				try {
					f.setAccessible(true);//make sure the fields is accessible

					if (f.getName().equals(ITEM_DETAIL)) {
						f.set(item, getItemDetail(gson, obj.get(ITEM_TYPE), obj.get(ITEM_DETAIL)));
					} else {
						//cast json element to the correct type using the field's type and save to the field
						f.set(item, gson.fromJson(obj.get(f.getName()), f.getType()));
					}
				} catch (IllegalAccessException ignored) {
				}
			}
		}

		return item;
	}

	//get the correct type of item detail, will give null if itemType/detail is empty
	private ItemDetail getItemDetail(Gson gson, JsonElement itemType, JsonElement detail) {
		if (itemType == null || detail == null) return null;

		Item.Type type = gson.fromJson(itemType, Item.Type.class);
		Class<? extends ItemDetail> detailType;

		switch (type) {
			case Armor:
				detailType = Armor.class;
				break;
			case Back:
				detailType = Back.class;
				break;
			case Bag:
				detailType = Bag.class;
				break;
			case Consumable:
				detailType = Consumable.class;
				break;
			case MiniPet:
				detailType = Mini.class;
				break;
			case Trinket:
				detailType = Trinket.class;
				break;
			case UpgradeComponent:
				detailType = UpgradeComponent.class;
				break;
			case Weapon:
				detailType = Weapon.class;
				break;
			default:
				detailType = Utility.class;
		}

		return gson.fromJson(detail, detailType);
	}

	//get all fields for item class and all of it's super classes
	private Set<Field> getItemFields() {
		Class next = Item.class;
		Set<Field> fields = new HashSet<>(getFields(next));
		while (next.getSuperclass() != Object.class) {
			next = next.getSuperclass();
			fields.addAll(getFields(next));
		}
		return fields;
	}

	//get field of given class
	private List<Field> getFields(Class given) {
		Field[] fs = given.getDeclaredFields();
		return new ArrayList<>(Arrays.asList(fs));
	}
}
