package com.workouter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.workouter.Models.Workout;
import com.workouter.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WorkoutAdapter extends ArrayAdapter<Workout>  {

    private ArrayList<Workout> exerciseModels;
    private int resourceLayout;
    Context mContext;

    public WorkoutAdapter(Context context, int resource, ArrayList<Workout> data ) {
        super(context, resource, data);
        this.exerciseModels = data;
        this.mContext = context;
        this.resourceLayout = resource;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Workout workoutData = getItem(position);
        View result = convertView;

        if (result == null) {
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(mContext);
            result = layoutInflater.inflate(R.layout.row_item, parent, false);
        }

        if(workoutData != null){
            TextView textView1 = (TextView) result.findViewById(R.id.name);

            textView1.setText(workoutData.getWorkoutName());

        }

        return result;
    }

}
