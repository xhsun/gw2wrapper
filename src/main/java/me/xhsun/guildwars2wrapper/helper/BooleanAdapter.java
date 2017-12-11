package me.xhsun.guildwars2wrapper.helper;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import me.xhsun.guildwars2wrapper.model.v2.util.skillFact.SkillFact;

import java.lang.reflect.Type;

/**
 * When the {@link SkillFact#type} is {@link me.xhsun.guildwars2wrapper.model.v2.util.skillFact.SkillFact.Type#Unblockable},
 * change the value of {@link SkillFact#value} from boolean to int
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