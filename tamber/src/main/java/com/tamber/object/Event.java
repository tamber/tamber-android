package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.types.TamberEvent;
import com.tamber.types.TamberGetRecs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class Event extends TamberObject {
	private static final String object = "event";
	private Client client;

	public Event(Client c) {
		client = c;
	}

	public void track(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "track", _getBody(params), respHandler);
	}
	public void track(TamberEvent event, TamberGetRecs get_recs, JsonHttpResponseHandler respHandler) {
		Map<String, Object> params = event.toMap();
		params.put("get_recs", get_recs);
		track(params, respHandler);
	}
	public void retrieve(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "retrieve", _getBody(params), respHandler);
	}
	public void batch(Map<String, Object> params, JsonHttpResponseHandler respHandler) {
		Comms.Post(client, object, "batch", _getBody(params), respHandler);
	}
	public void batch(List<TamberEvent> events, JsonHttpResponseHandler respHandler) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("events", events);
		batch(params, respHandler);
	}
}