package com.example.my.pritam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Galary extends AppCompatActivity {
    Button e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galary);
        e=(Button)findViewById(R.id.button);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Galary.this,Gal.class);
                startActivity(i);

            }
        });
        Bundle b=getIntent().getExtras();
    }
}
