package com.rovot.gymapp;

import static com.rovot.gymapp.TrainingActivity.TRAINING_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.ViewHolder> {

    // List of training objects to be displayed
    private ArrayList<Training> trainings = new ArrayList<>();
    // Context of the activity where the RecyclerView is used
    private Context context;

    // Constructor to initialize the context
    public TrainingAdapter(Context context) {
        this.context = context;
    }

    // Creates a new ViewHolder instance for each item in the RecyclerView
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each training item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_item, parent, false);
        return new ViewHolder(view);
    }

    // Binds data to the ViewHolder for a specific position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Set the training name and short description in the corresponding TextViews
        holder.txtName.setText(trainings.get(position).getName());
        holder.shortDescription.setText(trainings.get(position).getShortDescription());

        // Load the training image using Glide library
        Glide.with(context)
                .asBitmap()
                .load(trainings.get(position).getImageUrl())
                .into(holder.image);

        // Set a click listener on the parent CardView
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the TrainingActivity
                Intent intent = new Intent(context, TrainingActivity.class);

                // Pass the selected Training object to the TrainingActivity
                intent.putExtra(TRAINING_KEY, trainings.get(position));

                // Start the TrainingActivity
                context.startActivity(intent);
            }
        });
    }

    // Returns the total number of training items
    @Override
    public int getItemCount() {
        return trainings.size();
    }

    // Sets the list of trainings and notifies the adapter of data changes
    public void setTrainings(ArrayList<Training> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }

    // ViewHolder class to hold references to the UI elements of each training item
    public class ViewHolder extends RecyclerView.ViewHolder{
        private MaterialCardView parent;
        private ImageView image;
        private TextView txtName, shortDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent  = itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.image);
            txtName = itemView.findViewById(R.id.txtName);
            shortDescription = itemView.findViewById(R.id.shortDesc);
        }
    }
}