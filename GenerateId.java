package com.example.my.pritam;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.content.Context;

/**
 * Created by my on 7/7/2016.
 */
public class GenerateId extends AppCompatActivity {


    String imeistring = null;
    String imsistring = null;


    {
        TelephonyManager telephonyManager;

        telephonyManager =
                (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

    /*
     * getDeviceId() function Returns the unique device ID.
     * for example,the IMEI for GSM and the MEID or ESN for CDMA phones.
     */
        imeistring = telephonyManager.getDeviceId();

   /*
    * getSubscriberId() function Returns the unique subscriber ID,
  * for example, the IMSI for a GSM phone.
  */
        imsistring = telephonyManager.getSubscriberId();
    }
}


