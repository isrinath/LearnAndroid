package com.example.dbs.screenshotshare;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detectScreenShotService(this);
    }

    public void detectScreenShotService(final Activity activity) {

        final Handler h = new Handler();
        final int delay = 3000; //milliseconds
        final ActivityManager am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);

        h.postDelayed(new Runnable() {
            public void run() {

                List<ActivityManager.RunningServiceInfo> rs = am.getRunningServices(200);

                for (ActivityManager.RunningServiceInfo ar : rs) {
                    if (ar.process.equals("com.android.systemui:screenshot")) {
                        Toast.makeText(activity, "Screenshot captured!!", Toast.LENGTH_LONG).show();
                    }
                }
                h.postDelayed(this, delay);
            }
        }, delay);
    }

}
