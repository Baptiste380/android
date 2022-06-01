package com.example.lecoledesloustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Matiere.class,
                        parentColumns = "id",
                        childColumns = "matiere",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public class Question implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="reponse")
    private String reponse;

    @ColumnInfo(name="matiere")
    private int matiere;

    public int getId() { return id; }

    public void setId(int id) {this.id = id;}

    public String getName() { return name; }

    public void setName(String name) { this.name=name; }

    public String getReponse() { return reponse; }

    public void setReponse(String reponse) { this.reponse = reponse; }

    public int getMatiere() { return matiere; }

    public void setMatiere(int matiere) { this.matiere = matiere; }


}
