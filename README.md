# Tamber Android Bindings

You can sign up for a Tamber account at https://tamber.com.

This library is in development and untested, and provided with no guarantees at this time. Use at your own risk.

Requirements
============

Java 1.7 and later.

Installation
============

### Manual

Install the following JARs:

* The Tamber JAR from https://github.com/tamber/tamber-android/tree/master/builds
* [JSON Simple](https://code.google.com/p/json-simple/) from <http://json-simple.googlecode.com/files/json-simple-1.1.1.jar>
* [Android Async HTTP](http://loopj.com/android-async-http/)

Usage
=====

All requests are asynchronous, you can access the response/error by supplying a response handler: [JsonHttpResponseHandler](https://loopj.com/android-async-http/doc/com/loopj/android/http/JsonHttpResponseHandler.html). In the future this will be replaced with a Tamber-specific response handler class that will be easier to use.

Example.java

```java
import com.tamber.Tamber;
import com.tamber.exception.TamberException;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TamberExample {

    public static void main(String[] args) {
        
        Tamber tamber = new Tamber("your_project_key", "your_engine_key");

        //Create Event
        HashMap<String,Object> eventParams = new HashMap<String,Object>();
        eventParams.put("user", "user_rlox8k927z7p");
        eventParams.put("item", "item_wmt4fn6o4zlk");
        eventParams.put("behavior", "like");

        //Set get_recs to return fresh suggestions for the user [Optional]
        eventParams.put("get_recs", new HashMap<String,Object>());

        tamber.event.track(eventParams, null);
    }
}
```
