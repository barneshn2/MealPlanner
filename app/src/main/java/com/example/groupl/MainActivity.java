package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AllPlanAdapter allPlanAdapter;
    DBManger db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView view= findViewById(R.id.calendarView);
        db=new DBManger(MainActivity.this);
        RecyclerView allPlan =findViewById(R.id.allPlanse);
        allPlan.setLayoutManager(new LinearLayoutManager(this));
        allPlanAdapter=new AllPlanAdapter();
        allPlan.setAdapter(allPlanAdapter);
        getSupportActionBar().hide();
        List<Plan>planList=db.getAllPlanse();
        allPlanAdapter.setDataList(planList);

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

    @Override
    protected void onResume() {
        super.onResume();
        allPlanAdapter.setDataList(db.getAllPlanse());
    }
}

