package com.andr0day.clickjack;

import android.app.Application;

/**
 * Created by andr0day on 2015/6/4.
 */
public class MyApplication extends Application {

    public static Application application;

    public void onCreate() {
        application = this;
    }
}
