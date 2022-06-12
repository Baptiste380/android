package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


import com.example.lecoledesloustics.db.User;
import com.example.lecoledesloustics.db.DatabaseClient;

public class ShowResultActivity extends AppCompatActivity {

    private DatabaseClient db;

    private TextView scoreView;
    private TextView totalQuestionsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_results);

        db = DatabaseClient.getInstance(getApplicationContext());

        int totalScore = getIntent().getIntExtra("totalScore", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestions", 0);

        //print score
        System.out.println("Total score: " + totalScore);
        System.out.println("Total questions: " + totalQuestions);

        scoreView = findViewById(R.id.score);
        totalQuestionsView = findViewById(R.id.total_questions);

        scoreView.setText(String.valueOf(totalScore));
        totalQuestionsView.setText(String.valueOf(totalQuestions));

    }

    public void otherExercice(View v) {
        Intent i = new Intent(ShowResultActivity.this, ChoixActivity.class);
        startActivity(i);
    }

    public void backToAccount(View v) {
        Intent i = new Intent(ShowResultActivity.this, UserAccountActivity.class);
        startActivity(i);
    }
}