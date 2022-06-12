package com.example.lecoledesloustics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.lecoledesloustics.db.Score;

public class ScoreAdapter extends ArrayAdapter<Score> {

    public ScoreAdapter(Context mCtx, List<Score> scoreList) {
        super(mCtx, R.layout.template_user, scoreList);
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
        final Score score = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_score, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewScore = (TextView) rowView.findViewById(R.id.score);
        TextView total_questions = (TextView) rowView.findViewById(R.id.total_questions);

        //
        textViewScore.setText(String.valueOf(score.getTotalScore()));
        total_questions.setText(String.valueOf(score.getTotalQuestions()));

        //
        return rowView;
    }

}