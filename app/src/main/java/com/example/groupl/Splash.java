package com.example.groupl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(3000);
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
                }catch (Exception e){

                }
            }
        }.start();


    }
}