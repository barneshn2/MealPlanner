package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyrecipeBook extends AppCompatActivity {

    ArrayAdapter<Recipe> adapter2;
    ListView recipeViewer;
    ArrayList<Recipe> recipes = recipeAdd.getRecipeBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecipe_book);
        recipeViewer = findViewById(R.id.recipeList);
        adapter2 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, recipes);
        recipeViewer.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
        showRecipeNames();
    }

    public void showRecipeNames(){
        adapter2.notifyDataSetChanged();

        recipeViewer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapter, View view, final int position, long id) {
                String item = (String) adapter.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(MyrecipeBook.this);
                builder.setTitle("Delete ingredient " + item + "?");
                builder.setNegativeButton("No", null);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item = (String) adapter.getItemAtPosition(position);
                        String msg = "Deleting " + item;
                        Toast.makeText(MyrecipeBook.this, msg, Toast.LENGTH_SHORT).show();
//                        removeIngredient(item);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}