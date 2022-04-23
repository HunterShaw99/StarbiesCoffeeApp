package com.example.data.models;

public enum Size {
    SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

    private String val;

    public String getVal() {
        return this.val;
    }

    Size(String val) {
        this.val = val;
    }
}
