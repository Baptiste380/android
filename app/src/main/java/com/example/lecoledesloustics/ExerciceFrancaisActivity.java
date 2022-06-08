package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;



public class ExerciceFrancaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.exercice_francais_verbe);

    }
    public void exerciceFrancaisValider(View view) {
        TextView retour = findViewById(R.id.ex2_retour);
        RadioGroup rep = findViewById(R.id.reponses);
        retour.setTextSize(50);

        if(rep.getCheckedRadioButtonId() == R.id.rep1)
        {
            retour.setTextColor(Color.parseColor("#4E9B47"));
            retour.setText("Bonne réponse !");
        }
        else
        {
            retour.setTextColor(Color.parseColor("#CF202A"));
            retour.setText("Mauvaise réponse...");
        }
    }
}

