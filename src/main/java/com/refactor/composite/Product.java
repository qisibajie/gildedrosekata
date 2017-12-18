package com.refactor.composite;

public class Product {
    private String ID;
    private String size;
    private String currency;
    private String color;
    private double price;
    private String name;

    public Product(String ID, String size, String currency, String color, double price, String name){
        this.ID = ID;
        this.size = size;
        this.currency = currency;
        this.color = color;
        this.price = price;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getSize() {
        return size;
    }

    public String getCurrency() {
        return currency;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
