package com.example.lecoledesloustics;

import android.content.Intent;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class ChoixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_choix);
    }

    public void mathClick(View v) {
        Intent intent = new Intent(ChoixActivity.this, QuestionsActivity.class );
        intent.putExtra("MATIERE", "Math");
        startActivity(intent);
    }

    public void frClick(View v) {
        Intent intent = new Intent(ChoixActivity.this, QuestionsActivity.class );
        intent.putExtra("MATIERE", "Francais");
        startActivity(intent);
    }
}
