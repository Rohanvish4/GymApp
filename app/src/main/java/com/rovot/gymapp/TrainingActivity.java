package com.rovot.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements PlanDetailDialog.PassPlanInterface {
    private static final String TAG = ".TrainingActivity";
    public static final String TRAINING_KEY = "training";

    // UI elements
    private Button btnAddToPlans;
    private TextView txtTrainingName, txtLongDescription;
    private ImageView imgTraining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        // Initialize UI elements
        initView();

        // Retrieve Training object from Intent
        Intent intent  = getIntent();
        if(intent != null){
            Training training = intent.getParcelableExtra(TRAINING_KEY);
            if(training != null){
                // Set training details in UI elements
                txtTrainingName.setText(training.getName());
                txtLongDescription.setText(training.getLongDescription());
                Glide.with(this)
                        .asBitmap()
                        .load(training.getImageUrl())
                        .into(imgTraining);

                // Set click listener for "Add to Plans" button
                btnAddToPlans.setOnClickListener(v -> {
                    // Create and show PlanDetailDialog
                    PlanDetailDialog dialog = new PlanDetailDialog();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(TRAINING_KEY, training);
                    dialog.setArguments(bundle);
                    dialog.show(getSupportFragmentManager(), "Plan Detail Dialog");
                });
            }
        }
    }

    // Initialize UI elements
    private void initView() {
        Log.d(TAG, "initView: started");
        btnAddToPlans = findViewById(R.id.btnAddToPlan);
        txtTrainingName = findViewById(R.id.txtTrainingName);
        txtLongDescription = findViewById(R.id.txtLongDescription);
        imgTraining = findViewById(R.id.imgTraining);
    }

    // Implementation of PassPlanInterface method
    @Override
    public void getPlan(Plan plan) {
        Log.d(TAG, "getPlan: Plan" + plan.toString());

        // Add plan to Utils and show Toast message
        if(Utils.addPlan(plan)){
            Toast.makeText(this, plan.getTraining().getName() + " added to plans", Toast.LENGTH_SHORT).show();

            // Start PlanActivity and clear previous activities
            Intent intent = new Intent(this, PlanActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}