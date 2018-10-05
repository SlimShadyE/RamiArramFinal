package com.example.user.ramiarram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.example.user.ramiarram.R.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case id.item1:
                Intent i = new Intent(this, TabbedActivity.class);
                startActivity(i);
                break;
            case id.item2:
                Toast.makeText(this, " Item menu 2", Toast.LENGTH_SHORT).show();
                break;
            case id.item3:
                Toast.makeText(this, " Item menu 3", Toast.LENGTH_SHORT).show();
                break;
            }
            return true;
        }
    }