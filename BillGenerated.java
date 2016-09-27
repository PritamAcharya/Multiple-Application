package com.example.my.pritam;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BillGenerated extends AppCompatActivity {
    EditText r1,r2,r3,r4;
    TextView tv;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_generated);
        b=(Button)findViewById(R.id.bill);
        r1=(EditText)findViewById(R.id.num);
        r2=(EditText)findViewById(R.id.num1);
        r3=(EditText)findViewById(R.id.num2);
        r4=(EditText)findViewById(R.id.num3);
        tv=(TextView)findViewById(R.id.textView5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=r1.getText().toString();
                String b=r2.getText().toString();
                String c =r3.getText().toString();
                String d=r4.getText().toString();
                String r5=a+b+c+d;
               if (a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty())
               {
                   tv.setText("PROVIDE VALUE");
                   tv.setTextSize(30);
                   tv.setTextColor(Color.RED);

               }
                else
               {
                   Intent i = new Intent(BillGenerated.this,Result.class);
                   i.putExtra("r1",a);
                   i.putExtra("r2",b);
                   i.putExtra("r3",c);
                   i.putExtra("r4",d);
                   startActivity(i);

               }
            }
        });
    }
}
