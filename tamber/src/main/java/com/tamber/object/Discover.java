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
	private String user;

	public Discover(Client c) {
		client = c;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void next(Map<String, Object> params, TamberResponseHandler respHandler) {
		if (this.user != null && params.get("user") == null) {
			params.put("user", this.user);
		}
		Comms.Post(client, object, "next", _getBody(params), respHandler);
	}
	public void next(TamberDiscoverNextParams param, TamberResponseHandler respHandler) {
		if (param.user == null) {
			param.user = this.user;
		}
		Map<String, Object> params = param.toMap();
		next(params, respHandler);
	}

	public void recommended(Map<String, Object> params, TamberResponseHandler respHandler) {
		if (this.user != null && params.get("user") == null) {
			params.put("user", this.user);
		}
		Comms.Post(client, object, "recommended", _getBody(params), respHandler);
	}
	public void recommended(TamberDiscoverParams param, TamberResponseHandler respHandler) {
		if (param.user == null) {
			param.user = this.user;
		}
		Map<String, Object> params = param.toMap();
		recommended(params, respHandler);
	}
	public void similar(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "similar", _getBody(params), respHandler);
	}
	public void similar(TamberDiscoverParams param, TamberResponseHandler respHandler) {
		Map<String, Object> params = param.toMap();
		similar(params, respHandler);
	}
	public void recommendedSimilar(Map<String, Object> params, TamberResponseHandler respHandler) {
		if (this.user != null && params.get("user") == null) {
			params.put("user", this.user);
		}
		Comms.Post(client, object, "recommended_similar", _getBody(params), respHandler);
	}
	public void recommendedSimilar(TamberDiscoverParams param, TamberResponseHandler respHandler) {
		if (param.user == null) {
			param.user = this.user;
		}
		Map<String, Object> params = param.toMap();
		recommendedSimilar(params, respHandler);
	}
	public void popular(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "popular", _getBody(params), respHandler);
	}
	public void popular(TamberDiscoverParams param, TamberResponseHandler respHandler) {
		Map<String, Object> params = param.toMap();
		popular(params, respHandler);
	}
	public void hot(Map<String, Object> params, TamberResponseHandler respHandler) {
		Comms.Post(client, object, "hot", _getBody(params), respHandler);
	}
	public void hot(TamberDiscoverParams param, TamberResponseHandler respHandler) {
		Map<String, Object> params = param.toMap();
		hot(params, respHandler);
	}
}