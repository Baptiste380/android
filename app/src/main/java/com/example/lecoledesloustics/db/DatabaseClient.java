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
            db.execSQL("INSERT INTO Matiere VALUES(3, 'Histoire')");

            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(1, '50+13', '60,63TRUE,65', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(2, '47+10', '50,53,57TRUE', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(3, '9+32', '40,41TRUE,45', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(4, '4+58', '62TRUE,65,72', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(5, '62+4', '64,66TRUE,69', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(6, '75+21', '96TRUE,97,98', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(7, '101+6', '105,107TRUE,110', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(8, '105+40', '143,145TRUE,152', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(9, '65+41', '100,105,106TRUE', 2)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(10, '25+42', '61,63,67TRUE', 2)");

            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(11, 'Nous ... allé voir Mamie', 'sont,avons,sommesTRUE', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(12, 'Qui ... encore du gâteau ?', 'veux,veutTRUE,veu', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(13, 'Paul a donné les clefs ... Manon','àTRUE, a, as', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(14, 'Je vous présente mes ... pour mon retard', 'condoléances,excuseTRUE,fécilitations', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(15, 'Bonjour ... le monde', 'tous,tou,toutTRUE', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(16, 'Le renard a ... un écureuil', 'croquer,croquéTRUE,croquez', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(17, 'Il est ... chercher une boisson', 'alléTRUE,aller,allée', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(18, 'Cette marque est décidement trop ...', 'chére,chèreTRUE,chèr', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(19, 'Il manque une pièce à ... partie', 'cet,cetteTRUE,sept', 1)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(20, 'Il fait une ... étouffante', 'chaleure,challeure,chaleurTRUE', 1)");

            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(21, 'Quel est la couleur du cheval blanc de Henri IV ?', 'rouge,blancTRUE,noir', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(22, 'Où est situé Prague ?', 'En Grèce, en France, En République-TchèqueTRUE', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(23, 'Durant quel siècle la révolution a t-elle eu lieu ?', '20ème, 13ème, 18èmeTRUE', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(24, 'Cléopâtre a gouverné au temps des pharaons', 'VraiTRUE,False', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(25, 'Combien y a-t-il de continents ?', '3,5,7TRUE', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(26, 'Quel est le pays au nord de la France ?', '', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(27, 'Les romains se battaient avec :','La Suède, Le Japon, La Belgique', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(28, 'La bastille a été marqué par :', 'La préhistoire, La révoultionTRUE, Stéphane Plaza', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(29, 'La tour Eiffel est situé à : ', 'ParisTRUE,Londres,Madrid', 3)");
            db.execSQL("INSERT INTO Question(id, name, reponse, matiere) VALUES(30, 'La France a été championne de football à :', '1 reprise,2 reprisesTRUE,3 reprises', 3)");

            db.execSQL("INSERT INTO User VALUES(1, 'nomdeluser')");

            /*
            private String name;
            private String reponse;
            private int matiere;
             */

        }
    };
}
