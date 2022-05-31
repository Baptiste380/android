package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class MultiplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.exercice_math_multiplication_activity);

        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
    }

    public void exercice5Valider(View view) {
        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        String table;
        table = Integer.toString(numberPicker.getValue());
        System.out.println(table);

        Intent intent = new Intent(this, MultiplicationActivityResponse.class);
        intent.putExtra(MultiplicationActivityResponse.TABLE_MULT, table);

        startActivity(intent);
    }
}

