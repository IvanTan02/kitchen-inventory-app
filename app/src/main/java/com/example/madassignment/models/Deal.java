package com.example.madassignment.models;

public class Deal {
    private String dealID;
    private String dealText;
    private String dealLink;

    public Deal(String id, String t, String l) {
        dealID = id;
        dealText = t;
        dealLink = l;
    }

    public String getDealID() {
        return dealID;
    }

    public String getDealText() {
        return dealText;
    }

    public String getDealLink() {
        return dealLink;
    }
}

