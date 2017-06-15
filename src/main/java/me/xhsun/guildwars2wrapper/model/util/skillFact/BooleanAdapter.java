package me.xhsun.guildwars2wrapper.model.util.skillFact;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Use for {@link SkillFact} for when type is {@link me.xhsun.guildwars2wrapper.model.util.skillFact.SkillFact.Type#Unblockable}
 * the value is boolean instead of int
 *
 * @author xhsun
 * @since 2017-06-15
 */
public class BooleanAdapter implements JsonDeserializer<Integer> {

	@Override
	public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			return json.getAsInt();
		} catch (NumberFormatException e) {
			return (json.getAsBoolean()) ? 1 : 0;
		}
	}
}