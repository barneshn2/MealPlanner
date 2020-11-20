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
        final AllPlanAdapter adapter= new AllPlanAdapter();
        AllRecipes.setLayoutManager(new LinearLayoutManager(this));
        AllRecipes.setAdapter(adapter);
        allrecipes = Db.getAllRecipe();
        adapter.setDataList(allrecipes);
        final List<Recipe> recipes = Db.getAllRecipe();


        saver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(recipes);
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

    public void save(List<Recipe> recipes){
        List<Integer> saved = null;
        for (int i = 0; i < recipes.size(); i++){
            Recipe z = recipes.get(i);
            if (z.isChecked()){
                saved.add(z.getId());
            }

        }
        for (int j = 0; j < saved.size(); j++){
            System.out.println(saved.get(j));
        }

    }
}