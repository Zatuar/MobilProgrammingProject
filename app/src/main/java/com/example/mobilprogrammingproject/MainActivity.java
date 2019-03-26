package com.example.mobilprogrammingproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    SensorManager sm;

    private float acelVal;
    private float acelLast;
    private float shake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        police();
        Shake();
    }

    private void Shake() {
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 12) {
                ThisIsSparta();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    };

    private void ThisIsSparta() {
        final boolean[] loaded = {false};
        final int explosionId;
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        AssetManager assetManager = getAssets();
        AssetFileDescriptor descriptor;
        try {
            descriptor = assetManager.openFd("ThisIsSparta.mp3");
            explosionId = soundPool.load(descriptor, 1);

            soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                public void onLoadComplete(SoundPool soundPool, int sampleId,int status) {
                    loaded[0] = true;
                    soundPool.play(explosionId, 1, 1, 0, 0, 1);
                }
            });
        } catch (IOException e) { e.printStackTrace();}
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
