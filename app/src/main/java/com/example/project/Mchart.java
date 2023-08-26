package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Mchart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mchart);

    }




    public void gochartAll(View view){
        Intent i= new Intent(this,Chart.class);
        startActivity(i);
    }

   public void gochartoutcom(View view){
        Intent i= new Intent(this,outcom.class);
        startActivity(i);
    }

    public void gochartoncom(View view){
        Intent i= new Intent(this,incom.class);
       startActivity(i);
    }













}