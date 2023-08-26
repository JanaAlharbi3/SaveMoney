package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class invesment extends AppCompatActivity {

    DataBaseHelper db;
    TableLayout table;
    String result;



    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invesment);
        table=(TableLayout)findViewById(R.id.mytable);
        result = "Salary data:\n";


        try {


            DataBaseHelper dataBaseHelper = new DataBaseHelper(invesment.this);
            List<model> everyone=dataBaseHelper.invesment();
            for (model b : everyone) {
                TableRow row = new TableRow(this);
                TableRow rowSpace = new TableRow(this);//forSpaceBetweenRows
                int i = b.getID();
                String t = b.getType();
                String c = b.getCategory();
                String a = b.getAmount();
                String d = b.getDate();
                TextView tv1 = new TextView(this);
                tv1.setText("   " + i);
                TextView tv1Space = new TextView(this);
                tv1Space.setText("   ");
                TextView tv2 = new TextView(this);
                tv2.setText("  " + t + " ");
                TextView tv2Space = new TextView(this);
                tv2Space.setText("");
                TextView tv3 = new TextView(this);
                tv3.setText("     " + a);
                TextView tv3Space = new TextView(this);
                tv3Space.setText("   ");
                TextView tv4 = new TextView(this);
                tv4.setText("      " + c);
                TextView tv4Space = new TextView(this);
                tv4Space.setText("   ");
                TextView tv5 = new TextView(this);
                tv5.setText(d);
                row.addView(tv1Space);
                row.addView(tv1);
                // row.addView(tv2Space);
                row.addView(tv2);
                //row.addView(tv2Space);
                row.addView(tv3);
                row.addView(tv4);
                row.addView(tv5);
                rowSpace.addView(tv4Space);
                table.addView(row);
                table.addView(rowSpace);
                //result = result + "ID: " + b.getID() + " \n " + "Type: " + b.getType() + " \n" + "Category: " + b.getCategory() + " \n" + "Amount: " + b.getAmount() + "\n " + "Date: " + b.getDate() + "\n";
                //tv.setText(result);


            }
        } finally {

        }
    }}