package com.example.lecoledesloustics;

public class AccountManager {

    private static AccountManager instance;

    public static AccountManager getInstance() {
        if (instance == null)
            instance = new AccountManager();
        return instance;
    }

    private AccountManager() {
    }

    private String val;

    public String getValue() {
        return val;
    }

    public void setValue(String value) {
        this.val = value;
    }
}