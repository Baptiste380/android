package com.example.lecoledesloustics;

import java.util.ArrayList;

public class Multiplication {
    private int table;
    private int multiplicateur;

    Multiplication(int table, int multiplicateur)
    {
        this.table = table;
        this.multiplicateur = multiplicateur;
    }

    public int getResult()
    {
        return table*multiplicateur;
    }
}

