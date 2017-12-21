package com.tamber.types;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.tamber.exception.TamberException;

public class TamberEvent {
	public String user;
	public String item;
	public String behavior;
	public Double amount;
	public Boolean hit;
	public List<String> context;
	public Long created;

	public TamberEvent() {}

	public TamberEvent(JSONObject object) throws JSONException {
		user = object.getString("user");
		item = object.getString("item");
		behavior = object.getString("behavior");
		if (!object.isNull("amount")) {
			amount = object.getDouble("amount");
		}
		if (!object.isNull("hit")) {
			hit = object.getBoolean("hit");
		}
		if (!object.isNull("context")) {
			JSONArray jsonArray = object.getJSONArray("context");
			int len = jsonArray.length();
			context = new ArrayList<String>(len);
			for (int i=0; i<len; i++) { 
				context.add(jsonArray.getString(i));
			}
		}
		if (!object.isNull("created")) {
			created = object.getLong("created");
		}
	}

	public Map<String, Object> toMap() {
		Map<String, Object> out = new HashMap<String, Object>();
		out.put("user", user);
		out.put("item", item);
		out.put("behavior", behavior);
		if (amount != null) {
			out.put("amount", amount);
		}
		if (hit != null) {
			out.put("hit", hit);
		}
		if (context != null) {
			out.put("context", context);
		}
		if (created != null) {
			out.put("created", created);
		}
		return out;
	}

	public String toString() {
		return JSONValue.toJSONString(toMap());
	}
}