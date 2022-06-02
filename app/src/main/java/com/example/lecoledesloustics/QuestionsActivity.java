package com.example.lecoledesloustics;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.lecoledesloustics.db.DatabaseClient;
import com.example.lecoledesloustics.db.Question;
import com.example.lecoledesloustics.db.User;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private DatabaseClient db;
    private ListView listQuestion;
    private QuestionAdapter adapter;
    private String matiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_questions);

        Intent i = getIntent();

        db = DatabaseClient.getInstance(getApplicationContext());
        matiere = i.getStringExtra("MATIERE");

        listQuestion = findViewById(R.id.listQuestion);
        adapter = new QuestionAdapter(this, new ArrayList<Question>());
        listQuestion.setAdapter(adapter);

    }

    private void getQuestions() {
        class GetQuestions extends AsyncTask<Void, Void, List<Question>> {

            @Override
            protected List<Question> doInBackground(Void... voids) {
                List<Question> questionList = db.getAppDatabase().questionDao().getQuestionbyMatiere(matiere);
                return questionList;
            }

            @Override
            protected void onPostExecute(List<Question> questions) {
                super.onPostExecute(questions);
                adapter.clear();
                adapter.addAll(questions);
            }

        }
        GetQuestions gq = new GetQuestions();
        gq.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        getQuestions();
    }


}