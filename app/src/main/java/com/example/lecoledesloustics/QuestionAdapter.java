package com.example.lecoledesloustics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import com.example.lecoledesloustics.db.Question;

public class QuestionAdapter extends ArrayAdapter<Question> {

    public QuestionAdapter(Context mCtx, List<Question> questionList) {
        super(mCtx, R.layout.question_template, questionList);
    }

    /**
     * Remplit une ligne de la listView avec les informations de la multiplication associée
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération de la multiplication
        final Question question = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.question_template, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewTask = (TextView) rowView.findViewById(R.id.question_name);

        //
        textViewTask.setText(question.getName());

        String[] rep = question.getReponseArr();

        System.out.println(Arrays.toString(rep));

        RadioButton elem0 = rowView.findViewById(R.id.rep0);
        RadioButton elem1 = rowView.findViewById(R.id.rep1);
        RadioButton elem2 =  rowView.findViewById(R.id.rep2);



        elem0.setText(String.valueOf(Arrays.asList().indexOf(0)));
        elem1.setText(String.valueOf(Arrays.asList().indexOf(1)));
        elem2.setText(String.valueOf(Arrays.asList().indexOf(2)));

        //
        return rowView;
    }

}