package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb1;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb1 =new DataBaseHelper(this);
b=findViewById(R.id.buttonS);
        if(ContextCompat.checkSelfPermission(this, SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,SMS)){

            }

            else {
                ActivityCompat.requestPermissions(this,new String[]{SMS},MY_PERMSSIONS_RROUEST_RECRIVE_SMS);
            }
        }
/*
        //boolean n=  myDb1.insertData("outcome",1000,"salary","2/1/2023");
        myDb1.insertData("income",900,"transferin","3/1/2023");
        myDb1.insertData("outcome",900,"transferou","3/1/2023");
        myDb1.insertData("income",100,"salary","3/1/2023");
        myDb1.insertData("outcom",203000,"entertainment","9/1/2023");
        myDb1.insertData("outcom",29000,"investment","7/1/2023");
        myDb1.insertData("outcom",9000,"purchases","8/1/2023");


*/
    }
    private static final  int MY_PERMSSIONS_RROUEST_RECRIVE_SMS = 0;
    private static final String SMS ="android.permission.RECEIVE_SMS";
    private static final String SMS_RECEIVED ="android.provider.Telephony.SMS_RECEIVED";

    model mmodel;
    int Id=0;
    Double Amount1;


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

                                                    Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                                            else{

                                                Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                                        else{

                                            Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                                    else{

                                        Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                                else{

                                    Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                            else{

                                Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                        else{

                            Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                    else{

                        Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}}
                else{
                    Toast.makeText(MainActivity.this,"Wrong message", Toast.LENGTH_SHORT).show();}








                Type = msg.substring(t1, t2);
                Category = msg.substring(c1, c2);
                Amount = msg.substring(a1, a2);
                Amount1=Double.parseDouble(Amount);
                Date = msg.substring(d1, d2);
                all = ""+ Type + Category + Amount + Date;



                mmodel = new model( Id,Type, Amount, Category, Date);

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean b = dataBaseHelper.insertData(mmodel);
                Toast.makeText(MainActivity.this,"Message has been received"+b, Toast.LENGTH_SHORT).show();



            }



            catch (Exception e) {
                e.printStackTrace();
            }


        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver,new IntentFilter(SMS_RECEIVED));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }



    public void onRequestPermissionsResult (int requestCode, String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case MY_PERMSSIONS_RROUEST_RECRIVE_SMS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "Thank you for permitting!", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(this, "Can't Access Messages", Toast.LENGTH_SHORT).show();
                }

        }



    }

    public  String PR ="MYPR";
    public void saveBalnce(View view) {
        EditText text = findViewById(R.id.editTextTextPersonName);

        String amount = text.getText().toString();
        if (amount.isEmpty())
            Toast.makeText(this, "enter your balance amount ", Toast.LENGTH_LONG).show();
        else if(amount.charAt(0)=='-')
            Toast.makeText(this, "enter a postive number ", Toast.LENGTH_LONG).show();
        else if(amount.length()>20||amount.contains("@")||amount.contains("#")||amount.contains("\\")||amount.contains(")"))
            Toast.makeText(this, "enter a valid number ", Toast.LENGTH_LONG).show();
        else {
            String x = amount.trim();
            try {

                //long m = Long.parseLong(x);
               // double m1=Double.parseDouble(x);
                SharedPreferences sh=getSharedPreferences(PR, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor= sh.edit();
                editor.putString("balance",amount);
                editor.commit();

                Toast.makeText(this,""+ sh.getString("balance",""), Toast.LENGTH_LONG).show();
                 go(b);

            } catch (NumberFormatException ex) {
                Toast.makeText(this, "enter a vaild number ", Toast.LENGTH_LONG).show();
                text.setText("");

            }

        }






    }

    public void viewAll(View v) {
        /*Cursor res = myDb1.getData();
        if (res.getCount() == 0) {
            Toast.makeText(this, "Nothing Found",Toast.LENGTH_LONG).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id: " + res.getString(0) + "\n");
            buffer.append("Type: " + res.getString(1) + "\n");
            buffer.append("amount : " + res.getString(2) + "\n");
            buffer.append("catgory : " + res.getString(3) + "\n\n");
        }
        showMessage("Data", buffer.toString());*/

    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void go(View view){
        Intent i= new Intent(this,home.class);
        startActivity(i);
    }







}