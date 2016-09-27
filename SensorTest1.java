package com.example.my.pritam;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorTest1 extends AppCompatActivity {
    SensorManager sm;
    Sensor s;
    String data;
    List<Sensor> l;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test1);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        tv=(TextView)findViewById(R.id.tv);
        l=sm.getSensorList(Sensor.TYPE_ALL);
        for(Sensor s1:l)
        {
            data+= s1.getName()+"||"+s1.getType()+"||"+s1.getVendor()+"\n";
        }
        tv.setText(data);
    }
}
