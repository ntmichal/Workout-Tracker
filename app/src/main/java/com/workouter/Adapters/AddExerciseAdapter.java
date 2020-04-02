package com.workouter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.workouter.ExercisesHolder;
import com.workouter.Models.ExerciseTemplate;
import com.workouter.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AddExerciseAdapter extends ArrayAdapter<ExerciseTemplate> {

    Context mContext;
    public AddExerciseAdapter(Context context, int resource, List<ExerciseTemplate> exerciseTemplateList){
        super(context,resource,exerciseTemplateList);
        this.mContext = context;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ExerciseTemplate exerciseTemplate = ExercisesHolder.getInstance().getExerciseByPosition(position);
        View result = convertView;
        if (result == null) {
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(mContext);
            result = layoutInflater.inflate(R.layout.row_item_exercise, parent, false);
        }

        if(exerciseTemplate != null){
            TextView textView1 = (TextView) result.findViewById(R.id.exerciseName);
            textView1.setText(exerciseTemplate.getName());
        }

        return result;

    }
}
