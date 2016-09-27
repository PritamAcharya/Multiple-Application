package com.example.my.pritam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContentProviderTest extends AppCompatActivity {

    List<String> l=new ArrayList<String>();
    ListView lv;
    Cursor c;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 1002:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
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
        setContentView(R.layout.activity_content_provider_test);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_CONTACTS))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1002);
            }
        }
        else
        {

        }


        lv=(ListView)findViewById(R.id.listView2);
        c=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null, ContactsContract.PhoneLookup.DISPLAY_NAME);
        while(c.moveToNext())
        {
            int i=c.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
            int j=c.getColumnIndex(ContactsContract.PhoneLookup.TIMES_CONTACTED);
            l.add(c.getString(i)+"||"+c.getString(j));
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,l);
        lv.setAdapter(adapter);

    }
}
