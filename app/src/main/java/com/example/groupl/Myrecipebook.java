package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Myrecipebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipe_for_plan);
        DBManger Db = new DBManger(Myrecipebook.this);
        RecyclerView AllRecipes = findViewById(R.id.GetRecipes);
        AllRecipeAdapter adapter=new AllRecipeAdapter();
        AllRecipes.setLayoutManager(new LinearLayoutManager(this));
        AllRecipes.setAdapter(adapter);
        adapter.setDataList(Db.getAllRecipe());
    }
}