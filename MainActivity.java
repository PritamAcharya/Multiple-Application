package com.example.my.pritam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=(ImageButton)findViewById(R.id.imageButton);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Text.class);
                startActivity(i);

            }
        });


        b=(ImageButton) findViewById(R.id.imageButton2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Music.class);
                startActivity(i);

            }
        });


        c=(ImageButton) findViewById(R.id.imageButton3);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Galary.class);
                startActivity(i);

            }
        });




    }



    @Override
    public void onClick(View v) {
        b.setOnClickListener(this);
        Intent i=new Intent(MainActivity.this,Text.class);
        startActivity(i);

    }
}
