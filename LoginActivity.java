package com.example.my.pritam;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText uid,pass;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button)findViewById(R.id.bill);
        uid=(EditText)findViewById(R.id.uid);
        pass=(EditText)findViewById(R.id.pass);
        tv=(TextView)findViewById(R.id.textView3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String u=uid.getText().toString();
            String p=pass.getText().toString();
                if (u.isEmpty()||p.isEmpty())
                {
                    tv.setText("PROVIDE VALUE");
                    tv.setTextSize(30);
                    tv.setTextColor(Color.RED);
                }
                else
                {
                    if (u.equals(p))
                    {
                        Intent i=new Intent(LoginActivity.this,Welcome.class);
                        i.putExtra("uid",u);
                        startActivity(i);

                    }
                    else {
                        tv.setText("LOGIN FAILED");
                        tv.setTextSize(30);
                        tv.setTextColor(Color.RED);
                    }
                }
            }
        });
    }
}
