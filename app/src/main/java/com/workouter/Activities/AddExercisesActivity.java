package com.workouter.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddExercisesActivity extends AppCompatActivity {

    ListView listView;
    ExercisesHolder exercisesDataHolder;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_layout);
        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        listView = findViewById(R.id.exercisesList);
        exercisesDataHolder = ExercisesHolder.getInstance();



        intent = getIntent();
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
                setResult(RESULT_OK,intent);
                finish();

            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                setResult(RESULT_CANCELED, intent);
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }




}
