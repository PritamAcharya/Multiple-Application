package com.example.my.pritam;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDialogTest extends AppCompatActivity {
    AlertDialog.Builder adb;
    AlertDialog a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_test);


}
    public void alert(View v) {
        adb = new AlertDialog.Builder(this);
        adb.setMessage("ARE YOU SURE");
        adb.setTitle("ARE YOU SURE");
        adb.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogTest.this, "YOU SELECTED YES", Toast.LENGTH_LONG).show();
            }
        });
        adb.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogTest.this, "YOU SELECTED NO", Toast.LENGTH_LONG).show();
            }
        });
        a = adb.create();
        a.show();

    }
}
