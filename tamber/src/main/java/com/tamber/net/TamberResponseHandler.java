package com.tamber.net;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.tamber.exception.TamberException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class TamberResponseHandler extends JsonHttpResponseHandler {
	public void onCompletion(JSONObject result, TamberException err) {
		// Override this
		// If the result is a JSONArray, it is wrapped to a JSONObject of the form {"result": JSONArray}
	}

	@Override
	public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
		try {
			if (response.getBoolean("success")) {
				// success=true means the request worked
				// Determine JSONObject vs JSONArray result
				JSONObject result = response.optJSONObject("result");
				if (result == null) {
					// JSONArray
					result = new JSONObject();
					result.put("result", response.getJSONArray("result"));
				}
				onCompletion(result, null);
			} else {
				// success=false means the request failed
				onCompletion((JSONObject) null, new TamberException("Tamber API error: " + response.getString("error")));
			}
		} catch (JSONException e) {
			// Either no success bool given, success=true but no result object given, success=false but no error string given
			onCompletion((JSONObject) null, new TamberException(e));
		}
	}

	@Override
	public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
		// Should never get here
		onCompletion(null, new TamberException("Recieved unexpected JSON array"));
	}

	@Override
	public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
		if (errorResponse == null || errorResponse.isNull("success")) {
			// No error response
			onCompletion(null, new TamberException(throwable));
		} else {
			try {
				if (errorResponse.getBoolean("success")) {
					// Should never get here, send both the result and the error
					JSONObject result = errorResponse.optJSONObject("result");
					if (result == null) {
						result = new JSONObject();
						result.put("result", errorResponse.getJSONArray("result"));
					}
					onCompletion(result, new TamberException(throwable));
				} else {
					// success=false means the error is available
					onCompletion(null, new TamberException("Tamber API error: " + errorResponse.getString("error")));
				}
			} catch (JSONException e) {
				// Either no success bool given, success=true but no result object given, success=false but no error string given
				onCompletion(null, new TamberException(e));
			}
		}
	}

	@Override
	public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
		// Should never get here
		onCompletion(null, new TamberException(throwable));
	}
}