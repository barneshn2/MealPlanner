package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Addaplan extends AppCompatActivity {
    private List<Recipe> allrecipes = new ArrayList<>();
    private List<Recipe> selectedrecipes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_addaplan);
        setContentView(R.layout.addplan);
        Intent intent = getIntent();
        Button saver = findViewById(R.id.button3);

        DBManger Db = new DBManger(Addaplan.this);
        RecyclerView AllRecipes = findViewById(R.id.SHOW_ALL);
        final AllRecipeAdapter adapter=new AllRecipeAdapter();
        AllRecipes.setLayoutManager(new LinearLayoutManager(this));
        AllRecipes.setAdapter(adapter);
        allrecipes = Db.getAllRecipe();
        adapter.setDataList(allrecipes);

        saver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void backbtn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Bakbtn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void save(){

    }
}