package com.example.groupl;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EditPlan extends AppCompatActivity {
    Button Adding;
    Button save;
    ListView addedItems;
    ArrayList<String> IngredientsNames;
    ArrayAdapter<String> adapter;
    EditText getPlanName;
    EditText getPlansName;
    DBManger DB;
    Recipe recipe;
    Button Delete;
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getPlanName = (EditText) findViewById(R.id.getRecipeName);
        getPlansName.setText(recipe.getName());
        Delete = (Button) findViewById(R.id.DeleteRecipe);
        Delete.setVisibility(View.VISIBLE);
        Adding = (Button) findViewById(R.id.Add);
        save = (Button) findViewById(R.id.Save);
        addedItems =(ListView) findViewById(R.id.VV);

    }
}
