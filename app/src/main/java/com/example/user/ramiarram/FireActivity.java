package com.example.user.ramiarram;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class FireActivity extends AppCompatActivity {

    Button btSave;
    EditText etEmail, etPass;
    TextView tvEmail, tvPro;
    ArrayList<String> users;
    ListView lvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");

        btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                myRef.setValue(email);
            }
        });
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        tvEmail = findViewById(R.id.tvEmail);
         tvPro = findViewById(R.id.tvPro);
        lvUsers = findViewById(R.id.lvUsers);
        users = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        lvUsers.setAdapter(adapter);

//        myRef.child("Users").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
////                Toast.makeText(FireActivity.this, "inside data changed", Toast.LENGTH_LONG).show();
////                String email = dataSnapshot.getValue(String.class);
////                tvEmail.setText(email);
//                Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
//                Log.v("R_VALUE", "Data: " + dataSnapshot.getValue());
//
//                String name = map.get("Name");
//                String profession = map.get("Profession");
//                tvEmail.setText(name);
//                tvPro.setText(profession);
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String name = dataSnapshot.getValue(String.class);
                users.add(name);
                adapter.notifyDataSetChanged();
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
