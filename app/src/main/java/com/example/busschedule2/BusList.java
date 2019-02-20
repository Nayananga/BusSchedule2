package com.example.busschedule2;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BusList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

        ListView resultsListView = (ListView) findViewById(R.id.bus_list);
        HashMap<String,String> nameAddresses = new HashMap<>();
        nameAddresses.put("Nipuna","Mathale");
        nameAddresses.put("Samila","Horana");
        nameAddresses.put("Anuka","Gampaha");
        nameAddresses.put("Shehan","Anuradhapura");
        nameAddresses.put("Nayananga","Ratnapura");

        List<HashMap<String,String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this,listItems,R.layout.list_item, new String[]{"First Line","Second Line"}, new int[]{R.id.text1,R.id.text3});

        Iterator it = nameAddresses.entrySet().iterator();
        while (it.hasNext()){
            HashMap<String,String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line",pair.getKey().toString());
            resultsMap.put("Second Line",pair.getValue().toString());
            listItems.add(resultsMap);
        }

        resultsListView.setAdapter(adapter);

        resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(BusList.this,BusFacilities.class);
                startActivity(myIntent);
            }
        });

        configureBackButton();
    }

    private void configureBackButton(){
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
