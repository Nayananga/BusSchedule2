package com.example.busschedule2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class BusFacilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_facilities);

        ListView listView = findViewById(R.id.facilityList);
        ArrayList<String> facilityList = new ArrayList<>();
        facilityList.add("Non A/C");
        facilityList.add("Wifi");
        facilityList.add("TV");
        facilityList.add("Comfortable Seats");
        facilityList.add("Phone Charging");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_facility_item, R.id.text4, facilityList);
        listView.setAdapter(adapter);


        configureBackButton2();
        configureConfirmButton();

    }

    private void configureBackButton2() {
        Button backButton2 = findViewById(R.id.backButton2);
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void configureConfirmButton() {
        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
