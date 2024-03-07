package com.example.madassignment.models;

import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private String productType;
    private double price;
    private String grocer;

    public Product (String n, String t, double p, String g) {
        productName = n;
        productType = t;
        price = p;
        grocer = g;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGrocer() {
        return grocer;
    }

    public void setGrocer(String grocer) {
        this.grocer = grocer;
    }

    @Override
    public String toString() {
        return "Name: " + productName + "\n" + "Type: " + productType + "\n" + "Price: " + price + "\n" + "Grocer: " + grocer;
    }
}
