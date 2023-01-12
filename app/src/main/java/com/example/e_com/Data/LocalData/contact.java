package com.example.e_com.Data.LocalData;

public class contact {
    int price;
    String title;
    String image;

    public contact() {
    }

    public contact(int id, String user, String pass) {
        this.price = id;
        this.title = user;
        this.image = pass;
    }

    public void setId(int id) {this.price = id;}

    public void setUser(String user) {this.title = user;}

    public void setPass(String pass) {this.image = pass;}

    public int getId() {return price;}

    public String getUser() {return title;}

    public String getPass() {return image;}
}
