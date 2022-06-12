package com.example.lecoledesloustics;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class ChoixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_choix);
        Button btn = findViewById(R.id.activity_francais);
        Button btn2 = findViewById(R.id.activity_math);
        Button btn3 = findViewById(R.id.activity_histoire);
        btn.setBackgroundColor(Color.argb(255, 119, 197, 147));
        btn2.setBackgroundColor(Color.argb(255, 221, 122, 61));
        btn3.setBackgroundColor(Color.argb(255, 244, 234, 70));
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

    public void histoireClick(View v) {
        Intent intent = new Intent(ChoixActivity.this, QuestionsActivity.class );
        intent.putExtra("MATIERE", "Histoire");
        startActivity(intent);
    }
}
