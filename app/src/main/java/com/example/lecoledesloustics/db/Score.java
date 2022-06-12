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
                ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "user",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public class Score implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="total_score")
    private int totalScore;

    @ColumnInfo(name="total_questions")
    private int totalQuestions;

    @ColumnInfo(name="matiere")
    private int matiere;

    @ColumnInfo(name="user")
    private int user;

    public int getId() { return id; }

    public void setId(int id) {this.id = id;}

    public int getTotalScore() { return totalScore; }

    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }

    public int getTotalQuestions() { return totalQuestions; }

    public void setTotalQuestions(int totalQuestions) { this.totalQuestions = totalQuestions; }

    public int getMatiere() { return matiere; }

    public void setMatiere(int matiere) { this.matiere = matiere; }

    public int getUser() { return user; }

    public void setUser(int user) { this.user = user; }


}
