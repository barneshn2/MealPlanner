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
        //findViewById(R.id.calendarView);
    }

    public void AddaPlan(View view) {
        //create an intent
        Intent intent = new Intent(this, Addaplan.class);
        startActivity(intent);
    }

    public void DeleteaPlan(View view) {
    }

    public void recip(View view) {
        Intent intent = new Intent(this, ShowAllRecipes.class);
        startActivity(intent);
    }
}

