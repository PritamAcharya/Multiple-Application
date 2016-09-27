package com.example.my.pritam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Gal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gal);
        Bundle b=getIntent().getExtras();
    }
}
