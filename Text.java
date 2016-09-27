package com.example.my.pritam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Bundle b=getIntent().getExtras();
    }
}
