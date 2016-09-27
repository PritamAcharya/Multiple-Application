package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioButtonTest extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    RadioGroup rg;
    Button clear;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_test);
        r1=(RadioButton)findViewById(R.id.rb1);
        r2=(RadioButton)findViewById(R.id.rb2);
        r3=(RadioButton)findViewById(R.id.rb3);
        r4=(RadioButton)findViewById(R.id.rb1);
        rg=(RadioGroup)findViewById(R.id.rg);
        clear=(Button)findViewById(R.id.clear);
        tv=(TextView)findViewById(R.id.tv);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                tv.setText(" ");
            }
        });
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton r=(RadioButton)v;
                tv.setText("You Have Selected "+r.getText().toString());
            }
        };
        r1.setOnClickListener(listener);
        r2.setOnClickListener(listener);
        r3.setOnClickListener(listener);
        r4.setOnClickListener(listener);
    }
}
