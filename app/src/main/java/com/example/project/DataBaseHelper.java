package com.example.project;

import static android.widget.Toast.makeText;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    /*
    public static final String DATABASE_NAME ="Bank";
    public static final String TABLE_NAME = "bank_table";
    public static final String col_1 = "ID";
    public static final String col_2 = "Type";
    public static final String col_3 = "Amount";
    public static final String col_4 = "Category";
    public static final String col_5 = "Date";

    public DataBaseHelper( @Nullable Context context) {
        super(context ,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + col_2 + " TEXT," +col_3+" REAL,"+col_4+ " TEXT,"+col_5+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String type , long amount , String categroy,String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_2,type);
        contentValues.put(col_3,amount);
        contentValues.put(col_4,categroy);
        contentValues.put(col_5,date);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)

            return false;
        else
            return true;
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
   }
    public void drop(){
        SQLiteDatabase db = this.getWritableDatabase();
         db.delete(TABLE_NAME,null,null);

    }






}
*/
    public static final String DATABASE_NAME ="Bank";
    public static final String TABLE_NAME = "bank_table";
    public static final String col_1 = "ID";
    public static final String col_2 = "Type";
    public static final String col_3 = "Amount";
    public static final String col_4 = "Category";
    public static final String col_5 = "Date";

    public DataBaseHelper( @Nullable Context context) {
        super(context ,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + col_2 + " TEXT," +col_3+" TEXT,"+col_4+ " TEXT,"+col_5+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(model model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,model.getType());
        contentValues.put(col_3,model.getAmount());
        contentValues.put(col_4,model.getCategory());
        contentValues.put(col_5,model.getDate());
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    public List<model>salary(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_4 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" salary ."});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }





    public List<model>All1(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_2 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" income "});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }




    public List<model>All2(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_2 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" outcome "});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }


    public List<model>en(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_4 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" entertainment ."});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }



    public List<model>insurance(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_4 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" insurance ."});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }


    public List<model>invesment(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_4 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" invesment ."});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }




    public List<model> transfer(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_4 + " =? AND " + col_2 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" transfer ."," income "});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }



    public List<model>transfer2(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_4 + " =? AND " + col_2 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" transfer ."," outcome "});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }


    public List<model>m(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_4 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" monthly redemption payments ."});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }




    public List<model>Purchases(){

        List<model> returnList = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        String queryString = "SELECT * FROM  bank_table WHERE " + col_4 + " =? ";
        Cursor cursor = db.rawQuery(queryString,new String[]{" Purchases ."});
        if(cursor.moveToFirst())
            do {
                int  Id  =cursor.getInt(0);
                String t =cursor.getString(1);
                String a =cursor.getString(2);
                String c =cursor.getString(3);
                String d =cursor.getString(4);

                model m=new model(Id,t,a,c,d);
                returnList.add(m);


            }while (cursor.moveToNext());
        else {}
        cursor.close();
        db.close();


        return returnList;
    }

}
