package com.example.user.ramiarram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    SpotAdapter arrayAdapter;
    ListView LVCountries;
    ArrayList<Spot> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        LVCountries = findViewById(R.id.LVCountries);
        arrayList = new ArrayList <>();

        arrayList.add(new Spot(R.drawable.cr,"Germany"));
        arrayList.add(new Spot(R.drawable.cr,"Germany"));
        arrayList.add(new Spot(R.drawable.cr,"Germany"));


        arrayAdapter = new SpotAdapter(this, R.layout.user_list, arrayList);
        LVCountries.setAdapter(arrayAdapter);
        LVCountries.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
