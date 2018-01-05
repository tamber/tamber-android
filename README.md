# Tamber Android SDK

Recommendation engines for developers, easy as π. Build blazing fast, head-scratchingly accurate hosted recommendation engines in minutes.

The Tamber iOS SDK makes it easy to track events (user-item interactions) and get recommendations for your users inside your iOS app. 

[Get a free api key][homepage] to get started.

This library is in development and untested, and provided with no guarantees at this time. Use at your own risk.

# Requirements

Java 1.7 and later.

# Installation

### Maven

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.tamber</groupId>
  <artifactId>tamber-android</artifactId>
  <version>0.1.4</version>
</dependency>
```

### Gradle

```java
repositories {
  mavenCentral()
}

dependencies {
  compile 'com.tamber:tamber-android:0.1.4'
}```

### Manual

Install the following JARs:

* The Tamber JAR from https://github.com/tamber/tamber-android/tree/master/builds
* [JSON Simple](https://code.google.com/p/json-simple/) from <http://json-simple.googlecode.com/files/json-simple-1.1.1.jar>
* [Android Async HTTP](http://loopj.com/android-async-http/)

# Usage

All requests are asynchronous, you can access the response/error by supplying a TamberResponseHandler with an `onCompletion(JSONObject response, TamberException err)` function

## Track Events

```java
import com.tamber.Tamber;
import com.tamber.exception.TamberException;
import com.tamber.types.TamberEvent;
import com.tamber.net.TamberResponseHandler;

import org.json.JSONObject;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TamberExample {

    public static void main(String[] args) {
        
        Tamber tamber = new Tamber("your_project_key", "your_engine_key");

        //Create Event
        TamberEvent event = new TamberEvent();
        event.user = "user_rlox8k927z7p";
        event.item = "item_wmt4fn6o4zlk";
        event.behavior = "like";

        final CountDownLatch lock = new CountDownLatch(1);
        tamber.event.track(event, new TamberResponseHandler() {
            @Override
            public final void onCompletion(JSONObject response, TamberException err) {
                // do stuff
                lock.countDown();
            }
        });

        try {
            lock.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // handle error
        }
    }
}
```

## Get Recommendations

Once you have tracked some user events and created your engine, you are ready to put personalized recommendations in your app.

Often it is ideal to handle recommendation retrieval from the backend as part of normal page loading. If you would prefer to handle this in the backend, checkout our [other SDKs][sdks], including [Ruby][tamber-ruby], [golang][tamber-go], [python][tamber-python], and [Java][tamber-java].

`tamber-android` provides full support for loading recommendations directly from Tamber.

#### For You

Put personalized recommendations on your homepage, or in any recommended section, by calling `forYou` with the number of recommendations you want to display.

```js
// supply the exact number of items to be displayed
TamberDiscoverNextParams params = new TamberDiscoverNextParams();
params.user = "user_rlox8k927z7p";
params.number = 10;

final CountDownLatch lock = new CountDownLatch(1);
tamber.discover.next(params, new TamberResponseHandler() {
    @Override
    public final void onCompletion(JSONObject response, TamberException err) {
        // do stuff
        lock.countDown();
    }
});

try {
    lock.await(30, TimeUnit.SECONDS);
} catch (InterruptedException e) {
    // handle error
}
```

#### Up Next

Keep users engaged by creating a path of discovery as they navigate from item to item. Just add the id of the item that the user is navigating to / looking at and the number of items to display.

```js
// supply the exact number of items to be displayed
TamberDiscoverNextParams params = new TamberDiscoverNextParams();
params.user = "user_rlox8k927z7p";
params.item = new TamberItem(new JSONObject()
      .put("id", "item_wmt4fn6o4zlk")
      .put("properties", item.properties)
      .put("tags", item.tags));
params.number = 10;

final CountDownLatch lock = new CountDownLatch(1);
tamber.discover.next(params, new TamberResponseHandler() {
    @Override
    public final void onCompletion(JSONObject response, TamberException err) {
        // do stuff
        lock.countDown();
    }
});

try {
    lock.await(30, TimeUnit.SECONDS);
} catch (InterruptedException e) {
    // handle error
}
```

##### Infinite Scroll

`discover.next` is optimized for the exact moment and context of the user at the time of request, so standard pagination is not possible. Instead, `discover.next` uses automatic continuation to allow you to 'show more' or implement infinite scrolling. 

When you want to add more recommendations to those currently displayed to the user, just set the `continuation` field to `true`. Tamber will automatically generate the set of items that should be appended to the current user-session's list. The `discover.next` user-session is reset when `discover.next` is called without `continuation`.

```js
TamberDiscoverNextParams params = new TamberDiscoverNextParams();
params.user = "user_rlox8k927z7p";
params.item = new TamberItem(new JSONObject()
      .put("id", "item_wmt4fn6o4zlk")
      .put("properties", item.properties)
      .put("tags", item.tags));
params.number = 10;
params.continuation = true;

final CountDownLatch lock = new CountDownLatch(1);
tamber.discover.next(params, new TamberResponseHandler() {
    @Override
    public final void onCompletion(JSONObject response, TamberException err) {
        // do stuff
        lock.countDown();
    }
});

try {
    lock.await(30, TimeUnit.SECONDS);
} catch (InterruptedException e) {
    // handle error
}
```
