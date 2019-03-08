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
                Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                String driver = map.get("driver");
                String from = map.get("from");
                String to = map.get("to");
                String time = map.get("time");
                //                int price = Integer.parseInt(map.get("price"));

                // public Ride(String from, String to, String time, int price, String Driver) {
                if(from.equals(fromEx) || to.equals(toEx))
                {
                    rides.add(new Ride(from, to,time,55,driver));
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

/*    //if time permits change with real Search
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

    }*/
}
