package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerFromJava extends AppCompatActivity {
    Spinner sp;
    String []ar={"SELECT COUNTRY","INDIA","CHINA","USA","RUSIA","INDONASIA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_from_java);
        sp=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,ar);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            if (position==0)
            {
            }
             else
            {
                Toast.makeText(SpinnerFromJava.this, "You Have Selected "+sp.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
