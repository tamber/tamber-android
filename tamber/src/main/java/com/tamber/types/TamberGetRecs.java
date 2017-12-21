package com.tamber.types;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.tamber.exception.TamberException;

public class TamberGetRecs {
	public Integer number;
	public Integer page;
	public List<String> excludeItems;
	public Double variability;
	public TamberFilter filter;
	public Boolean getProperties;

	public Map<String, Object> toMap() {
		Map<String, Object> out = new HashMap<String, Object>();
		if (number != null) {
			out.put("number", number);
		}
		if (page != null) {
			out.put("page", page);
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
		return out;
	}

	public String toString() {
		return JSONValue.toJSONString(toMap());
	}
}