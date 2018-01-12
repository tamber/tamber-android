package com.tamber.net;

import com.loopj.android.http.RequestParams;

public class Comms {
	public static void Get(Client client, String object, String method, RequestParams params, TamberResponseHandler respHandler) {
		client.httpClient.get(client.apiUrl + "/" + object + "/" + method, params, respHandler);
	}

	public static void Post(Client client, String object, String method, RequestParams params, TamberResponseHandler respHandler) {
		client.httpClient.post(client.apiUrl + "/" + object + "/" + method, params, respHandler);
	}
}