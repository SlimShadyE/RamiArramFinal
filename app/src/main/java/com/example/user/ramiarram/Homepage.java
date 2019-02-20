package com.example.user.ramiarram;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
    Button driver, psngr, profile;
    private  static  final int NOTIFICATION_REMINDER_NIGHT = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //and then in your activity set the alarm manger to start the broadcast receiver at a specific time and use AlarmManager setRepeating method to repeat it this example bellow will repeat it every day.
        Intent notifyIntent = new Intent(this,MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),1000 * 60 * 60 * 24, pendingIntent);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
         driver = (Button) findViewById(R.id.driver);
         psngr = (Button) findViewById(R.id.psngr2);
         profile = (Button) findViewById(R.id.profile);

        driver.setOnClickListener(this);
        psngr.setOnClickListener(this);
        profile.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==driver){
            Intent i = new Intent (this, AddActivity.class);
            startActivity(i);
        }

        if(v==psngr){
            Intent i = new Intent (this, FromTo.class);
            startActivity(i);
        }

        if(v==profile){
            Intent i = new Intent (this, Profile.class);
            startActivity(i);
        }

    }



}
