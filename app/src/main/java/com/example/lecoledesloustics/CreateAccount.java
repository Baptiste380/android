package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.lecoledesloustics.db.User;
import com.example.lecoledesloustics.db.DatabaseClient;

import org.w3c.dom.Text;

public class CreateAccount extends AppCompatActivity {

    private DatabaseClient db;

    private EditText firstNameInput;
    private EditText lastNameInput;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        db = DatabaseClient.getInstance(getApplicationContext());

        firstNameInput = findViewById(R.id.inscription_prenom);
        lastNameInput = findViewById(R.id.inscription_nom);
        createButton = findViewById(R.id.createButton);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }

    private void createUser() {
        String firstName = firstNameInput.getText().toString().trim();
        String lastName = lastNameInput.getText().toString().trim();

        if(firstName.isEmpty() || lastName.isEmpty()) {
            return;
        }

        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {
                User u = new User();
                u.setFirstName(firstName);
                u.setLastName(lastName);
                db.getAppDatabase().userDao().insert(u);
                return u;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);
                setResult(RESULT_OK);
                finish();
            }
        }

        SaveUser su = new SaveUser();
        su.execute();

    }
}