package com.example.my.pritam;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class WiFiTest extends AppCompatActivity {

    WifiInfo wifiInfo;
    WifiManager wm;
    List<ScanResult> l;
    BroadcastReceiver br;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 1002:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {

                }
                else
                {

                }
                return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_test);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_COARSE_LOCATION))
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


        wm=(WifiManager)getSystemService(Context.WIFI_SERVICE);
        if(wm!=null)
        {
            if(!wm.isWifiEnabled())
            {
                wm.setWifiEnabled(true);
                wm.startScan();
            }
            else{
                wm.startScan();
            }
        }
        else{
            Toast.makeText(WiFiTest.this, "Too Old Phone", Toast.LENGTH_SHORT).show();
        }

        br=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if(action.equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
                {
                    l=wm.getScanResults();
                }
                for(ScanResult s1:l)
                {
                    Toast.makeText(WiFiTest.this, s1.BSSID+"||"+s1.SSID+"||"+s1.level, Toast.LENGTH_SHORT).show();
                }
            }
        };
        IntentFilter ifr=new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(br,ifr);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}
