package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ShowAllPlans extends AppCompatActivity {
    private List<Plan> all_Plans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showplans);
        DBManger Db = new DBManger(ShowAllPlans.this);
        RecyclerView AllPlans = findViewById(R.id.SHOW_ALL_plan);
        AllPlanAdapter adapter= new AllPlanAdapter();
        AllPlans.setLayoutManager(new LinearLayoutManager(this));
        AllPlans.setAdapter(adapter);
        Intent i = getIntent();
        all_Plans = (List<Plan>) i.getSerializableExtra("PLANS");
        adapter.setDataList(all_Plans);

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