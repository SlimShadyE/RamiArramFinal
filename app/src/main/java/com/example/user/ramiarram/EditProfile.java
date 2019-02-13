package com.example.user.ramiarram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity implements View.OnClickListener{
    TextView etname, etage, etnum;
    Button done;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    final DatabaseReference myRef = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);




        etname= (TextView) findViewById(R.id.etName);
        etage = (TextView) findViewById(R.id.etAge);
        etnum = (TextView) findViewById(R.id.etNum);
        done = (Button) findViewById(R.id.EditBt);
        done.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        User user1 = new User(etname.getText().toString(), etage.getText().toString(), etnum.getText().toString() );
        myRef.child(user.getUid()).setValue(user1);
    }
}
