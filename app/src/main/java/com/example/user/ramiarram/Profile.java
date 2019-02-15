package com.example.user.ramiarram;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    TextView tvname, tvage, tvnum, tvlang;
    Button edit;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("Users/"+user.getUid());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        tvname= (TextView) findViewById(R.id.Name);
        tvage = (TextView) findViewById(R.id.Age);
        tvnum = (TextView) findViewById(R.id.Number);
        tvlang = (TextView) findViewById(R.id.Language);
        edit = (Button) findViewById(R.id.EditBt);
        edit.setOnClickListener(this);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                Toast.makeText(getApplication(), "edit", Toast.LENGTH_SHORT).show();
              ///  String name = map.get("name");
  /*              String age = map.get("age");
                String num= map.get("number");
                String lang= map.get("language");
                tvname.setText(name);
                tvage.setText(age);
                tvnum.setText(num);
                tvlang.setText(lang);*/

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

    @Override
    public void onClick(View v) {
        Intent i = new Intent (this, AddActivity.class);
        startActivity(i);
    }
}
