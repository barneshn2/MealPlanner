package com.example.groupl;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EditPlan {
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
}
