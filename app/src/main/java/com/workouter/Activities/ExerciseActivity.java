package com.workouter.Activities;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.workouter.Adapters.WeightAndRepsAdapter;
import com.workouter.Models.ExerciseModel;
import com.workouter.Models.WeightAndReps;
import com.workouter.R;
import com.workouter.WorkoutDataHolder;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    Button button1;
    List<WeightAndReps> weightAndRepsList;
    ExerciseModel exerciseModelList;
    WorkoutDataHolder workoutDataHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_layout);
        listView = (ListView)findViewById(R.id.kgrepsList);

        Intent intent = getIntent();
        int position_exercise = (int)intent.getSerializableExtra("position_exercise");
        int position_workout = (int)intent.getSerializableExtra("position_workout");


        workoutDataHolder = WorkoutDataHolder.getInstance();

        exerciseModelList = workoutDataHolder
                .getWorkouts().get(position_workout)
                .getExerciseModel().get(position_exercise);
        weightAndRepsList = exerciseModelList.getWeightAndRepsList();

        final WeightAndRepsAdapter weightAndRepsAdapter =
                new WeightAndRepsAdapter(this,R.id.kgrepsList, weightAndRepsList);

        TextView textView = (TextView)findViewById(R.id.exerciseName2);
        textView.setText(exerciseModelList.getExerciseName());
        listView.setAdapter(weightAndRepsAdapter);



        View footer = View.inflate(this, R.layout.footer_button,null);
        listView.addFooterView(footer,null,false);

        button = (Button)findViewById(R.id.button_addset);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                weightAndRepsAdapter.add(new WeightAndReps());
            }
        });
        button1 = (Button)findViewById(R.id.button_cancel);
        button1.setText("Finish");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}

