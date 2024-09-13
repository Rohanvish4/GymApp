package com.rovot.gymapp;

import android.content.Intent; // Import for starting new Activities
import android.os.Bundle; // Import for managing Activity state
import android.util.Log; // Import for logging messages (useful for debugging)
import android.view.View; // Import for handling Views and user interactions
import android.widget.Button; // Import for Button functionality

import androidx.appcompat.app.AppCompatActivity; // Import the base class for Activities

public class MainActivity extends AppCompatActivity { // Class definition for MainActivity

    private static final String TAG = ".MainActivity"; // A tag for logging, usually the class name

    private Button btnYourPlans, btnAllTrainings, btnAbout; // Declare Button variables

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Called when the Activity is created
        super.onCreate(savedInstanceState); // Call the superclass onCreate method
        setContentView(R.layout.activity_main); // Set the layout for this Activity

        initView(); // Call a method to initialize Views (find them in the layout)
        Utils.initTrainings(); // Call a method from the Utils class (likely to set up initial data)

        // Set click listeners for the Buttons (what happens when they are clicked)

        btnAllTrainings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Called when btnAllTrainings is clicked
                Log.d(TAG, "onClick: Plan Activity"); // Log a debug message
                Intent intent = new Intent(MainActivity.this, AllTrainingsActivity.class);
                // Create an Intent to start AllTrainingsActivity
                startActivity(intent); // Start the new Activity
            }
        });

        btnYourPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Called when btnYourPlans is clicked
                Intent intent = new Intent(MainActivity.this, PlanActivity.class);
                // Create an Intent to start PlanActivity
                startActivity(intent); // Start the new Activity
            }
        });

    }

    private void initView() { // Method to initialize Views
        Log.d(TAG, "initView: Started"); // Log a debug message
        btnYourPlans = findViewById(R.id.btnPlanActivity);
        // Find the Button with id btnPlanActivity and assign it to the variable
        btnAllTrainings = findViewById(R.id.btnAllActivity);
        // Find the Button with id btnAllActivity and assign it to the variable
        btnAbout = findViewById(R.id.btnAbout);
        // Find the Button with id btnAbout and assign it to the variable
    }
}