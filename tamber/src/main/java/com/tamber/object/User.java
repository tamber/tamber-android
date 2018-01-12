package com.tamber.object;

import com.tamber.net.Client;
import com.tamber.net.Comms;
import com.tamber.net.TamberResponseHandler;

import java.util.HashMap;
import java.util.Map;

public class User extends TamberObject {
	private static final String object = "user";
	private Client client;
	private String user;

	public User(Client c) {
		client = c;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void create(Map<String, Object> params, TamberResponseHandler respHandler) {
		if (this.user != null && params.get("id") == null) {
			params.put("id", user);
		}
		Comms.Post(client, object, "create", this._getBody(params), respHandler);
	}
	public void update(Map<String, Object> params, TamberResponseHandler respHandler) {
		if (this.user != null && params.get("id") == null) {
			params.put("id", user);
		}
		Comms.Post(client, object, "update", this._getBody(params), respHandler);
	}
	public void retrieve(Map<String, Object> params, TamberResponseHandler respHandler) {
		if (this.user != null && params.get("id") == null) {
			params.put("id", user);
		}
		Comms.Get(client, object, "retrieve", this._getBody(params), respHandler);
	}
	public void merge(String from, String to, Boolean no_create, TamberResponseHandler respHandler) {
		if (from == null) {
			from = this.user;
		}
		setUser(to);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("from", from);
		params.put("to", to);
		if (no_create) {
			params.put("no_create", true);
		}
		Comms.Post(client, object, "merge", this._getBody(params), respHandler);
	}
}