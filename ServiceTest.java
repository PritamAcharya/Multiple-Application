package com.example.my.pritam;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Switch;

import static com.example.my.pritam.R.id.sts;

public class ServiceTest extends AppCompatActivity implements View.OnClickListener {
    Button b,b1;

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
        setContentView(R.layout.activity_service_test);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1002);

            }
        }
        else {

        }
        b = (Button) findViewById(R.id.ss);
        b1 = (Button) findViewById(sts);
        b.setOnClickListener(this);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(this,MyService.class);
        switch(v.getId())
        {
            case R.id.ss :
                startService(i);
                break;
            case R.id.sts :
                stopService(i);
                break;
            default :
        }

    }
}
