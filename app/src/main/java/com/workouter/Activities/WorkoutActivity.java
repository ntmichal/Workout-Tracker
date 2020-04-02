package com.workouter.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.workouter.Adapters.ExerciseAdapter;
import com.workouter.Models.ExerciseModel;
import com.workouter.Models.WeightAndReps;
import com.workouter.Models.Workout;
import com.workouter.R;
import com.workouter.WorkoutDataHolder;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity  extends AppCompatActivity {
    ListView listView;
    Button button;
    WorkoutDataHolder workoutDataHolder;
    List<ExerciseModel> exerciseModel;
    ExerciseAdapter workoutAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_layout);
        listView = (ListView)findViewById(R.id.exercisesList);

        final Intent intent = getIntent();
        final int position_workout = (int)intent.getSerializableExtra("position_exercise");

        workoutDataHolder = WorkoutDataHolder.getInstance();
        exerciseModel = workoutDataHolder.getWorkouts().get(position_workout).getExerciseModel();
        if(exerciseModel == null){
            return;
        }


        workoutAdapter = new ExerciseAdapter(this, R.id.exercisesList, exerciseModel);
        listView.setAdapter(workoutAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent appInfo = new Intent(WorkoutActivity.this, ExerciseActivity.class);

                if(exerciseModel != null) {
                    appInfo.putExtra("position_workout", position_workout);
                    appInfo.putExtra("position_exercise", position);
                    startActivity(appInfo);
                }

            }
        });


        View footer = View.inflate(this, R.layout.footer_button, null);
        listView.addFooterView(footer,null,false);
        button = (Button)findViewById(R.id.button_addset);
        button.setText("ADD EXERCISE");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//there open exercises list to add to workout, send position_exercise
                Intent intent1 = new Intent(WorkoutActivity.this,AddExercisesActivity.class);
                intent1.putExtra("position_workout", position_workout);
                startActivityForResult(intent1,1);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                workoutAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
