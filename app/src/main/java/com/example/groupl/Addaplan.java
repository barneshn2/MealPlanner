package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Addaplan extends AppCompatActivity {
    private List<Recipe> allrecipes = new ArrayList<>();
    private List<Recipe> selectedrecipesList = new ArrayList<>();
    private DBManger Db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_addaplan);
        setContentView(R.layout.addplan);
        Intent intent = getIntent();
        getSupportActionBar().hide();

        Db = new DBManger(Addaplan.this);
        RecyclerView AllRecipes = findViewById(R.id.SHOW_ALL);
        AllRecipewithselectionAdapter adapter=new AllRecipewithselectionAdapter();
        AllRecipes.setLayoutManager(new LinearLayoutManager(this));
        AllRecipes.setAdapter(adapter);
        allrecipes = Db.getAllRecipe();
        adapter.setDataList(allrecipes);
    }
    public void backbtn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Bakbtn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Save(View view) {
        for (Recipe selectedRecipe:allrecipes){
            if (selectedRecipe.isChecked()){
                if (!selectedrecipesList.contains(selectedRecipe)){
                    selectedrecipesList.add(selectedRecipe);
                    Log.e("selectPlan ",selectedRecipe.getId()+" ");
                }
            }else {
                if (selectedrecipesList.contains(selectedRecipe)){
                    selectedrecipesList.remove(selectedRecipe);
                }
            }

        }
        Toast.makeText(this, "SelectedItemsSize = "+selectedrecipesList.size(), Toast.LENGTH_SHORT).show();
        Plan newPlan=new Plan();
        newPlan.setPlanName("My New Plan");
        newPlan.setRecipeList(selectedrecipesList);
        Calendar c=Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,c.get(Calendar.DAY_OF_MONTH)+1);
        newPlan.setDate(c.getTimeInMillis());
        Db.inserNewPlan(newPlan);
        finish();
    }

}