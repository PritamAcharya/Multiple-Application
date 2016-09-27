package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarTest extends AppCompatActivity {
    ProgressBar pb;
    Button start;
    Thread th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_test);
        pb=(ProgressBar)findViewById(R.id.pb);
        start=(Button)findViewById(R.id.pbb);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                th=new Thread() {
                    public void run() {
                        try {
                            for (int i = 0; i < 30; i++) {
                                pb.setProgress(i * 4);
                                sleep(200);
                            }
                        } catch (Exception e) {

                        }


                    }
                };
                th.start();
            }
        });
    }
}
