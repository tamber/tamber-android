package com.tamber.net;

import com.tamber.exception.TamberException;

import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class Comms {
	private enum Method {
		GET, POST, PUT, DELETE
	}

	public static void Get(Client client, String object, String method, RequestParams params, JsonHttpResponseHandler respHandler) {
		client.httpClient.get(object+"/"+method, params, respHandler);
	}

	public static void Post(Client client, String object, String method, RequestParams params, JsonHttpResponseHandler respHandler) {
		client.httpClient.post(object+"/"+method, params, respHandler);
	}
}