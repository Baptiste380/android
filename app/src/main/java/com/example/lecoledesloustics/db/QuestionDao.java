package com.example.lecoledesloustics.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM question")
    List<Question> getAll();

    @Query("SELECT question.id, question.name, question.reponse, question.matiere FROM question,matiere where question.matiere = matiere.id and matiere.name = :mat order by RANDOM() ")
    List<Question> getQuestionbyMatiere(String mat);

    @Insert
    void insert(Question question);

    @Insert
    long[] insertAll(Question... questions);

    @Delete
    void delete(Question question);

    @Update
    void update(Question question);
}
