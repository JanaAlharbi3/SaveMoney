package com.example.project;

public class model {

    private  int ID;
    private  String Type;
    private  String Amount;
    private  String Category;
    private  String Date;

    public model(int id, String type, String amount, String category, String date) {
        ID = id;
        Type = type;
        Amount = amount;
        Category = category;
        Date = date;
    }

    public model() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }



    public  String toString() {
        return "model{" + "ID=" + ID + ", Type='" + Type + '\'' + ", Amount='" + Amount + '\'' + ", Category='" + Category + '\'' + ", Date='" + Date + '\'' + '}';
    }
}

