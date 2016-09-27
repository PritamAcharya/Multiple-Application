package com.example.my.pritam;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SensorTest2 extends AppCompatActivity {
    ImageView iv;
    Sensor s;
    SensorManager sm;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            if(x==0)
            {
                iv.setImageResource(R.drawable.music);
            }
            else
            {
                iv.setImageResource(R.drawable.music1);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test2);
        iv=(ImageView)findViewById(R.id.imageView3);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
     sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
