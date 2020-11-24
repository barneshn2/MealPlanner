package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShowAllPlans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showplans);
        RecyclerView AllPlans = findViewById(R.id.SHOW_ALL_plan);
        AllPlanAdapter adapter= new AllPlanAdapter();
        AllPlans.setLayoutManager(new LinearLayoutManager(this));
        AllPlans.setAdapter(adapter);
        Plan z = (Plan) getIntent().getSerializableExtra("plans");

    }



    public void plans(View view) {
        Intent intent = new Intent(this, Addaplan.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}