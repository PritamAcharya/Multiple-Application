package com.example.my.pritam;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

class Music extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener,MediaPlayer.OnCompletionListener {
    ImageButton play;
    SeekBar seekBar;
    Thread progress;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        seekBar = (SeekBar)findViewById(R.id.seekBar);

        play = (ImageButton) findViewById(R.id.imageButton4);
        mp = MediaPlayer.create(this,R.raw.ss);
        seekBar.setMax(mp.getDuration());
        seekBar.setOnSeekBarChangeListener(this);
        play.setOnClickListener(this);
        Bundle b=getIntent().getExtras();


        progress=new Thread(){
            public void run(){
                while (mp.getDuration()!=mp.getCurrentPosition())
                {
                    seekBar.setProgress(mp.getCurrentPosition());
                }
            }
        };
        progress.start();
    }


    @Override
    public void onClick(View v) {
        if (!mp.isPlaying())
        {
            mp.start();
            play.setImageResource(android.R.drawable.ic_media_pause);
        }
        else
        {
            mp.pause();
            play.setImageResource(android.R.drawable.ic_media_play);

        }

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.ss);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser)
        {
            mp.seekTo(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
