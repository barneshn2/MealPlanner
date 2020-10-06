package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    EditText text;
    Button Adding;
    ListView addedItems;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipebook);
        text = (EditText) findViewById(R.id.input);
        Adding = (Button) findViewById(R.id.Add);
        addedItems =(ListView) findViewById(R.id.VV);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1, arrayList);

        addedItems.setAdapter(adapter);
        onBtnClick();
    }

    public void onBtnClick() {
        Adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String finaly = text.getText().toString();
                arrayList.add(finaly);
                adapter.notifyDataSetChanged();
            }
        });




    }
}