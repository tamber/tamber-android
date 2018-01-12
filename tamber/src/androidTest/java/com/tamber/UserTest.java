package com.tamber;

import android.os.Handler;
import android.os.Looper;

import com.tamber.exception.TamberException;
import com.tamber.net.TamberResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UserTest {
	public static void create(Tamber tamber, Looper looper) {
		//Set id
		HashMap<String, Object> userParams = new HashMap<String, Object>();
		userParams.put("id", "user_fwu592pwmo");
		//Set metadata
		HashMap<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("city", "San Francisco, CA");
		metadata.put("name", "Rob Pike");
		userParams.put("metadata", metadata);
		//Set events
		List<HashMap<String, Object>> events = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> event = new HashMap<String, Object>();
		event.put("behavior", "mention");
		event.put("item", "item_u9nlytt3w5");
		event.put("value", 1.0);
		event.put("created", 1446417346);
		events.add(event);
		userParams.put("events", events);

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.user.create(userParams, new TamberResponseHandler() {
					@Override
					public final void onCompletion(JSONObject response, TamberException err) {
						assertNull("No error should be returned", err);
						lock.countDown();
					}
				});
			}
		});

		try {
			boolean completed = lock.await(10, TimeUnit.SECONDS);
			assertTrue("The request should not timeout", completed);
		} catch (InterruptedException e) {
			fail("Should not be interrupted");
		}
	}

	public static void update(Tamber tamber, Looper looper) {
		HashMap<String, Object> userParams = new HashMap<String, Object>();
		userParams.put("id", "user_fwu592pwmo");
		//Set metadata
		HashMap<String, Object> metadata = new HashMap<String, Object>();
		metadata.put("city", "Mountain View, CA");
		metadata.put("age", "55-65");
		metadata.put("name", "Rob Pike");
		userParams.put("metadata", metadata);

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.user.update(userParams, new TamberResponseHandler() {
					@Override
					public final void onCompletion(JSONObject response, TamberException err) {
						assertNull("No error should be returned", err);
						lock.countDown();
					}
				});
			}
		});

		try {
			boolean completed = lock.await(10, TimeUnit.SECONDS);
			assertTrue("The request should not timeout", completed);
		} catch (InterruptedException e) {
			fail("Should not be interrupted");
		}
	}

	public static void retrieve(Tamber tamber, Looper looper) {
		HashMap<String, Object> userParams = new HashMap<String, Object>();
		userParams.put("id", "user_fwu592pwmo");

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.user.retrieve(userParams, new TamberResponseHandler() {
					@Override
					public final void onCompletion(JSONObject response, TamberException err) {
						assertNull("No error should be returned", err);
						lock.countDown();
					}
				});
			}
		});

		try {
			boolean completed = lock.await(10, TimeUnit.SECONDS);
			assertTrue("The request should not timeout", completed);
		} catch (InterruptedException e) {
			fail("Should not be interrupted");
		}
	}
}
