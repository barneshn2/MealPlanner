package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Addaplan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_addaplan);
        setContentView(R.layout.addplan);
        Intent intent = getIntent();

      /* Commenting code out  causing run time errors

       // get all the variables from a button click
        Button mButton = (Button) findViewById(R.id.button3);
        mButton.setOnClickListener(new View.OnClickListener() {
            // on a click it will act
            public void onClick(View view) {

                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();

                // find the plan user text input
                final EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
                String plan = editText.getText().toString();

                //use a switch case to find which button was selected
                switch(view.getId()) {
                    case R.id.Breakfast:
                        if (checked)
                            // if breakfast is selected
                            break;
                    case R.id.Lunch:
                        if (checked)
                            // if lunch is selected
                            break;
                    case R.id.Dinner:
                        if (checked)
                            //if dinner is selected
                            break;

                }
            }
        });*/

    }





}