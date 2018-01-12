package com.tamber;

import android.os.Handler;
import android.os.Looper;

import com.tamber.exception.TamberException;
import com.tamber.net.TamberResponseHandler;
import com.tamber.types.TamberItem;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ItemTest {
	public static void create(Tamber tamber, Looper looper) {
		TamberItem item = new TamberItem();
		item.id = "item_faa666arma";

		item.properties = new HashMap<String, Object>();
		item.properties.put("clothing_type", "pants");
		item.properties.put("stock", 90);
		item.properties.put("available_medium", true);
		item.properties.put("available_large", true);

		item.tags = new ArrayList<String>();
		item.tags.add("casual");
		item.tags.add("feminine");

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.item.create(item, new TamberResponseHandler() {
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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", "item_faa666arma");

		Map<String, Object> updates = new HashMap<String, Object>();

		Map<String, Object> add = new HashMap<String, Object>();
		Map<String, Object> addProperties = new HashMap<String, Object>();
		addProperties.put("available_large", false);
		addProperties.put("stock", 89);
		add.put("properties", addProperties);
		updates.put("add", add);

		Map<String, Object> remove = new HashMap<String, Object>();
		List<String> removeTags = new ArrayList<String>();
		removeTags.add("casual");
		remove.put("tags", removeTags);
		updates.put("remove", remove);

		params.put("updates", updates);

		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.item.update(params, new TamberResponseHandler() {
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
				tamber.item.retrieve("item_faa666arma", new TamberResponseHandler() {
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

	public static void hide(Tamber tamber, Looper looper) {
		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.item.hide("item_faa666arma", new TamberResponseHandler() {
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

	public static void unhide(Tamber tamber, Looper looper) {
		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.item.unhide("item_faa666arma", new TamberResponseHandler() {
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

	public static void delete(Tamber tamber, Looper looper) {
		final CountDownLatch lock = new CountDownLatch(1);
		new Handler(looper).post(new Runnable() {
			@Override
			public void run() {
				tamber.item.delete("item_faa666arma", new TamberResponseHandler() {
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
