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

public class DiscoverTest {
	public static void recommended(Tamber tamber, Looper looper) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", "user_jctzgisbru");

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.discover.recommended(params, new TamberResponseHandler() {
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

	public static void similar(Tamber tamber, Looper looper) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("item", "item_i5gq90scc1");

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.discover.similar(params, new TamberResponseHandler() {
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

	public static void recommendedSimilar(Tamber tamber, Looper looper) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", "user_jctzgisbru");
		params.put("item", "item_i5gq90scc1");

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.discover.recommendedSimilar(params, new TamberResponseHandler() {
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

	public static void popular(Tamber tamber, Looper looper) {
		Map<String, Object> params = new HashMap<String, Object>();

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.discover.popular(params, new TamberResponseHandler() {
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

	public static void hot(Tamber tamber, Looper looper) {
		Map<String, Object> params = new HashMap<String, Object>();

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.discover.hot(params, new TamberResponseHandler() {
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
