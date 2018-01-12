package com.tamber;

import android.os.Handler;
import android.os.Looper;

import com.tamber.exception.TamberException;
import com.tamber.net.TamberResponseHandler;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BehaviorTest {
	public static void create(Tamber tamber, Looper looper) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "mention");
		params.put("desirability", 0.6);

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.behavior.create(params, new TamberResponseHandler() {
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
		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.behavior.retrieve("mention", new TamberResponseHandler() {
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
