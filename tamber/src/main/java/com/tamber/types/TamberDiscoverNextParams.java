package com.tamber.types;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.json.simple.JSONValue;

public class TamberDiscoverNextParams {
	public String user;
	public Object item;
	public List<String> excludeItems;
	public Double variability;
	public TamberFilter filter;
	public Boolean getProperties;
	public Boolean continuation;
	public Boolean noCreate;

	public Map<String, Object> toMap() {
		Map<String, Object> out = new HashMap<String, Object>();
		if (user != null) {
			out.put("user", user);
		}
		if (item != null) {
			if (item instanceof TamberItem) {
				out.put("item", ((TamberItem) item).toString());
			} else if (item instanceof String) {
				out.put("item", (String) item);
			}
		}
		if (excludeItems != null) {
			out.put("exclude_items", excludeItems);
		}
		if (variability != null) {
			out.put("variability", variability);
		}
		if (filter != null) {
			out.put("filter", filter);
		}
		if (getProperties != null) {
			out.put("get_properties", getProperties);
		}
		if (continuation != null) {
			out.put("continuation", continuation);
		}
		if (noCreate != null) {
			out.put("no_create", noCreate);
		}
		return out;
	}

	public String toString() {
		return JSONValue.toJSONString(toMap());
	}
}