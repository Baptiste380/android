package com.example.lecoledesloustics.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {
            User.class,
            Matiere.class,
            Question.class,
            Score.class
        },
        version = 1,
        exportSchema = false
    )
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract MatiereDao matiereDao();
    public abstract QuestionDao questionDao();
    public abstract ScoreDao scoreDao();
}