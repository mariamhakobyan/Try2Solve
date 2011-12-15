package it.try2solve.oauth.parser;

import it.try2solve.data.model.User;
import it.try2solve.data.model.UserSource;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.gson.*;


public class FacebookParser {

	public User getUser(String jsonData) {
		final User user = new User();
		user.setUserSource(UserSource.FaceBook);
		user.setLastLogin((new Date()).getTime());
		
		HashMap<String, Object> map = parse(jsonData);
		
		user.setSocialId((String)map.get("id"));
		user.setFirstName((String)map.get("first_name"));
		user.setLastName((String)map.get("last_name"));
		user.setLastName((String)map.get("last_name"));
		user.setLink((String)map.get("link"));
		
		return user;
	}

	private HashMap<String, Object> parse(String json) {
		
		JsonParser parser = new JsonParser();
		Object obj = parser.parse(json);
		if(obj instanceof JsonNull) {
			return null;
		}
		JsonObject jobj = (JsonObject) obj;
		
		Set<Map.Entry<String, JsonElement>> set = jobj.entrySet();
		
		Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		while (iterator.hasNext()) {
			Map.Entry<String, JsonElement> entry = iterator.next();
			String key = entry.getKey();
			JsonElement value = entry.getValue();
			if (!value.isJsonPrimitive()) {
				map.put(key, parse(value.toString()));
			} else {
				map.put(key, value.getAsString());
			}
		}
		return map;
	}

}
