package com.rovot.gymapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AllTrainingsActivity extends AppCompatActivity {

    // RecyclerView to display the list of trainings
    private RecyclerView recyclerView;
    // Adapter for the RecyclerView
    private TrainingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trainings);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the adapter
        adapter = new TrainingAdapter(this);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);

        // Set the layout manager for the RecyclerView (GridLayoutManager with 2 columns)
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Get the list of trainings from the Utils class
        ArrayList<Training> trainings = Utils.getTrainings();

        // Set the trainings in the adapter if available
        if(trainings != null){
            adapter.setTrainings(trainings);
        }
    }
}