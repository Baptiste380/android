package com.example.lecoledesloustics.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.io.File;
import java.util.concurrent.Executors;

public class DatabaseClient {

    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données de votre application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // MyToDos est le nom de la base de données
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "db3")
                .build();

        ////////// REMPLIR LA BD à la première création à l'aide de l'objet roomDatabaseCallback
        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "db3").addCallback(roomDatabaseCallback).allowMainThreadQueries().build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de votre application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            //
            db.execSQL("INSERT INTO Matiere VALUES(1, 'Francais')");
            db.execSQL("INSERT INTO Matiere VALUES(2, 'Math')");

            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(1, '1+2', '3,4TRUE,5', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(2, '1+3', '4TRUE,5,6', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(3, '1+4', '1,5TRUE,9', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(4, 'Question FR 1', '3,4,5', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(5, 'Question FR 2', '4TRUE,5,6', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(6, 'Question FR 3', '1,5TRUE,9', 1)");

            db.execSQL("INSERT INTO User VALUES(1, 'nomdeluser')");

            /*
            private String name;
            private String reponse;
            private int matiere;
             */

        }
    };
}
