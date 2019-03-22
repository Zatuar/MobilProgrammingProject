package com.example.mobilprogrammingproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       police();
    }
    public void police(){
        TextView custom1 = findViewById(R.id.title);
        TextView custom2 = findViewById(R.id.press);
        setFont(custom1,"sevesbrg.ttf");
        setFont(custom2,"sevesbrg.ttf");
    }
    public void setFont(TextView textView, String fontName) {
        if(fontName != null){
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "font/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }
        }
    }
    public void start(View view){
        Intent randomIntent = new Intent(this, ListActivity.class);
        startActivity(randomIntent);
    }
}
