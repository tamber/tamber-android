package com.tamber.object;

import com.loopj.android.http.RequestParams;

import org.json.simple.JSONValue;

import java.util.Map;

public class TamberObject {
	protected RequestParams _getBody(Map<String, Object> params) {
		RequestParams out = new RequestParams();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				continue;
			}
			if (value instanceof String) {
				out.put(key, (String) value);
			} else {
				out.put(key, JSONValue.toJSONString(value));
			}
		}
		return out;
	}
}