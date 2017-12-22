package com.tamber.net;

import com.tamber.exception.TamberException;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import com.loopj.android.http.JsonHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

public abstract class TamberResponseHandler {
	public abstract void onCompletion(JSONObject response, TamberException err);

	protected JsonHttpResponseHandler toJsonHttpResponseHandler() {
		return new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
				try {
					if (response.getBoolean("success")) {
						// success=ture means the request worked
						onCompletion(response.getJSONObject("result"), null);
					} else {
						// success=false means the request failed
						onCompletion(null, new TamberException("Tamber API error: " + response.getString("error")));
					}
				} catch (JSONException e) {
					// Either no success bool given, success=true but no result object given, success=false but no error string given
					onCompletion(null, new TamberException(e));
				}
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
				// Should never get here
				onCompletion(null, new TamberException("Recieved unexpected JSON array"));
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
				if (errorResponse.isNull("success")) {
					// No error response
					onCompletion(null, new TamberException(throwable));
				} else {
					try {
						if (errorResponse.getBoolean("success")) {
							// Should never get here, send both the result and the error
							onCompletion(errorResponse.getJSONObject("result"), new TamberException(throwable));
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
		};
	}
}