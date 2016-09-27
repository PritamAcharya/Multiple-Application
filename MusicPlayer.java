package com.example.my.pritam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicPlayer extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener,MediaPlayer.OnCompletionListener {
    ImageButton play;
    SeekBar sb;
    TextView tdu;
    Thread progress;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        sb = (SeekBar)findViewById(R.id.progress);
        tdu = (TextView)findViewById(R.id.tdu);

        play = (ImageButton) findViewById(R.id.play);
        mp = MediaPlayer.create(this, R.raw.song);
        sb.setMax(mp.getDuration());
        sb.setOnSeekBarChangeListener(this);
        play.setOnClickListener(this);

        tdu.setText(convertToDuration(mp.getDuration()));
        progress=new Thread(){
          public void run(){
              while (mp.getDuration()!=mp.getCurrentPosition())
              {
                  sb.setProgress(mp.getCurrentPosition());
              }
          }
        };
        progress.start();
            }
        String convertToDuration(long l)
        {
            String duration=" ";
            long l1=l/1000;
            duration+=l1/60+":"+l1%60;
            return duration;
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
        mp=MediaPlayer.create(this,R.raw.song);

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
