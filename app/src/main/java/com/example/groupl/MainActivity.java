package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText recipeName;
    EditText ingredientName;
    Button ingredientadd;
    Button recipeSavebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.calendarView);
        recipeName = findViewById(R.id.recipename);
        ingredientName = findViewById(R.id.ingredientName);
        ingredientadd = findViewById(R.id.ingredientAdd);
        recipeSavebutton = findViewById(R.id.recipeSave);
    }

    public void AddaPlan(View view) {

        //create an intent
        Intent intent = new Intent(this, Addaplan.class);
        startActivity(intent);

    }

    public void DeleteaPlan(View view) {
    }

    public void AddaRecipe(View view){

        // create a intent
        Intent intent1 = new Intent(this, recipeAdd.class);
        startActivity(intent1);
    }
}

