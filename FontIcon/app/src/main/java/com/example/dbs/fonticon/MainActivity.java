package com.example.dbs.fonticon;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv1);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/digibank.ttf");
        textView.setTypeface(typeface);
    }
}
