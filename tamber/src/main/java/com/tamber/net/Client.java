package com.tamber.net;

import com.loopj.android.http.AsyncHttpClient;

import org.apache.commons.codec.binary.Base64;

public class Client {
	public String projectKey;
	public String engineKey;
	public String apiVersion;
	public String clientVersion;
	public String apiUrl;
	public AsyncHttpClient httpClient;
	public int httpSocketTimeoutMS = 30000;
    public int httpConnectTimeoutMS = 80000;

	public Client(String url, String pkey, String ekey, String apiv, String clientv, int socketTimeout, int connectTimeout) {
		apiUrl = url;
		projectKey = pkey;
		engineKey = ekey;
		apiVersion = apiv;
		clientVersion = clientv;
		httpClient = new AsyncHttpClient();
		httpSocketTimeoutMS = socketTimeout;
		httpConnectTimeoutMS = connectTimeout;
		httpClient.setTimeout(httpSocketTimeoutMS);
		httpClient.setConnectTimeout(httpConnectTimeoutMS);

		if (apiVersion.length() > 0) {
			httpClient.addHeader("Tamber-Version", apiVersion);
		}
		httpClient.addHeader("User-Agent", "Tamber/v1 JavaBindings/"+clientVersion);
		httpClient.addHeader("Content-Type", "application/x-www-form-urlencoded");
		String auth = new String(Base64.encodeBase64((projectKey+":"+engineKey).getBytes()));
		httpClient.addHeader("Authorization", "Basic "+auth);
	}

	public void setApiVersion(String apiVersion) {
		if (this.apiVersion.length() > 0) {
			httpClient.removeHeader("Tamber-Version");
		}
		if (apiVersion.length() > 0) {
			httpClient.addHeader("Tamber-Version", apiVersion);
		}
		this.apiVersion = apiVersion;
	}
}