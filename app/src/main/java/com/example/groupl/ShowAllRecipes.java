package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ShowAllRecipes extends AppCompatActivity {
    private List<Recipe> allrecipes = new ArrayList<>();
    private List<Recipe> selectedrecipes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DBManger Db = new DBManger(ShowAllRecipes.this);
        RecyclerView AllRecipes = findViewById(R.id.SHOW_ALL);
        AllRecipeAdapter adapter=new AllRecipeAdapter();
        AllRecipes.setLayoutManager(new LinearLayoutManager(this));
        AllRecipes.setAdapter(adapter);
        allrecipes = Db.getAllRecipe();
        adapter.setDataList(allrecipes);

    }
    public void recipieeadd(View view) {
        Intent intet = new Intent(this, AddNewRecipe.class);
        startActivity(intet);



    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}