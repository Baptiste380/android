package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FelicitationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitation);
    }

    public void autreExercice(View v) {
        Intent intent = new Intent(FelicitationActivity.this, ChoixActivity.class );
        startActivity(intent);
    }

    public void retourAccueil(View v) {
        Intent intent = new Intent(FelicitationActivity.this, MainActivity.class );
        startActivity(intent);
    }
}