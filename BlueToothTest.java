package com.example.my.pritam;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlueToothTest extends AppCompatActivity {
    BluetoothAdapter ba;
    BluetoothDevice bd;
    Switch sw;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth_test);
        ba=BluetoothAdapter.getDefaultAdapter();
        lv=(ListView)findViewById(R.id.listView2);
        sw=(Switch)findViewById(R.id.sw);
        if(ba==null)
        {
            Toast.makeText(BlueToothTest.this, "OLD PHONE", Toast.LENGTH_SHORT).show();
        }
        else
        {
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        if(!ba.isEnabled())
                        {
                         Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivity(i);
                            Toast.makeText(BlueToothTest.this, "Turning on..", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        ba.disable();
                    }
                }
            });
        }
        Set<BluetoothDevice> s=ba.getBondedDevices();
        List<String>l=new ArrayList<String>();
                for(BluetoothDevice b1:s)
                {
                    l.add(b1.getName()+"||"+b1.getAddress());
                }
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,l);
        lv.setAdapter(adapter);
    }
}
