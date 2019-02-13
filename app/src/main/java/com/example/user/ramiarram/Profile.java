package com.example.user.ramiarram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    TextView name, age, num;
    Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name= (TextView) findViewById(R.id.Name);
        age = (TextView) findViewById(R.id.Age);
        num = (TextView) findViewById(R.id.Number);
        edit = (Button) findViewById(R.id.EditBt);
        edit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent (this, AddActivity.class);
        startActivity(i);
    }
}
