package com.tamber.types;

import java.util.Iterator;
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

public class TamberItem {
	public String id;
	public Map<String, Object> properties;
	public List<String> tags;
	public Long created;

	private Double popularity;
	private Double hotness;
	private Boolean hidden;

	public Double getPopularity() {
		return popularity;
	}

	public Double getHotness() {
		return hotness;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public TamberItem() {}

	public TamberItem(JSONObject object) throws JSONException {
		id = object.getString("id");
		if (!object.isNull("properties")) {
			JSONObject props = object.getJSONObject("properties");
			Iterator<String> keysItr = props.keys();
			properties = new HashMap<String, Object>();
			while (keysItr.hasNext()) {
				String key = keysItr.next();
				properties.put(key, props.get(key));
			}
		}
		if (!object.isNull("tags")) {
			JSONArray jsonArray = object.getJSONArray("tags");
			int len = jsonArray.length();
			tags = new ArrayList<String>(len);
			for (int i=0; i<len; i++) { 
				tags.add(jsonArray.getString(i));
			}
		}
		if (!object.isNull("created")) {
			created = object.getLong("created");
		}
	}

	public Map<String, Object> toMap() {
		Map<String, Object> out = new HashMap<String, Object>();
		out.put("id", id);
		if (properties != null) {
			out.put("properties", properties);
		}
		if (tags != null) {
			out.put("tags", tags);
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