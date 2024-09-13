package com.rovot.gymapp;

import static com.rovot.gymapp.TrainingActivity.TRAINING_KEY; // Import the key used to pass Training objects

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

// PlanDetailDialog is a DialogFragment that allows users to create a new training plan.
public class PlanDetailDialog extends DialogFragment {

    // Interface to pass the created Plan back to the hosting Activity (e.g., TrainingActivity)
    public interface PassPlanInterface{
        void getPlan(Plan plan); // Method to receive the created Plan object
    }

    private PassPlanInterface passPlanInterface; // Instance of the interface to communicate with the hosting Activity

    // UI elements of the dialog
    private Button btnAdd, btnDismiss;
    private EditText edtTxtMinutes;
    private Spinner spinnerDay;
    private TextView txtName; // TextView to display the name of the Training

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Inflate the dialog's layout (dialog_plan_details.xml)
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_plan_details, null);

        // Initialize the UI elements
        initView(view);

        // Create an AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Enter Details");

        // Retrieve the Training object passed as an argument from the hosting Activity
        Bundle bundle = getArguments();
        if(bundle != null){
            Training training = bundle.getParcelable(TRAINING_KEY); // Get the Training object using the TRAINING_KEY
            if(null != training){
                // Set the training name in the TextView
                txtName.setText(training.getName()); // Get the name from the Training object

                // Set click listener for the Dismiss button
                btnDismiss.setOnClickListener(v -> dismiss()); // Simply dismiss the dialog

                // Set click listener for the Add button
                btnAdd.setOnClickListener(v -> {
                    // Get selected day and minutes from UI
                    String day = spinnerDay.getSelectedItem().toString();
                    int minutes = Integer.parseInt(edtTxtMinutes.getText().toString());

                    // Create a new Plan object using the Training object, day, and minutes
                    Plan plan = new Plan(training, minutes, day, false);

                    try {
                        // Pass the created Plan back to the hosting Activity
                        passPlanInterface  = (PassPlanInterface) getActivity(); // Get the hosting Activity and cast it to PassPlanInterface
                        passPlanInterface.getPlan(plan); // Call the getPlan method of the interface to pass the Plan object
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        dismiss(); // Dismiss the dialog if there is a ClassCastException
                    }
                });
            }
        }
        // Create and return the AlertDialog
        return builder.create();
    }

    // Initialize the UI elements of the dialog
    private void initView(View view) {
        btnDismiss = view.findViewById(R.id.btnDismiss);
        btnAdd = view.findViewById(R.id.btnAdd);
        edtTxtMinutes = view.findViewById(R.id.edtTxtMinutes);
        spinnerDay = view.findViewById(R.id.spinnerDay);
        txtName = view.findViewById(R.id.txtName);
    }
}