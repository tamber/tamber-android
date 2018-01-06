package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.net.TamberResponseHandler;
import com.tamber.types.TamberDiscoverNextParams;
import com.tamber.types.TamberDiscoverParams;

import java.util.Map;

public class Discover extends TamberObject {
	private static final String object = "discover";
	private Client client;

	public Discover(Client c) {
		client = c;
	}

	public void next(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "next", _getBody(params), respHandler);
	}
	public void next(TamberDiscoverNextParams params, TamberResponseHandler respHandler) {
		Map<String, Object> params = params.toMap();
		next(params, respHandler);
	}

	public void recommended(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "recommended", _getBody(params), respHandler);
	}
	public void recommended(TamberDiscoverParams params, TamberResponseHandler respHandler) {
		Map<String, Object> params = params.toMap();
		recommended(params, respHandler);
	}
	public void similar(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "similar", _getBody(params), respHandler);
	}
	public void similar(TamberDiscoverParams params, TamberResponseHandler respHandler) {
		Map<String, Object> params = params.toMap();
		similar(params, respHandler);
	}
	public void recommendedSimilar(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "recommended_similar", _getBody(params), respHandler);
	}
	public void recommendedSimilar(TamberDiscoverParams params, TamberResponseHandler respHandler) {
		Map<String, Object> params = params.toMap();
		recommendedSimilar(params, respHandler);
	}
	public void popular(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "popular", _getBody(params), respHandler);
	}
	public void popular(TamberDiscoverParams params, TamberResponseHandler respHandler) {
		Map<String, Object> params = params.toMap();
		popular(params, respHandler);
	}
	public void hot(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "hot", _getBody(params), respHandler);
	}
	public void hot(TamberDiscoverParams params, TamberResponseHandler respHandler) {
		Map<String, Object> params = params.toMap();
		hot(params, respHandler);
	}
}