package com.workouter.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.workouter.Adapters.WorkoutAdapter;
import com.workouter.Models.Workout;
import com.workouter.R;
import com.workouter.WorkoutDataHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    WorkoutDataHolder workoutDataHolder;
    WorkoutAdapter workoutAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);

        workoutDataHolder = WorkoutDataHolder.getInstance();


        final ArrayList<Workout> arrayList = (ArrayList)workoutDataHolder.getWorkouts();
        ArrayAdapter arrarAdapter
                = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);



        workoutAdapter = new WorkoutAdapter(this, R.id.listView, arrayList);

        listView.setAdapter(workoutAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                openDialog(position);
            }
        });

        FloatingActionButton createNewWorkout = findViewById(R.id.createNewWorkout);
        createNewWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateWorkoutDialog();
            }
        });
    }

    public void openDialog(final int position){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_startworkout);
        dialog.getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
        dialog.show();

        Button btnCancel = dialog.findViewById(R.id.btnDialogCancelWorkout);
        Button btnStart = dialog.findViewById(R.id.btnDialogStartWorkout);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appInfo = new Intent(MainActivity.this, WorkoutActivity.class);
                WorkoutDataHolder.getInstance().startNewWorkout(position);
                appInfo.putExtra("position_workout", position);
                startActivity(appInfo);
                dialog.cancel();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        TextView textView = dialog.findViewById(R.id.workoutName);
        String elo = WorkoutDataHolder.getInstance().getWorkout(position).getWorkoutName();
        textView.setText(elo);
    }

    public void openCreateWorkoutDialog(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_createworkout);
        dialog.getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        dialog.show();

        Button btnCancel = dialog.findViewById(R.id.btnDialogCancelCreateWorkout);
        Button btnStart = dialog.findViewById(R.id.btnDialogCreateWorkout);
        final EditText workoutNameEditText = dialog.findViewById(R.id.workoutNameEditText);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutDataHolder
                        .getInstance()
                        .builder()
                        .setName(workoutNameEditText.getText().toString())
                        .build();
                workoutAdapter.notifyDataSetChanged();
                dialog.cancel();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

    }
}
