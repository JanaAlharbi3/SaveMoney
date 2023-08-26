package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;

public class home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{


String str;
    model mmodel;
    int Id=0;
    Double Amount1;
TextView textView;
    String PR ="MYPR";
    String all,Type,Category,Amount,Date;
    int t1,t2,c1,c2,a1,a2,d1,d2;

    final SMSbroadcast receiver = new SMSbroadcast() {
        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            try{
                t1 = msg.indexOf("Type") + 5;
                if (t1>0){t2 = msg.indexOf("Category");
                    if (t2>0){c1 = msg.indexOf("Category") + 9;
                        if (c1>0){c2 = msg.indexOf("The");
                            if (c2>0){a1 = msg.indexOf("of") + 2;
                                if (a1>0){a2 = msg.indexOf("SAR");
                                    if (a2>0){d1 = msg.indexOf("On") + 2;
                                        if (d1>0){d1 = msg.indexOf("On") + 2;
                                            if (d1>0){d2 = msg.indexOf("At");
                                                if (d2>0){Id++;}
                                                else{

                                                    Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                                            else{

                                                Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                                        else{

                                            Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                                    else{

                                        Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                                else{

                                    Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                            else{

                                Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                        else{

                            Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                    else{

                        Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                else{
                    Toast.makeText(home.this,"Wrong message", Toast.LENGTH_SHORT).show();}








                Type = msg.substring(t1, t2);
                Category = msg.substring(c1, c2);
                Amount = msg.substring(a1, a2);
                Amount1=Double.parseDouble(Amount);
                Date = msg.substring(d1, d2);
                all = ""+ Type + Category + Amount + Date;



                mmodel = new model( Id,Type, Amount, Category, Date);

                DataBaseHelper dataBaseHelper = new DataBaseHelper(home.this);
                boolean b = dataBaseHelper.insertData(mmodel);
                Toast.makeText(home.this,"Message has been received"+b, Toast.LENGTH_SHORT).show();



            }



            catch (Exception e) {
                e.printStackTrace();
            }


        }
    };

    DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = findViewById(R.id.textView);
        SharedPreferences mPrefs = getSharedPreferences("MYPR", 0);
        str = String.valueOf(mPrefs.getString("balance", ""));
        DataBaseHelper myDb1 = new DataBaseHelper(home.this);

        double income = 0;
        double outcome = 0;
        Cursor res = myDb1.getData();
        while (res.moveToNext()) {
            if (res.getString(1).equals(" income "))
                income += Double.parseDouble(res.getString(2));
            if (res.getString(1).equals(" outcome "))
                outcome += Double.parseDouble(res.getString(2));
        }
        double balnce = Double.parseDouble(str) +income-outcome;
        textView.setText(""+balnce);
        //////////////
      /*  Button cal=findViewById(R.id.button);
        MaterialDatePicker materialDatePicker=MaterialDatePicker.Builder.dateRangePicker()
                .setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(),MaterialDatePicker.todayInUtcMilliseconds())).build();
        TextView t=findViewById(R.id.textView4);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(),"Tag_picker");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        t.setText(materialDatePicker.getHeaderText());
                    }
                });
            }
        });
        Button mDisplayDate=findViewById(R.id.button);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        home.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("home", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "/" + month + "/" + year;
                SharedPreferences sh=getSharedPreferences(PR, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor= sh.edit();
                editor.putInt("sday",day);
                editor.putInt("smon",month);
                editor.putInt("syear",year);

                mDisplayDate.setText(date);
            }
        };
        //////////////////////
        Button end=findViewById(R.id.button3);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        home.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("home", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "/" + month + "/" + year;
                SharedPreferences sh=getSharedPreferences(PR, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor= sh.edit();
                editor.putInt("eday",day);
                editor.putInt("emon",month);
                editor.putInt("eyear",year);
                editor.commit();

                mDisplayDate.setText(date);
            }
        };
        Button bb=findViewById(R.id.button4);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(home.this,date.class);
              startActivity(intent1);
            }
        });*/
    }



    public void showpopup(View v) {
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();

    }
    public void showpopup2(View view) {
        PopupMenu popup2 = new PopupMenu(this,view);
        popup2.setOnMenuItemClickListener(this);
        popup2.inflate(R.menu.popup2_menu);
        popup2.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText (this, "All clicked", Toast.LENGTH_SHORT).show();
                Intent itemm1 = new Intent(home.this,All1.class);
                startActivity(itemm1);
                return true;

            case R.id.item2:
                Toast.makeText (this, "Salary clicked", Toast.LENGTH_SHORT).show();
                Intent itemm2 = new Intent(home.this,Salary.class);
                startActivity(itemm2);
                return true;

            case R.id.item3:
                Toast.makeText (this, "transfer clicked", Toast.LENGTH_SHORT).show();
                Intent itemm3 = new Intent(home.this,transfer.class);
                startActivity(itemm3);
                return true;

            case R.id.item4:
                Toast.makeText (this, "All clicked", Toast.LENGTH_SHORT).show();
                Intent itemm4 = new Intent(home.this,All2.class);
                startActivity(itemm4);
                return true;

            case R.id.item5:
                Toast.makeText (this, "Purchases clicked", Toast.LENGTH_SHORT).show();
                Intent itemm5 = new Intent(home.this,Purchases.class);
                startActivity(itemm5);
                return true;

            case R.id.item6:
                Toast.makeText (this, "transfers clicked", Toast.LENGTH_SHORT).show();
                Intent itemm6 = new Intent(home.this,transfers2.class);
                startActivity(itemm6);
                return true;

            case R.id.item7:
                Toast.makeText (this, "investment clicked", Toast.LENGTH_SHORT).show();
                Intent itemm7 = new Intent(home.this,transfers2.class);
                startActivity(itemm7);
                return true;

            case R.id.item8:
                Toast.makeText (this, "monthly redemption payments clicked", Toast.LENGTH_SHORT).show();
                Intent itemm8 = new Intent(home.this,monthly_r_p.class);
                startActivity(itemm8);
                return true;

            case R.id.item9:
                Toast.makeText (this, "insurance and taxes clicked", Toast.LENGTH_SHORT).show();
                Intent itemm9 = new Intent(home.this,insurance.class);
                startActivity(itemm9);
                return true;

            case R.id.item10:
                Toast.makeText (this, "entertainment clicked", Toast.LENGTH_SHORT).show();
                Intent itemm10 = new Intent(home.this,entertainment.class);
                startActivity(itemm10);
                return true;

            default: return false;
        }
    }


    public void Report1(View view2) {
        Intent report = new Intent(home.this,Mchart.class);
        startActivity(report);
    }
}



