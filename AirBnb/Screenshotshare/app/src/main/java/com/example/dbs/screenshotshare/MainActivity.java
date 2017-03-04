package com.example.dbs.screenshotshare;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import static com.example.dbs.screenshotshare.MainActivity.ScreenShotUtil.getScreenShot;

public class MainActivity extends AppCompatActivity {
    private Context context;
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


    /**
     * Created by dbs on 4/3/17.
     */

    public static class ScreenShotUtil {
        public static Bitmap getScreenShot(View view) {
            View screenView = view.getRootView();
            if(screenView != null){
                screenView.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
                screenView.setDrawingCacheEnabled(false);
                return bitmap;
            }else{
                return null;
            }

        }

        public static void store(Bitmap bm, String fileName){
            final String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Screenshots";
            File dir = new File(dirPath);
            if(!dir.exists())
                dir.mkdirs();
            File file = new File(dirPath, fileName);
            try {
                FileOutputStream fOut = new FileOutputStream(file);
                bm.compress(Bitmap.CompressFormat.PNG, 85, fOut);
                fOut.flush();
                fOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
