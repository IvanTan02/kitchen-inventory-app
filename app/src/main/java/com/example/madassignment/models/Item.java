package com.example.madassignment.models;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    private String name, category, storage, sDate, eDate;
    private int qty;

    public Item(String name, String category, String storage, String sDate, String eDate, int qty) {
        this.name = name;
        this.category = category;
        this.storage = storage;
        this.sDate = sDate;
        this.eDate = eDate;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
