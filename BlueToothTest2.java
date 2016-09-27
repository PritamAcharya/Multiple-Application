package com.example.my.pritam;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BlueToothTest2 extends AppCompatActivity {
    BluetoothAdapter ba;
    BluetoothDevice bd;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode)
        {
            case 1002 : if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {

            }
            else {

            }
                return;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth_test2);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_COARSE_LOCATION))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1002);

            }
        }

        else
        {

        }

        ba=BluetoothAdapter.getDefaultAdapter();
        if(!ba.isEnabled())
        {
            Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(i);
            ba.startDiscovery();
        }
        else
        {
            Toast.makeText(BlueToothTest2.this, "START DISCOVERY...", Toast.LENGTH_SHORT).show();
            ba.startDiscovery();
        }
        BroadcastReceiver br=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if(BluetoothDevice.ACTION_FOUND.equals(action))
                {
                    BluetoothDevice bd=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    Toast.makeText(BlueToothTest2.this, bd.getName()+"||"+bd.getAddress(), Toast.LENGTH_SHORT).show();
                }
            }
        };
        IntentFilter ifr=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(br,ifr);
    }
}
