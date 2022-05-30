package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lecoledesloustics.db.User;
import com.example.lecoledesloustics.db.DatabaseClient;
import com.example.lecoledesloustics.CreateAccount;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseClient db;
    private UsersAdapter adapter;
    private ListView listUser;
    private Button registerButton;
    private static final int REQUEST_CODE_ADD = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DatabaseClient.getInstance(getApplicationContext());

        listUser = findViewById(R.id.listUser);
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);
        registerButton = findViewById(R.id.inscription_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAccount.class );
                startActivity(intent);
            }
        });

    }

    private void getUsers() {
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = db.getAppDatabase().userDao().getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);
                adapter.clear();
                adapter.addAll(users);
            }

        }
        GetUsers gu = new GetUsers();
        gu.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        getUsers();
    }



}