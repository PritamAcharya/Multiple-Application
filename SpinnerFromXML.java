package com.example.my.pritam;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class SpinnerFromXML extends AppCompatActivity {
    Spinner sp;
    RelativeLayout r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_from_xml);
        sp=(Spinner)findViewById(R.id.sp);
        r1=(RelativeLayout)findViewById(R.id.r1);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (sp.getSelectedItem().toString().equals("SELECT COLOR"))
                {

                }
                else if (sp.getSelectedItem().toString().equals("RED"))
                {
                    r1.setBackgroundColor(Color.RED);
                }

                else if (sp.getSelectedItem().toString().equals("GREEN"))
                {
                    r1.setBackgroundColor(Color.GREEN);
                }
                else if (sp.getSelectedItem().toString().equals("BLUE"))
                {
                    r1.setBackgroundColor(Color.BLUE);
                }
                else if (sp.getSelectedItem().toString().equals("MAGENTA"))
                {
                    r1.setBackgroundColor(Color.MAGENTA);
                }
                else {
                    r1.setBackgroundColor(Color.GRAY);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
