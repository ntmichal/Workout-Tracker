package com.workouter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.workouter.Activities.ExerciseActivity;
import com.workouter.Models.WeightAndReps;
import com.workouter.Models.Workout;
import com.workouter.R;
import com.workouter.WorkoutDataHolder;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WeightAndRepsAdapter extends ArrayAdapter<WeightAndReps> {

    private List<WeightAndReps> exerciseModels;
    private int resourceLayout;
    Context mContext;
    Button addrepsButton;

    public WeightAndRepsAdapter(Context context, int resource, List<WeightAndReps> data ) {
        super(context, resource, data);
        this.exerciseModels = data;
        this.mContext = context;
        this.resourceLayout = resource;
    }



    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final WeightAndReps weightAndReps = getItem(position);
        View result = convertView;

        if (result == null) {
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(mContext);
            result = layoutInflater.inflate(R.layout.row_kg_rep, parent, false);
        }

        if(weightAndReps != null){

            TextView setAndRepId = (TextView)result.findViewById(R.id.repId);
            setAndRepId.setText(String.valueOf(position + 1));

            final TextView textView1 = (TextView)result.findViewById(R.id.kgNumber);
            final TextView textView2 = (TextView)result.findViewById(R.id.repNumber);

            final WorkoutDataHolder workoutDataHolder = WorkoutDataHolder.getInstance();

            textView1.setHint(Integer.toString(weightAndReps.getRepeats()));
//            textView1.setText();
            textView2.setHint(Integer.toString(weightAndReps.getWeight()));
//            textView2.setText();

            addrepsButton = (Button)result.findViewById(R.id.btn_addkgreps);
            addrepsButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int valWeight = Integer.parseInt(String.valueOf(textView1.getText()));
                    exerciseModels.get(position).setRepeats(valWeight);
                    int valReps = Integer.parseInt(String.valueOf(textView2.getText()));
                    exerciseModels.get(position).setWeight(valReps);
                }
            });
        }

        return result;


    }
}

