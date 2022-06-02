package com.example.lecoledesloustics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class ChoixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_choix);
    }

    public void pageMathematique(View view) {
       /* Toast.makeText(getApplicationContext(),"Choix Math",Toast.LENGTH_SHORT).show();*/
        Intent intent = new Intent(ChoixActivity.this, ExerciceMathActivity.class );
        startActivity(intent);
    }

    public void pageExerciceFrancais(View view) {
        /* Toast.makeText(getApplicationContext(),"Choix Math",Toast.LENGTH_SHORT).show();*/
        Intent intent = new Intent(ChoixActivity.this, ExerciceFrancaisActivity.class );
        startActivity(intent);
    }
}
