package com.example.project;

public class bank {

    static String ID;
    static String Type;
    static String Amount;
    static String Category;
    static String Date;

    public bank(String id, String type, String amount, String category, String date){
        ID=id;
        Type=type;
        Amount=amount;
        Category=category;
        Date=date;
    }

    public bank(){}

    public static String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public static String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public static String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public static String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }



    public  String toString() {
        return "bank{" + "ID=" + ID + ", Type='" + Type + '\'' + ", Amount='" + Amount + '\'' + ", Category='" + Category + '\'' + ", Date='" + Date + '\'' + '}';
    }
}

