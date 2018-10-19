package com.example.user.ramiarram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText etEmailL, etPassL;
    TextView textView2;
    Button btLg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmailL =  (EditText) findViewById(R.id.etEmailL);
        etPassL =  (EditText) findViewById(R.id.etPassL);
        textView2 = (TextView) findViewById(R.id.textView2);
        btLg =  (Button) findViewById(R.id.btLogin);



    }
}
