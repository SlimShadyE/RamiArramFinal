package com.example.user.ramiarram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayAdapter<String> arrayAdapter;
    ListView LVCountries;
    ArrayList<String> arrayList = new ArrayList <>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        LVCountries = findViewById(R.id.LVCountries);

        arrayList.add("Germany");
        arrayList.add("France");
        arrayList.add("Kfar Yasif");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        LVCountries.setAdapter(arrayAdapter);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
