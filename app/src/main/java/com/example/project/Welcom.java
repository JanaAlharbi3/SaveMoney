package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Welcom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        ImageView w = findViewById(R.id.imageView);
        Thread  th =new Thread(){
     public void run (){
         try {
             sleep(4400);
             Intent b = new Intent(getApplicationContext(),MainActivity.class);
             startActivity(b);
             finish();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     }

        };


        th.start();


    }
}