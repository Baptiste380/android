package com.example.lecoledesloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MultiplicationActivityResponse extends AppCompatActivity {

    public static String TABLE_MULT;
    public final static int TABLE_REQUEST = 0;

    private ArrayList<EditText> reponses;
    private TableMultiplication tableMultiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_math_multiplication_activity_response);

        String table = getIntent().getStringExtra(TABLE_MULT);
        TableMultiplication tableMultiplication = new TableMultiplication(Integer.parseInt(table));

        this.tableMultiplication = tableMultiplication;
        this.reponses = new ArrayList<EditText>();


        for(int i = 1; i <= this.tableMultiplication.getTableMultiplication().size(); i++)
        {
            LinearLayout linearLayoutPrincipal = findViewById(R.id.ex5_linearPrincip);

            LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);

            TextView ligne = (TextView) linearLayout.findViewById(R.id.template_calcul);
            ligne.setText(i+" x "+table+" = ");


            EditText rep = (EditText) linearLayout.findViewById(R.id.template_result);
            reponses.add(rep);

            linearLayoutPrincipal.addView(linearLayout);
        }
    }

    public void getResult(View view)
    {
        int nbError = 0;

        for(int i = 0; i < reponses.size(); i++)
        {
            String value = reponses.get(i).getText().toString();
            System.out.println("Réponse : "+i+" = "+value);

            if(!value.isEmpty())
            {
                int finalValue = Integer.parseInt(value);

                if(finalValue != this.tableMultiplication.getTableMultiplication().get(i).getResult())
                {
                    nbError++;
                }
            }
            else
            {
                nbError++;
            }
        }

        Intent intent = null;

        if(nbError > 0)
        {
            intent = new Intent(this,ErreurActivity.class);
            intent.putExtra(ErreurActivity.NB_ERROR, Integer.toString(nbError));
        }
        else
        {
            intent = new Intent(this,FelicitationActivity.class);
        }

        startActivity(intent);
    }

}
