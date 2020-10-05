package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class recipeAdd extends AppCompatActivity {
    public Recipe myRecipe = new Recipe();
    EditText recipeName;
    EditText ingredientName;
    Button addIngredient;
    ArrayList ingredientList;
    ArrayAdapter<Recipe> adapter;
    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_add);
        recipeName = findViewById(R.id.recipename);
        ingredientName = findViewById(R.id.ingredientName);
        addIngredient = findViewById(R.id.addIngredient);
        ingredientList = myRecipe.getIngredients();
        myList = findViewById(R.id.ingredientListView);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, ingredientList);
        myList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void saveAll() {
        // maybe add if statement for default string
       myRecipe.setRecipeName(recipeName.getText().toString());
       // TODO: how to save to device memory
    }

    public void removeIngredient(String ingredient) {
        myRecipe.removeIngredientName(ingredient);
        adapter.notifyDataSetChanged();
    }

    public void showIngredients(View view) {
        adapter.notifyDataSetChanged();

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapter, View view, final int position, long id) {
                String item = (String) adapter.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(recipeAdd.this);
                builder.setTitle("Delete ingredient " + item + "?");
                builder.setNegativeButton("No", null);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item = (String) adapter.getItemAtPosition(position);
                        String msg = "Deleting " + item;
                        Toast.makeText(recipeAdd.this, msg, Toast.LENGTH_SHORT).show();
                        removeIngredient(item);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void addIngredient(View view) {
        String ingredient = ingredientName.getText().toString();
        // TODO: make sure its new ingredient -- probs do in the class
        if (ingredient.length() > 0) {
            myRecipe.addIngredient(ingredient);
            showIngredients(view);
            ingredientName.setText(null);
        }
    }


}