package com.tamber.types;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.json.simple.JSONValue;

public class TamberDiscoverParams {
	public String user;
	public String item;
	public Integer number;
	public Integer page;
	public TamberFilter filter;
	public Boolean getProperties;

	public Map<String, Object> toMap() {
		Map<String, Object> out = new HashMap<String, Object>();
		if (user != null) {
			out.put("user", user);
		}
		if (item != null) {
			out.put("item", item);
		}
		if (number != null) {
			out.put("number", number);
		}
		if (page != null) {
			out.put("page", page);
		}
		if (filter != null) {
			out.put("filter", filter);
		}
		if (getProperties != null) {
			out.put("get_properties", getProperties);
		}
		return out;
	}

	public String toString() {
		return JSONValue.toJSONString(toMap());
	}
}