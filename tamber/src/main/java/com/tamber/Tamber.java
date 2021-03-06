package com.tamber;

import com.tamber.net.Client;
import com.tamber.object.Behavior;
import com.tamber.object.Discover;
import com.tamber.object.Event;
import com.tamber.object.Item;
import com.tamber.object.User;

public class Tamber {
	public static final String API_URL = "https://api.tamber.com/v1";
	public static String CLIENT_VERSION = "0.1.5";
	private int httpSocketTimeoutMS = 30000;
    private int httpConnectTimeoutMS = 80000;

	private static Client client;

	public final Event event;
	public final Discover discover;
	public final User user;
	public final Item item;
	public final Behavior behavior;
	

	public Tamber(String projectKey, String engineKey) {
		client = new Client(API_URL, projectKey, engineKey, "", CLIENT_VERSION, httpSocketTimeoutMS, httpConnectTimeoutMS);
		event = new Event(client);
		discover = new Discover(client);
		user = new User(client);
		item = new Item(client);
		behavior = new Behavior(client);
	}

	public Tamber(String projectKey) {
		client = new Client(API_URL, projectKey, "", "", CLIENT_VERSION, httpSocketTimeoutMS, httpConnectTimeoutMS);
		event = new Event(client);
		discover = new Discover(client);
		user = new User(client);
		item = new Item(client);
		behavior = new Behavior(client);
	}

	public void setApiVersion(String apiVersion) {
		client.setApiVersion(apiVersion);
	}

	public void setTimeout(int connectTimeout, int readTimeout) {
		this.httpSocketTimeoutMS = readTimeout;
		this.httpConnectTimeoutMS = connectTimeout;
		if (client != null) {
			client.httpSocketTimeoutMS = readTimeout;
        	client.httpConnectTimeoutMS = connectTimeout;
		}
    }

	public void setUser(String user) {
		this.event.setUser(user);
		this.discover.setUser(user);
		this.user.setUser(user);
	}
}
