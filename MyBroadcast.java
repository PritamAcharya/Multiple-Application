package com.example.my.pritam;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import static android.telephony.TelephonyManager.EXTRA_INCOMING_NUMBER;

/**
 * Created by my on 7/4/2016.
 */
public class MyBroadcast extends BroadcastReceiver{
    Notification.Builder nb;
    NotificationManager nm;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        if(bundle!=null)
        {
            String status=bundle.getString(TelephonyManager.EXTRA_STATE);
            if(status.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                nm=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
                nb=new Notification.Builder(context);
                nb.setContentTitle("CALL").setContentText("YOU HAVE").setSmallIcon(android.R.drawable.sym_call_incoming).setContentInfo("YOU HAVE INCOMING CALL FROM"+bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER));
                Intent i=new Intent(context,MenuActivity.class);
                TaskStackBuilder tsb=TaskStackBuilder.create(context);
                tsb.addNextIntent(i);
                PendingIntent pi=tsb.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                nm.notify(0,nb.build());
                Toast.makeText(context,"Have Incoming"+bundle.getString(EXTRA_INCOMING_NUMBER),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
