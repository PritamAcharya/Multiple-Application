package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    Button add;
    EditText NUM1, NUM2;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        NUM1 = (EditText) findViewById(R.id.num1);
        NUM2 = (EditText) findViewById(R.id.num2);
        add = (Button) findViewById(R.id.add);
        ans=(TextView)findViewById(R.id.ans);

        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        float a=Float.parseFloat(NUM1.getText().toString().trim());
        float b=Float.parseFloat(NUM2.getText().toString().trim());
        float c=a+b;
        ans.setText("SUM : "+c);

    }
}
