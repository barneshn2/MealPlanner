package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Addaplan extends AppCompatActivity {
    // creates the instances
    Button mButton;
    EditText mEdit;
    TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaplan);
        mButton = (Button)findViewById(R.id.button3);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEdit   = (EditText)findViewById(R.id.editTextTextPersonName);

            }
        });
    }





}