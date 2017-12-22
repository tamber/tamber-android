# Tamber Android Bindings

You can sign up for a Tamber account at https://tamber.com.

This library is in development and untested, and provided with no guarantees at this time. Use at your own risk.

Requirements
============

Java 1.7 and later.

Installation
============

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

```repositories {
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

Usage
=====

All requests are asynchronous, you can access the response/error by supplying a TamberResponseHandler with an `onCompletion(JSONObject response, TamberException err)` function

Example.java

```java
import com.tamber.Tamber;
import com.tamber.exception.TamberException;
import com.tamber.types.TamberEvent;
import com.tamber.types.TamberGetRecs;
import com.tamber.net.TamberResponseHandler;

import java.org.JSONObject;
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

        //Set get_recs to return fresh suggestions for the user [Optional]
        TamberGetRecs get_recs = new TamberGetRecs();

        final CountDownLatch lock = new CountDownLatch(1);
        tamber.event.track(event, get_recs, new TamberResponseHandler() {
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
        // continue onward
    }
}
```
