package com.workouter.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.workouter.Adapters.AddExerciseAdapter;
import com.workouter.Adapters.WorkoutAdapter;
import com.workouter.ExercisesHolder;
import com.workouter.Models.ExerciseModel;
import com.workouter.Models.ExerciseTemplate;
import com.workouter.R;
import com.workouter.WorkoutDataHolder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import androidx.appcompat.app.AppCompatActivity;

public class AddExercisesActivity extends AppCompatActivity {

    ListView listView;
    ExercisesHolder exercisesDataHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.workout_layout);
        listView = findViewById(R.id.exercisesList);
        exercisesDataHolder = ExercisesHolder.getInstance();

        final Intent intent = getIntent();
        final int position_workout = (int)intent.getSerializableExtra("position_workout");
        final List<ExerciseTemplate> exerciseTemplateList = exercisesDataHolder.getExerciseTemplateList();
        final AddExerciseAdapter addExerciseAdapter = new AddExerciseAdapter(this,R.id.exercisesList, exerciseTemplateList);
        listView.setAdapter(addExerciseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WorkoutDataHolder
                        .getInstance()
                        .getWorkouts()
                        .get(position_workout)
                        .addExercise(new ExerciseModel(0,ExercisesHolder.getInstance().getExerciseByPosition(position).getName()));
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();

            }
        });

    }

}
