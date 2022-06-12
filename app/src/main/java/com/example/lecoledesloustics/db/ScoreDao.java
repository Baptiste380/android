package com.example.lecoledesloustics.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ScoreDao {

    @Query("SELECT * FROM score")
    List<User> getAll();

    @Query("SELECT * FROM score where id= :id")
    User get(int id);


    @Query("SELECT * FROM score where score.user = :id")
    List<Score> getScoresFromUser(int id);

    @Insert
    void insert(Score score);

    @Insert
    long[] insertAll(Score... scores);

    @Delete
    void delete(Score score);

    @Update
    void update(Score Score);
}
