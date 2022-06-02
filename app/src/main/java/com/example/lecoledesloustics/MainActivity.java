package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lecoledesloustics.db.User;
import com.example.lecoledesloustics.db.DatabaseClient;
import com.example.lecoledesloustics.CreateAccount;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseClient db;
    private UsersAdapter adapter;
    private ListView listUser;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DatabaseClient.getInstance(getApplicationContext());

        listUser = findViewById(R.id.listUser);
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);
        registerButton = findViewById(R.id.inscription_button);

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = adapter.getItem(position);
                Toast.makeText(MainActivity.this, "Connected as " + user.getName() , Toast.LENGTH_SHORT).show();
                AccountManager.getInstance().setValue(user.getName());
                Intent intent = new Intent(MainActivity.this, ChoixActivity.class );
                startActivity(intent);
            }

        });

    }

    public void pageInscription(View view) {
        Intent intent = new Intent(MainActivity.this, CreateAccount.class );
        startActivity(intent);
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