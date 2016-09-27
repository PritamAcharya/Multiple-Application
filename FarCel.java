package com.example.my.pritam;

import android.location.GpsStatus;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FarCel extends AppCompatActivity {
    Button clear;
    EditText num;
    TextView ans;
    RadioButton r1,r2;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_far_cel);
        r1=(RadioButton)findViewById(R.id.celsius);
        r2=(RadioButton)findViewById(R.id.fareh);
        num = (EditText) findViewById(R.id.num);
        rg=(RadioGroup)findViewById(R.id.rg);
        clear = (Button) findViewById(R.id.clear);
        ans=(TextView)findViewById(R.id.ans);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans.setText(" ");

            }
        });
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton r=(RadioButton)v;
                float a=Float.parseFloat(num.getText().toString().trim());
                switch (v.getId())
                {
                    case R.id.celsius: float b=(5*(a-32))/9;
                        ans.setText("Celsius is "+b);
                        break;
                    case R.id.fareh :float c=(9*a/5+32);
                        ans.setText("Farehenite is "+c);
                        break;
                    default:
                        ans.setText("Kindly,Provide the Value...");
                        break;
                }


            }
        };
            r1.setOnClickListener(listener);
            r2.setOnClickListener(listener);

    }
}
