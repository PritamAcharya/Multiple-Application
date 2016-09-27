package com.example.my.pritam;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by my on 7/5/2016.
 */

public class MyService extends Service implements MediaPlayer.OnCompletionListener {
    MediaPlayer mp;

    @Override
    public void onCreate() {
        mp=MediaPlayer.create(this,R.raw.song);
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mp.isPlaying())
        mp.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        stopSelf();
    }




    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.stop();
        stopSelf();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
