package com.example.my.pritam;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import android.Manifest;

public class FileTest extends AppCompatActivity {
File f;
FileInputStream fis;
    FileOutputStream fos;
    EditText fname,fdata;

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
        setContentView(R.layout.activity_file_test);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1002);

            }
        }
        else {

        }
        fname=(EditText)findViewById(R.id.editText2);
        fdata=(EditText)findViewById(R.id.editText3);
        File f1= Environment.getExternalStorageDirectory();
        f=new File(f1,"stpdelhi");
        if(!f.exists())
        {
            f.mkdir();
            Toast.makeText(FileTest.this, "Folder Created", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(FileTest.this, "Folder Already Exists", Toast.LENGTH_SHORT).show();
        }
    }
    public void cfile(View v)
    {
        String f2=fname.getText().toString().trim();
        try{
            File f3=new File(f,f2+".txt");
            if(!f3.exists())
            {
                f3.createNewFile();
                Toast.makeText(FileTest.this, "File Created", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(FileTest.this, "File Exists", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(FileTest.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void adata(View v)
    {
        try{
            String name=fname.getText().toString().trim();
            String data=fdata.getText().toString().trim();
            fos=new FileOutputStream(f.getAbsolutePath()+File.separator+name+".txt",true);
            fos.write(data.getBytes());
            Toast.makeText(FileTest.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {

        }
    }
    public void sdata(View v)
    {
        try {
            String name=fname.getText().toString().trim();
            fdata.setText("");
            fis= new FileInputStream(f.getAbsolutePath()+File.separator+name+".txt");
            String filedata="";
            int i;
            while ((i=fis.read())>-1)
            {
                filedata+=(char)i;
            }
            fdata.setText(filedata);
        }
        catch (Exception e)
        {
            Toast.makeText(FileTest.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
