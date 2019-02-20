package com.example.user.ramiarram;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // If the event for which the broadcast receiver has registered happens,  the onReceiver()
        // method of the receiver is called by the Android system.
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent intent1 = new Intent(context, MyIntentService.class);
        context.startService(intent1);
     }
}
