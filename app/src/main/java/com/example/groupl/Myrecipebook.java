package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Myrecipebook extends AppCompatActivity {
    DBManger Db;
    AllPlanAdapter adapter;
    Recipe r;
    boolean checked;
    ArrayList<Integer> checkedList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipe_for_plan);
        Db = new DBManger(Myrecipebook.this);
        RecyclerView AllRecipes = findViewById(R.id.GetRecipes_forPlan);
        adapter = new AllPlanAdapter();
        AllRecipes.setLayoutManager(new LinearLayoutManager(this));
        AllRecipes.setAdapter(adapter);
        adapter.setDataList(Db.getAllRecipe());
    }


    public void onCheckboxClick(View view) {
        int x = adapter.dataList.size();
        checked = ((CheckBox) view).isChecked();
        if(checked){
                // TODO: Add to List
            } else if (!checked){
               // TODO: remove item from list
            }
    }


    //Method that checks if the box is checked
    public void  saveChecked(View view) {
        // Check which checkbox was clicked
        for (int i = 0; i < checkedList.size(); i++) {
            if (checkedList.get(i) >= 0) {
                System.out.println(adapter.dataList.get(checkedList.get(i)).getName());
                //TODO: save tiems to list - remove print statement
            }
        }
    }

//        switch(view.getId()) {
//            case R.id.checkBox4:
//                getCheckeditems(view);
//                String checkedMsg;
//                String uncheckedMsg;
//                String RecipeName;
//                RecipeName = "_______";
//                checkedMsg = RecipeName + " Added";
//                uncheckedMsg = "recipe name removed";
//
//                str = checked? checkedMsg : uncheckedMsg;
//            }
//        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
//    }

}


