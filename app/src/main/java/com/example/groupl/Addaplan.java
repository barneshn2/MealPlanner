package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Addaplan extends AppCompatActivity {
    private List<Recipe> allrecipes = new ArrayList<>();
    private List<Recipe> selectedrecipes = new ArrayList<>();
    private List<Plan> allPlans = new ArrayList<>();
    EditText pName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_addaplan);
        setContentView(R.layout.addplan);
        Intent intent = getIntent();
        Button saver = findViewById(R.id.button3);
        pName = (EditText) findViewById(R.id.namesP);

        final DBManger Db = new DBManger(Addaplan.this);
        RecyclerView AllRecipes = findViewById(R.id.SHOW_ALL);
        final AllRecipewithselectionAdapter adapter= new AllRecipewithselectionAdapter();
        AllRecipes.setLayoutManager(new LinearLayoutManager(this));
        AllRecipes.setAdapter(adapter);
        allrecipes = Db.getAllRecipe();
        adapter.setDataList(allrecipes);
        final List<Recipe> recipes = Db.getAllRecipe();

        final Intent intent2 = new Intent(this, ShowAllPlans.class);
        saver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p_Name = pName.getText().toString();
                for (Recipe selectedRecipes : allrecipes){
                    if(selectedRecipes.isChecked()){
                        if (!selectedrecipes.contains(selectedRecipes)){
                            selectedrecipes.add(selectedRecipes);
                        }
                    }
                    else{
                        if(selectedrecipes.contains(selectedRecipes)){
                            selectedrecipes.remove(selectedRecipes);
                        }
                    }
                }
                Toast.makeText(Addaplan.this,"SelectedItemsSize = "+selectedrecipes.size() , Toast.LENGTH_SHORT).show();
                //LOOK at Master
                Plan z = new Plan();
                z.setPlanName(p_Name);
                z.setRecipeList(selectedrecipes);
                z.setDate(Calendar.getInstance().getTimeInMillis());
                allPlans.add(z);
                intent2.putExtra("PLANS", (Serializable) allPlans);
                startActivity(intent2);


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
//
//    public void save(List<Recipe> recipes){
//
//        List<Integer> saved = null;
//        for (int i = 0; i < recipes.size(); i++){
//            Recipe z = recipes.get(i);
//            if (z.isChecked()){
//                saved.add(z.getId());
//            }
//
//        }
//        for (int j = 0; j < saved.size(); j++){
//            System.out.println(saved.get(j));
//        }
//
//    }
}