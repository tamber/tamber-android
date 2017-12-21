package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;

import java.util.Map;

import com.loopj.android.http.JsonHttpResponseHandler;

public class User extends TamberObject {
	private static final String object = "user";
	private Client client;

	public User(Client c) {
		client = c;
	}

	public void create(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "create", this._getBody(params), respHandler);
	}
	public void update(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "update", this._getBody(params), respHandler);
	}
	public void retrieve(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "retrieve", this._getBody(params), respHandler);
	}
}