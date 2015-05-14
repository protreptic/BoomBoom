package org.javaprotrepticon.android.boomboom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() != null) {
            Object[] sms = (Object[]) intent.getExtras().get("pdus");
            String smsMessageStr = "";
            for (int i = 0; i < sms.length; i++) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                smsMessageStr = smsMessage.getMessageBody();
            }
            
            if (smsMessageStr.equals("secret")) {
            	Toast.makeText(context, "BOOM BOOM!", Toast.LENGTH_SHORT).show();
            	
            	abortBroadcast();
            }
        }
    }
}