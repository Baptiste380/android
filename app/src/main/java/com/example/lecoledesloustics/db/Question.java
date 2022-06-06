package com.example.lecoledesloustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

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

    public ArrayList<String> getReponseArr() {
        String[] rep = reponse.split(",");
        ArrayList<String> parsed_rep = new ArrayList<String>();

        for (String i : rep) {
            if (i.contains("TRUE")) {
                parsed_rep.add(i.replace("TRUE", ""));
            } else {
                parsed_rep.add(i);
            }
        }
        return parsed_rep;
    }

    public String getValidReponse() {
        String[] rep = reponse.split(",");
        String validRep = "";

        for (String i : rep) {
            if (i.contains("TRUE")) {
                i = i.replace("TRUE", "");
                validRep = i;
            }
        }

        return validRep;
    }

    public void setReponse(String reponse) { this.reponse = reponse; }

    public int getMatiere() { return matiere; }

    public void setMatiere(int matiere) { this.matiere = matiere; }


}
