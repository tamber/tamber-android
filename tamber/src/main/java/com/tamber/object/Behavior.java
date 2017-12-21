package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;

import java.util.Map;
import java.util.HashMap;

import com.loopj.android.http.JsonHttpResponseHandler;

public class Behavior extends TamberObject {
	private static final String object = "behavior";
	private Client client;

	public Behavior(Client c) {
		client = c;
	}

	public void create(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "create", _getBody(params), respHandler);
	}
	public void retrieve(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "retrieve", _getBody(params), respHandler);
	}
	public void retrieve(String name, JsonHttpResponseHandler respHandler) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		retrieve(params, respHandler);
	}
}