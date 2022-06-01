package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ErreurActivity extends AppCompatActivity {

    public static String NB_ERROR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_math_multiplication_activity_erreur);

        String nbErreur = getIntent().getStringExtra(NB_ERROR);

        TextView afficheErreur = findViewById(R.id.erreur_nbErreur);
        afficheErreur.setText("Nombre d'erreurs : "+nbErreur);
    }

    public void corriger(View view)
    {
        super.finish();
    }

    public void autreTable(View view)
    {
        Intent intent = new Intent(this, MultiplicationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
