package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.net.TamberResponseHandler;
import com.tamber.types.TamberEvent;
import com.tamber.types.TamberGetRecs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.loopj.android.http.RequestParams;

public class Event extends TamberObject {
	private static final String object = "event";
	private Client client;
	private String user;

	public Event(Client c) {
		client = c;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void track(Map<String, Object> params, TamberResponseHandler respHandler) {
		if (this.user != null && params.get("user") == null) {
			params.put("user", user);
		}
		Comms.Post(client, object, "track", _getBody(params), respHandler);
	}
	public void track(TamberEvent event, TamberGetRecs get_recs, TamberResponseHandler respHandler) {
		if (event.user == null) {
			event.user = this.user;
		}
		Map<String, Object> params = event.toMap();
		params.put("get_recs", get_recs);
		track(params, respHandler);
	}
	public void retrieve(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "retrieve", _getBody(params), respHandler);
	}
	public void batch(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "batch", _getBody(params), respHandler);
	}
	public void batch(List<TamberEvent> events, TamberResponseHandler respHandler) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("events", events);
		batch(params, respHandler);
	}
}