package com.example.groupl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class EditRecipe extends AppCompatActivity {


    Button Adding;
    Button save;
    ListView addedItems;
    ArrayList<String> IngredientsNames;
    ArrayAdapter<String> adapter;
    EditText getRecipeName;
    EditText getIngreidentsName;
    DBManger DB;
    Recipe recipe;
    Button Delete;
    @Override


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id=0;
        if (getIntent().getExtras()!=null){
            Bundle b=getIntent().getExtras();
            id=b.getInt("id");
        }
        DB = new DBManger(EditRecipe.this);
        recipe=DB.getOneRecipeByID(id);
        getSupportActionBar().hide();
        setContentView(R.layout.add_new_recipe);
        getIngreidentsName = (EditText) findViewById(R.id.getIngreidentsName);

        getRecipeName = (EditText) findViewById(R.id.getRecipeName);
        getRecipeName.setText(recipe.getName());
        Delete = (Button) findViewById(R.id.DeleteRecipe);
        Delete.setVisibility(View.VISIBLE);
        Adding = (Button) findViewById(R.id.Add);
        save = (Button) findViewById(R.id.Save);
        addedItems =(ListView) findViewById(R.id.VV);

        IngredientsNames = new ArrayList<>();
        for (Ingredients i : recipe.getIngredientsList()){
            IngredientsNames.add(i.getContent());

        }
        adapter = new ArrayAdapter<>(EditRecipe.this,
                android.R.layout.simple_list_item_1
                , IngredientsNames);

        addedItems.setAdapter(adapter);
        addedItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                IngredientsNames.remove(i);
                recipe.getIngredientsList().remove(i);
                adapter.notifyDataSetChanged();
            }
        });
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
                I.setrID(recipe.getId());
                getIngreidentsName.setText("");
                recipe.getIngredientsList().add(I);
                IngredientsNames.add(finaly);
                adapter.notifyDataSetChanged();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe.setName(getRecipeName.getText().toString());
                recipe.setLastUpdate(Calendar.getInstance().getTimeInMillis());
                DB.updateRecpiToDataBase(recipe);
                Intent i = new Intent(getApplicationContext(), ShowAllRecipes.class);
                startActivity(i);
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() { //for next commit
            @Override
            public void onClick(View view) {
                DeleteRecipe();
            }
        });

    }
    private void DeleteRecipe(){
        DB.deleteRecipe(recipe.getId());
        findViewById(R.id.button5).callOnClick();
    }





    public void Bakbtnn(View view) {
        Intent itent = new Intent(this, ShowAllRecipes.class);
        startActivity(itent);
    }
}
