package com.tamber.types;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONValue;
import com.tamber.exception.TamberException;

public class TamberFilter {
	private Object value;
	private TamberFilterFunction function;
	private List<TamberFilter> args;

	public TamberFilter(TamberFilterFunction key, List<Object> values) {
		function = key;
		int len = values.size();
		args = new ArrayList<TamberFilter>(len);
		for (int i=0; i<len; i++) {
			Object value = values.get(i);
			if (value instanceof TamberFilter) {
				args.add((TamberFilter) value);
			} else {
				args.add(new TamberFilter(value));
			}
		}
	}

	public TamberFilter(Object value) {
		this.value = value;
	}

	public Object toMap() {
		if (value == null) {
			return value;
		}
		Map<String, Object> out = new HashMap<String, Object>();
		int len = args.size();
		List<Object> values = new ArrayList<Object>(len);
		for (int i=0; i<len; i++) {
			values.add(args.get(i).toMap());
		}
		out.put(function.getFunction(), values);
		return out;
	}

	public String toString() {
		return JSONValue.toJSONString(toMap());
	}
}