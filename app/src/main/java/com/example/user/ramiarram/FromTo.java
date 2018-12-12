package com.example.user.ramiarram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FromTo extends AppCompatActivity {

    EditText etFrom, etTo;
    Button btSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_to);

        etFrom = findViewById(R.id.etFrom);
        etTo = findViewById(R.id.etTo);
        btSearch = findViewById(R.id.btSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FromTo.this, PlanActivity.class);
                i.putExtra("from", etFrom.getText().toString());
                i.putExtra("to",etTo.getText().toString());
                startActivity(i);
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

}
