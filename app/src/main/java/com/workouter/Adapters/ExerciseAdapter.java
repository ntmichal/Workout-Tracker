package com.workouter.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.workouter.Models.ExerciseModel;
import com.workouter.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ExerciseAdapter  extends ArrayAdapter<ExerciseModel> {

    private List<ExerciseModel> exerciseModels;
    private int resourceLayout;
    Context mContext;

    public ExerciseAdapter(Context context, int resource, List<ExerciseModel> data ) {
        super(context, resource, data);
        this.exerciseModels = data;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ExerciseModel exerciseData = getItem(position);
        View result = convertView;

        if (result == null) {
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(mContext);
            result = layoutInflater.inflate(R.layout.row_item_exercise, parent, false);
        }

        if(exerciseData != null){
            TextView textView1 = (TextView) result.findViewById(R.id.exerciseName);
            textView1.setText(exerciseData.getExerciseName());
        }

        return result;
    }
}
