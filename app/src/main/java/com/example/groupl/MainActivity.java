package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.calendarView);

    }

    public void AddaPlan(View view) {
        Intent myIntent = new Intent(view.getContext(), Addaplan.class);
        startActivity(myIntent);
    }

    public void DeleteaPlan(View view) {
    }
}

