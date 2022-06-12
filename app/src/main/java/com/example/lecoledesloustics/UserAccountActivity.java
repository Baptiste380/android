package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lecoledesloustics.db.Question;
import com.example.lecoledesloustics.db.User;
import com.example.lecoledesloustics.db.Score;
import com.example.lecoledesloustics.db.DatabaseClient;
import com.example.lecoledesloustics.CreateAccount;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import android.widget.TextView;
import android.widget.Toast;

public class UserAccountActivity extends AppCompatActivity {

    private DatabaseClient db;
    private TextView userName;
    private ListView scoreList;
    private ScoreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_account);
        scoreList = findViewById(R.id.listScore);
        adapter = new ScoreAdapter(this, new ArrayList<Score>());
        scoreList.setAdapter(adapter);

        db = DatabaseClient.getInstance(getApplicationContext());
        userName = findViewById(R.id.user_name);

    }

    public void back(View view) {
        finish();
    }

    public void play(View view) {
        Intent intent = new Intent(UserAccountActivity.this, ChoixActivity.class );
        startActivity(intent);
    }

    private void getUser() {
        class GetUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {
                //print stored user id
                User user_ = db.getAppDatabase().userDao().get(AccountManager.getInstance().getId());
                return user_;
            }

            @Override
            protected void onPostExecute(User user_) {
                super.onPostExecute(user_);
                userName.setText(user_.getFullName());
            }
        }
        GetUser gu = new GetUser();
        gu.execute();
    }

    private void getScores() {
        class GetScores extends AsyncTask<Void, Void, List<Score>> {

            @Override
            protected List<Score> doInBackground(Void... voids) {
                //print stored user id
                List<Score> scoreList = db.getAppDatabase().scoreDao().getScoresFromUser(AccountManager.getInstance().getId());
                return scoreList;
            }

            @Override
            protected void onPostExecute(List<Score> scoreList) {
                super.onPostExecute(scoreList);
                adapter.clear();
                adapter.addAll(scoreList);
            }
        }
        GetScores gs = new GetScores();
        gs.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getUser();
        getScores();
    }

}