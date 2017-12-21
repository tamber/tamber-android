package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;

import java.util.Map;

import com.loopj.android.http.JsonHttpResponseHandler;

public class Discover extends TamberObject {
	private static final String object = "discover";
	private Client client;

	public Discover(Client c) {
		client = c;
	}

	public void recommended(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "recommended", _getBody(params), respHandler);
	}
	public void similar(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "similar", _getBody(params), respHandler);
	}
	public void recommendedSimilar(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "recommended_similar", _getBody(params), respHandler);
	}
	public void next(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "next", _getBody(params), respHandler);
	}
	public void popular(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "popular", _getBody(params), respHandler);
	}
	public void hot(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "hot", _getBody(params), respHandler);
	}
}