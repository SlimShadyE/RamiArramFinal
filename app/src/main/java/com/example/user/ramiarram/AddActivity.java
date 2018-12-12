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
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener, View.OnClickListener {
    TextView textView1;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
         textView= (TextView) findViewById(R.id.DateBt);
         textView1 = (TextView) findViewById(R.id.TimeBt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
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
        String CurrentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        textView.setText(CurrentDateString);

    }

    @Override
    public void onClick(View v) {
        if ( v == textView) {
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "date picker");
        }
        else if (v == textView1) {
            DialogFragment timePicker = new TimePickerFragment();
            timePicker.show(getSupportFragmentManager(), "time picker");
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        textView1.setText("Hour :  " + hourOfDay + "  Minute : " + minute);
    }
}
