package com.example.my.pritam;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SensorTest extends AppCompatActivity {
    TextView tv;
    SensorManager sm;
    Sensor s;
    SensorEventListener se=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];
            tv.setTextSize(30);
            tv.setTextColor(Color.RED);
            tv.setText("Azimuth : "+x+"\n Pitch : "+y+"\n Roll : "+z);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        tv=(TextView)findViewById(R.id.textView6);
        sm.registerListener(se,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
