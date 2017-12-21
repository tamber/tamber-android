package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.types.TamberItem;

import java.util.Map;
import java.util.HashMap;

import com.loopj.android.http.JsonHttpResponseHandler;

public class Item extends TamberObject {
	private static final String object = "item";
	private Client client;

	public Item(Client c) {
		client = c;
	}

	public void create(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "create", _getBody(params), respHandler);
	}
	public void create(TamberItem item, JsonHttpResponseHandler respHandler) {
		create(item.toMap(), respHandler);
	}
	public void update(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "update", _getBody(params), respHandler);
	}
	public void retrieve(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "retrieve", _getBody(params), respHandler);
	}
	public void retrieve(String id, JsonHttpResponseHandler respHandler) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		retrieve(params, respHandler);
	}
	public void hide(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "hide", _getBody(params), respHandler);
	}
	public void hide(String id, JsonHttpResponseHandler respHandler) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		hide(params, respHandler);
	}
	public void unhide(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "unhide", _getBody(params), respHandler);
	}
	public void unhide(String id, JsonHttpResponseHandler respHandler) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		unhide(params, respHandler);
	}
	public void delete(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "delete", _getBody(params), respHandler);
	}
	public void delete(String id, JsonHttpResponseHandler respHandler) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		delete(params, respHandler);
	}
}