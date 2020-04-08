package com.workouter.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;



import com.workouter.Adapters.ExerciseAdapter;
import com.workouter.Dialog.MyAlertDialog;
import com.workouter.Models.ExerciseModel;
import com.workouter.Models.WeightAndReps;
import com.workouter.Models.Workout;
import com.workouter.R;
import com.workouter.WorkoutDataHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class WorkoutActivity  extends AppCompatActivity {
    ListView listView;
    Button button;
    Button buttonFinish;
    WorkoutDataHolder workoutDataHolder;
    List<ExerciseModel> exerciseModel;
    ExerciseAdapter workoutAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_layout);

        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
//        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        listView = (ListView)findViewById(R.id.exercisesList);

        final Intent intent = getIntent();
        final int position_workout = (int)intent.getSerializableExtra("position_workout");

        workoutDataHolder = WorkoutDataHolder.getInstance();
        exerciseModel = workoutDataHolder.getWorkout(position_workout).getExerciseModel();
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

                Intent intent1 = new Intent(WorkoutActivity.this,AddExercisesActivity.class);
                intent1.putExtra("position_workout", position_workout);
                startActivityForResult(intent1,1);

            }
        });

        buttonFinish = findViewById(R.id.button_cancel);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////
//        getMenuInflater().inflate(R.layout.custom_toolbar);
////
//        return super.onCreateOptionsMenu(menu);
//
//    }

    void openDialog(){
        MyAlertDialog myAlertDialog = new MyAlertDialog();
        myAlertDialog.show(getSupportFragmentManager(),"alert");

    }


}
