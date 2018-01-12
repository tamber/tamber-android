package com.tamber;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.tamber.exception.TamberException;
import com.tamber.net.TamberResponseHandler;
import com.tamber.types.TamberEvent;
import com.tamber.types.TamberGetRecs;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class EventTest {
	public static void track(Tamber tamber, Looper looper) {
		TamberEvent event = new TamberEvent();
		event.user = "user_jctzgisbru";
		event.item = "item_i5gq90scc1";
		event.behavior = "mention";

		TamberGetRecs get_recs = new TamberGetRecs();

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.event.track(event, get_recs, new TamberResponseHandler() {
					@Override
					public final void onCompletion(JSONObject response, TamberException err) {
						if (err != null) {
							Log.d("Event Track", err.toString());
						}
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
		HashMap<String, Object> eventParams = new HashMap<String, Object>();
		eventParams.put("created_before", 1454465400);
		eventParams.put("created_since", 708652800);
		eventParams.put("number", 300);

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.event.retrieve(eventParams, new TamberResponseHandler() {
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

	public static void batch(Tamber tamber, Looper looper) {
		HashMap<String, Object> eventParams = new HashMap<String, Object>();

		List<HashMap<String, Object>> events = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> e1 = new HashMap<String, Object>();
		e1.put("user", "user_jctzgisbru");
		e1.put("behavior", "mention");
		e1.put("item", "item_u9nlytt3w5");
		e1.put("value", 1.0);
		e1.put("created", 1454465800);
		events.add(e1);
		HashMap<String, Object> e2 = new HashMap<String, Object>();
		e2.put("user", "user_y7u9sv6we0");
		e2.put("behavior", "mention");
		e2.put("item", "item_u9nlytt3w5");
		e2.put("value", 1.0);
		e2.put("created", 1454465400);
		events.add(e2);
		HashMap<String, Object> e3 = new HashMap<String, Object>();
		e3.put("user", "user_jctzgisbru");
		e3.put("behavior", "mention");
		e3.put("item", "item_d1zevdf6hl");
		e3.put("value", 1.0);
		e3.put("created", 1408652800);
		events.add(e3);

		eventParams.put("events", events);

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.event.batch(eventParams, new TamberResponseHandler() {
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
