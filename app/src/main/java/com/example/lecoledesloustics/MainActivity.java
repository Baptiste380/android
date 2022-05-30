package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lecoledesloustics.db.User;
import com.example.lecoledesloustics.db.DatabaseClient;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseClient db;
    private UsersAdapter adapter;
    private ListView listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DatabaseClient.getInstance(getApplicationContext());

        listUser = findViewById(R.id.listUser);
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);



    }




}