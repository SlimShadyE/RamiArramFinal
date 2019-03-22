package com.example.user.ramiarram;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener, View.OnClickListener {
    TextView Date;
    TextView Time;
    Button btAdd;
    EditText etFrom, etTo, etPrice, etDriver;
    String CurrentDateString, time;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("Rides");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
         Date= (TextView) findViewById(R.id.DateBt);
         Time = (TextView) findViewById(R.id.TimeBt);
         etFrom= (EditText) findViewById(R.id.etFrom);
         etTo= (EditText) findViewById(R.id.etTo);
         etPrice = (EditText) findViewById(R.id.etPrice);
         etDriver= (EditText) findViewById(R.id.etDriver);

         btAdd = (Button) findViewById(R.id.btAdd);
         btAdd.setOnClickListener(this);

        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Hm:
                Intent i = new Intent(this, Homepage.class);
                startActivity(i);
                break;
        }
        return true;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        CurrentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        Date.setText(CurrentDateString);

    }

    @Override
    public void onClick(View v) {
        if ( v == Date) {
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "date picker");
        }
        else if (v == Time) {
            DialogFragment timePicker = new TimePickerFragment();
            timePicker.show(getSupportFragmentManager(), "time picker");
        }
        else if(v== btAdd){
            // public Ride(String from, String to, String time, int price, String Driver) {
            Ride ride = new Ride(etFrom.getText().toString(),etTo.getText().toString(),time, etPrice.getText().toString(),etDriver.getText().toString());
            myRef.push().setValue(ride);
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        time = hourOfDay+":"+minute;
        Time.setText("Hour :  " + hourOfDay + "  Minute : " + minute);
    }
}
