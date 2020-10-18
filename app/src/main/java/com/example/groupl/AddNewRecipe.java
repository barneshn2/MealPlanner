package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class AddNewRecipe extends AppCompatActivity {
    DatabaseHelper mDatabaseHelp;
    EditText text;
    Button Adding;
    Button save;
    ListView addedItems;
    ArrayList<Ingredients> arrayList;
    ArrayList<String> IngredientsNames;
    ArrayAdapter<String> adapter;
    EditText getRecipeName;
    EditText getIngreidentsName;
    DBManger DB;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_recipe);
        getIngreidentsName = (EditText) findViewById(R.id.getIngreidentsName);
        getRecipeName = (EditText) findViewById(R.id.getRecipeName);
        Adding = (Button) findViewById(R.id.Add);
        save = (Button) findViewById(R.id.Save);
        addedItems = (ListView) findViewById(R.id.VV);
        DB = new DBManger(AddNewRecipe.this);
        IngredientsNames = new ArrayList<>();
        //    mDatabaseHelp = new DatabaseHelper()


        arrayList = new ArrayList<Ingredients>();
        adapter = new ArrayAdapter<String>(AddNewRecipe.this, android.R.layout.simple_list_item_1, IngredientsNames);

        addedItems.setAdapter(adapter);
        onBtnClick();
    }

    public void onBtnClick() {
        Adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ingredients
                Ingredients I = new Ingredients();
                String finaly = getIngreidentsName.getText().toString();
                I.setContent(finaly);
                getIngreidentsName.setText("");
                arrayList.add(I);
                IngredientsNames.add(finaly);
                adapter.notifyDataSetChanged();

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipe r = new Recipe();
                r.setName(getRecipeName.getText().toString());
                r.setIngredientsList(arrayList);
                r.setLastUpdate(Calendar.getInstance().getTimeInMillis());
                DB.insertRecpiToDataBase(r);
                Intent i = new Intent(getApplicationContext(), ShowAllRecipes.class);
                startActivity(i);

            }
        });


    }

    public void Bakbtnn(View view) {
        Intent itent = new Intent(this, ShowAllRecipes.class);
        startActivity(itent);
    }
}