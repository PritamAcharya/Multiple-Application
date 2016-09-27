package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1=(TextView)findViewById(R.id.tv1);
        t2=(TextView)findViewById(R.id.tv2);
        t3=(TextView)findViewById(R.id.tv3);
        t4=(TextView)findViewById(R.id.tv4);
        t5=(TextView)findViewById(R.id.textView10);
        Bundle b=getIntent().getExtras();
        float a=Float.parseFloat(b.getString("r1"));
        float b1=Float.parseFloat(b.getString("r2"));
        float c=Float.parseFloat(b.getString("r3"));
        float d=Float.parseFloat(b.getString("r4"));
        float l=a*100;
        float j=b1*100;
        float k=c*100;
        float m=d*100;
        float n=(l+j+k+m);

        t1.setText("Qty of Clothes "+b.getString("r1")+"Price "+b.getString("l"));
        t2.setText("Qty of Food "+b.getString("r2")+"Price "+b.getString("j"));
        t3.setText("Qty of Furniture "+b.getString("r3")+"Price "+b.getString("k"));
        t4.setText("Qty of Items "+b.getString("r4")+"Price "+b.getString("m"));
        t5.setText("Total "+b.getString("n"));

    }
}
