package com.example.lecoledesloustics.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MatiereDao {

    @Query("SELECT * FROM matiere")
    List<Matiere> getAll();

    @Query("SELECT * FROM matiere where name= :name")
    Matiere getByName(String name);

    @Insert
    void insert(Matiere matiere);

    @Insert
    long[] insertAll(Matiere... matieres);

    @Delete
    void delete(Matiere matiere);

    @Update
    void update(Matiere Matiere);
}
