package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Addaplan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addplan);
        Intent intent = getIntent();
    }

    public void getRecipestoAdd(View view) {
        Intent i = new Intent(this, Myrecipebook.class);
        startActivity(i);
    }
}