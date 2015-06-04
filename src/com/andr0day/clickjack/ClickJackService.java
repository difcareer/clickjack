package com.andr0day.clickjack;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;

/**
 * Created by andr0day on 2015/6/4.
 */
public class ClickJackService extends Service {

    Timer timer;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new MyTimerTask(), 0, 800);
    }
}
