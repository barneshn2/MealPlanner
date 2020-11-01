package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Myrecipebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipe_for_plan);
        DBManger Db = new DBManger(Myrecipebook.this);
        RecyclerView AllRecipes = findViewById(R.id.GetRecipes_forPlan);
        AllPlanAdapter adapter = new AllPlanAdapter();
        AllRecipes.setLayoutManager(new LinearLayoutManager(this));
        AllRecipes.setAdapter(adapter);
        adapter.setDataList(Db.getAllRecipe());
    }


    //Method that checks if the box is checked
    public void onCheckboxClick(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox4:
                if (checked) {
                    // Do coding for what happens if checked


                }
            }
    }
}