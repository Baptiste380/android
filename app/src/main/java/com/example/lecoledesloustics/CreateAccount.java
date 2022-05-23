package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lecoledesloustics.db.DatabaseClient;

public class CreateAccount extends AppCompatActivity {

    private DatabaseClient db;

    private EditText editTextNameInput;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        db = DatabaseClient.getInstance(getApplicationContext());

        editTextNameInput = findViewById(R.id.editTextNameInput);
        createButton = findViewById(R.id.createButton);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void createUser() {
        String name = editTextNameInput.getText().toString().trim();
    }
}