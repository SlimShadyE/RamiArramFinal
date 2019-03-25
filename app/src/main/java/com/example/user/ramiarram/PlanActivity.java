package com.example.user.ramiarram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Map;


public class PlanActivity extends AppCompatActivity {

    ListView lvRides;
    ArrayList<Ride> rides;
    TextView tvMessage;
    RideAdapter adapter;
    String fromEx;
    String toEx;
    String price;
    String driver;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("Rides");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        rides = new ArrayList<>();
        lvRides = findViewById(R.id.lvRides);


        fromEx = getIntent().getStringExtra("from");
        toEx = getIntent().getStringExtra("to");
        if(fromEx != null && toEx != null){

            adapter = new RideAdapter(this, R.layout.activity_ride, rides);
            lvRides.setAdapter(adapter);

            tvMessage = findViewById(R.id.tvMessage);
        }
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Ride ride=  dataSnapshot.getValue(Ride.class);

                if(ride.getFrom().equals(fromEx) && ride.getTo().equals(toEx))
                {
                    rides.add(ride);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
