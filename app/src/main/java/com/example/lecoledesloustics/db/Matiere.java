package com.example.lecoledesloustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Matiere implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="name")
    private String name;

    public int getId() { return id; }

    public void setId(int id) {this.id = id;}

    public String getName() { return name; }

    public void setName(String name) { this.name=name; }

}
