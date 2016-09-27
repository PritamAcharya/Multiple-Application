package com.example.my.pritam;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tv=(TextView)findViewById(R.id.textView4);
        Bundle b=getIntent().getExtras();
        tv.setTextSize(30);
        tv.setTextColor(Color.GREEN);
        tv.setText("WELCOME  "+b.getString("uid"));
    }
}
