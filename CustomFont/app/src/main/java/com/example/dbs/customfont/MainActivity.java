package com.example.dbs.customfont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    TextView tv1,tv2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView)findViewById(R.id.textView3);
        tv2=(TextView)findViewById(R.id.textView4);

        Typeface face= Typeface.createFromAsset(getAssets(), "font/font.ttf");
        tv1.setTypeface(face);

        Typeface face1= Typeface.createFromAsset(getAssets(), "font/font1.ttf");
        tv2.setTypeface(face1);
    }
}