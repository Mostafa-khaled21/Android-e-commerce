package com.example.e_com.Data.LocalData;

public class productM {
    private String name1;
    private int img1;
    String color;

    public productM(String name1, int img1, String color) {
        this.name1 = name1;
        this.img1 = img1;
        this.color = color;
    }

    public String getColor() {return color;}

    public productM(String name, int img) {
        this.name1 = name;
        this.img1 = img;
    }

    public String getNamee() {
        return name1;
    }

    public int getImgg() {
        return img1;
    }
}
