package com.tamber;

import android.os.HandlerThread;
import android.os.Looper;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TamberTest {
	private static Tamber tamber;
	private static Looper looper;
	//CountingIdlingResource idlingResource = new CountingIdlingResource("Network_Call");

	//@Rule
	//public ActivityTestRule<LoadingActivity> mActivityTestRule = new ActivityTestRule<>(LoadingActivity.class);

	@Before
	public void setUp() throws Exception {
		tamber = new Tamber("Mu6DUPXdDYe98cv5JIfX", "SbWYPBNdARfIDa0IIO9L");
		HandlerThread handlerThread = new HandlerThread("TamberTest");
		handlerThread.start();
		looper = handlerThread.getLooper();
	}

	@Test
	public void testApp() throws Exception {
		runEventTests();
		runUserTests();
		runItemTests();
		runBehaviorTests();
		runDiscoverTests();
	}

	public void runEventTests() {
		EventTest.track(tamber, looper);
		EventTest.retrieve(tamber, looper);
		EventTest.batch(tamber, looper);
	}

	public void runUserTests() {
		UserTest.create(tamber, looper);
		UserTest.update(tamber, looper);
		UserTest.retrieve(tamber, looper);
	}

	public void runItemTests() {
		ItemTest.create(tamber, looper);
		ItemTest.update(tamber, looper);
		ItemTest.retrieve(tamber, looper);
		ItemTest.hide(tamber, looper);
		ItemTest.unhide(tamber, looper);
		ItemTest.delete(tamber, looper);
	}

	public void runBehaviorTests() {
		BehaviorTest.create(tamber, looper);
		BehaviorTest.retrieve(tamber, looper);
	}

	public void runDiscoverTests() {
		DiscoverTest.recommended(tamber, looper);
		DiscoverTest.similar(tamber, looper);
		DiscoverTest.recommendedSimilar(tamber, looper);
		DiscoverTest.popular(tamber, looper);
		DiscoverTest.hot(tamber, looper);
	}
}