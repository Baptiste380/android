package com.example.lecoledesloustics;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RelativeLayout;

public class Accueil {
    btninsert = (Button)findViewById(R.id.createButton);
    btninsert.setOnClickListener( new View.OnClickListener() {
        public void onClick(View v) {
            insertValues();
            EditText userName = (EditText) findViewById(R.id.editText1);

            if( userName.getText().toString().length() == 0 )
                userName.setError( "First name is required!" );

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
        }
    });

}
    public void bouton(View view) {
        // On récupére les objets de l'arbre graphique (à l'aide de leur id)
        TextView helloView = findViewById(R.id.exercice1_hello);
        EditText prenomView = findViewById(R.id.exercice1_prenom);
// On affiche le message si un prénom a été défini
        if (!TextUtils.isEmpty(prenomView.getText())) {
            helloView.setText("Hello " +prenomView.getText());
        }
    }
