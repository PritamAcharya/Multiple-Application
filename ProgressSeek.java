package com.example.my.pritam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class ProgressSeek extends AppCompatActivity {
    ProgressBar pb;
    SeekBar sb;
    TextView tv;
    Thread th;
    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_seek);
        sb=(SeekBar)findViewById(R.id.sb);
        tv=(TextView)findViewById(R.id.sbd);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText("Progress "+progress);
                pb.setProgress(progress);
               // pb.setProgress(progress);
                //th.start();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }



        });
        pb=(ProgressBar)findViewById(R.id.pb);
        start=(Button)findViewById(R.id.pbb);
        start.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         th = new Thread() {
                                             public void run() {
                                                 try {
                                                     for (int i = 0; i < 30; i++) {
                                                         pb.setProgress(i * 4);
                                                         sleep(500);
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
