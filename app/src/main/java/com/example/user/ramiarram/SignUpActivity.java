package com.example.user.ramiarram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    EditText etName, etPass, etEmail, etNum;
    TextView Title;
    Button btSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName =  (EditText) findViewById(R.id.etName);
        etPass =  (EditText) findViewById(R.id.etPass);
        etEmail =  (EditText) findViewById(R.id.etEmail);
        etNum =  (EditText) findViewById(R.id.etNum);
        btSignup =  (Button) findViewById(R.id.btSignup);
        Title =  (TextView) findViewById(R.id.textView);



    }


}
