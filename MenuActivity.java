package com.example.my.pritam;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity {
    String menu[]={"FirstActivity","MapActivity2","ServiceTest","WiFiTest","ContentProviderTest","BlueToothTest2","BlueToothTest","SensorTest2","SensorTest1","CameraTest","DBTest","FileTest","PreferenceTest","SensorTest","MusicPlayer","AlertDialogTest","BillGenerated","LoginActivity","ContextTest","PopupTest","OptionMenuTest","SwitchTest","SpinnerFromJava","SpinnerFromXML","AutoCompleteTest","FarCel","RadioButtonTest","ProgressSeek","SeekBarTest","ProgressBarTest","CounterActivity","AddActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toast.makeText(MenuActivity.this, "OnCreate...", Toast.LENGTH_SHORT).show();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, menu);
        setListAdapter(adapter);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_PHONE_STATE))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},1002);

            }
        }
        else {

        }
    }
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
        protected void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            try {
                String s="com.example.my.pritam."+menu[position];
                Class c=Class.forName(s);
                Intent i=new Intent(this,c);
                startActivity(i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MenuActivity.this, "OnDestroy...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MenuActivity.this, "OnStart...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MenuActivity.this, "OnRestart...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MenuActivity.this, "OnPause...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MenuActivity.this, "OnStop...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MenuActivity.this, "OnResume", Toast.LENGTH_SHORT).show();
    }
}
