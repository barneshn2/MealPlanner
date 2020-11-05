package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Myrecipebook extends AppCompatActivity {
    DBManger Db;
    Plan p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipe_for_plan);
        Db = new DBManger(Myrecipebook.this);
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
        String str= "";
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox4:
//                if (checked) {}
                    // Do coding for what happens if checked
                    str = checked?"Recipe Selected":"Recipe Deselected";
                    // print of recipe name selected
            }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

}