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

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}