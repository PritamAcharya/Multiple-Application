package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity implements View.OnClickListener {
    Button i,d,r;
    TextView RESULT;
    static int COUNT=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        i=(Button)findViewById(R.id.INC);
        d=(Button)findViewById(R.id.DEC);
        r=(Button)findViewById(R.id.RES);
        RESULT=(TextView)findViewById(R.id.RESULT);
        i.setOnClickListener(this);
        d.setOnClickListener(this);
        r.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.INC :
                COUNT ++;
                RESULT.setText("COUNT : "+COUNT);
                break;
            case R.id.DEC :
                COUNT --;
                RESULT.setText("COUNT : "+COUNT);
                break;
            case R.id.RES :
                COUNT=0;
                RESULT.setText("COUNT : "+COUNT);
                break;
            default :
                break;
        }

    }
}
