package com.example.user.ramiarram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Driver;
import java.util.ArrayList;


public class PlanActivity extends AppCompatActivity {

    ListView lvRides;
    ArrayList<Ride> rides;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        rides = new ArrayList<>();
        lvRides = findViewById(R.id.lvRides);

        String from = getIntent().getStringExtra("from");
        String to = getIntent().getStringExtra("to");
        if(from == null || to == null){

        }else {
            searchFrom(from, to);
            RideAdapter adapter = new RideAdapter(this, R.layout.activity_ride, rides);
            lvRides.setAdapter(adapter);

            tvMessage = findViewById(R.id.tvMessage);
        }

    }

    //if time permits change with real Search
    public void searchFrom(String from, String to){
        if(from.equals("Haifa") && to.equals("Tel aviv")){
            Ride ride1 = new Ride("Haifa", "Tel aviv", "5 PM", 12, "Rami");
            Ride ride2 = new Ride("Haifa", "Kfar Yasif", "8 PM", 17, "Yousef");
            rides.add(ride1);
            rides.add(ride2);
        }else if(from.equals("Kfar Yasif") && to.equals("Tel aviv")){
            Ride ride3 = new Ride("Kfar Yasif", "Tel aviv", "9 AM", 25, "Fadi");
            rides.add(ride3);
        }else{
            tvMessage.setVisibility(View.VISIBLE);
        }

    }
}
