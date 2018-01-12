package com.tamber.object;

import com.tamber.net.Client;
import com.tamber.net.Comms;
import com.tamber.net.TamberResponseHandler;

import java.util.HashMap;
import java.util.Map;

public class Behavior extends TamberObject {
	private static final String object = "behavior";
	private Client client;

	public Behavior(Client c) {
		client = c;
	}

	public void create(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "create", _getBody(params), respHandler);
	}
	public void retrieve(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Get(client, object, "retrieve", _getBody(params), respHandler);
	}
	public void retrieve(String name, TamberResponseHandler respHandler) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		retrieve(params, respHandler);
	}
}