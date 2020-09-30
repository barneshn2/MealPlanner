package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class recipeAdd extends AppCompatActivity {
    public Recipe myRecipe = new Recipe();
    EditText recipeName;
    EditText ingredientName;
    Button ingredientadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_add);
        recipeName = findViewById(R.id.recipename);
        ingredientName = findViewById(R.id.ingredientName);
        ingredientadd = findViewById(R.id.ingredientAdd);
    }

    public void Saveall(){
        // maybe add if statement for default string
       myRecipe.setRecipeName(recipeName.getText().toString());



    }
    public void ingredientadd(){
        myRecipe.addIngredient(ingredientName.getText().toString());
        // for loop for displaying the list
    }

}