package com.example.user.ramiarram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
    Button driver, psngr, profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
            Intent i = new Intent (this, FromTo.class);
            startActivity(i);
        }

    }
}
