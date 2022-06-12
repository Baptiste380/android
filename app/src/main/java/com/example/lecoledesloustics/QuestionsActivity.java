package com.example.lecoledesloustics;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.example.lecoledesloustics.db.DatabaseClient;
import com.example.lecoledesloustics.db.Question;
import com.example.lecoledesloustics.db.User;
import com.example.lecoledesloustics.db.Score;
import com.example.lecoledesloustics.db.Matiere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private DatabaseClient db;
    private ListView listQuestion;
    private QuestionAdapter adapter;
    private String matiere;
    List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //questionList = new ArrayList<>();
        setContentView(R.layout.display_questions);

        Intent i = getIntent();

        db = DatabaseClient.getInstance(getApplicationContext());
        matiere = i.getStringExtra("MATIERE");

        listQuestion = findViewById(R.id.listQuestion);
        adapter = new QuestionAdapter(this, new ArrayList<Question>());
        listQuestion.setAdapter(adapter);

    }

    public void validate(View v) {
        HashMap<Integer,String> resultMap;


        resultMap = adapter.getResultMap();
        int score = 0;

        int i = 0;
        for (Question q : questionList) {
            String userReponse;
            userReponse = resultMap.get(i);
            System.out.println("Question: " + userReponse);
            System.out.println("Rep:" + q.getValidReponse());
            // check if user reponse not null
            if (userReponse != null) {
                if (userReponse.equals(q.getValidReponse())) {
                    score += 1;
                }
            }
            i++;
        }

        Matiere matiereObj = db.getAppDatabase().matiereDao().getByName(matiere);
        int numQuestions = questionList.size();

        if (AccountManager.getInstance().getId() > 0) {
            Score scoreObj = new Score();
            scoreObj.setTotalScore(score);
            scoreObj.setTotalQuestions(numQuestions);
            scoreObj.setMatiere(matiereObj.getId());
            scoreObj.setUser(AccountManager.getInstance().getId());
            db.getAppDatabase().scoreDao().insert(scoreObj);
        }

        Intent intent = new Intent(QuestionsActivity.this, ShowResultActivity.class);
        intent.putExtra("totalScore", score);
        intent.putExtra("totalQuestions", numQuestions);
        startActivity(intent);

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
                questionList = questions;
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
