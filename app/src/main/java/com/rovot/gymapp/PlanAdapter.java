package com.rovot.gymapp;

import static com.rovot.gymapp.TrainingActivity.TRAINING_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {

    public interface RemovePlan{
        void onRemovePlanResult(Plan plan);
    }

    private RemovePlan removePlan;

    private ArrayList<Plan> plans = new ArrayList<>();
    private Context context;

    private  String type = "";


    public PlanAdapter(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.txtName.setText(plans.get(position).getTraining().getName());
        holder.txtTime.setText(String.valueOf(plans.get(position).getMinute()));
        holder.txtDescription.setText(plans.get(position).getTraining().getShortDescription());
        Glide.with(context)
                .asBitmap()
                .load(plans.get(position).getTraining().getImageUrl())
                .into(holder.imgTrainingImage);

        if(plans.get(position).isAccomplished()){
            holder.imgCheckedCircle.setVisibility(View.VISIBLE);
            holder.imgEmptyCircle.setVisibility(View.GONE);
        }else {
            holder.imgCheckedCircle.setVisibility(View.GONE);
            holder.imgEmptyCircle.setVisibility(View.VISIBLE);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TrainingActivity.class);
                intent.putExtra(TRAINING_KEY, plans.get(position).getTraining());
                context.startActivity(intent);
            }
        });

        if(type.equals("edit")){
            holder.imgEmptyCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Finished");
                    builder.setMessage("Have you finished this training " + plans.get(position).getTraining().getName() + " ?");
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for(Plan p: Utils.getPlans()){
                                if(p.equals(plans.get(position))){
                                    p.setAccomplished(true);
                                }
                            }
                            notifyDataSetChanged();

                        }
                    });
                    builder.create().show();


                }
            });

            holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Delete");
                    builder.setMessage("Are you sure you want to delete this training " + plans.get(position).getTraining().getName() + " ?");
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           try {
                               removePlan = (RemovePlan) context;
                               removePlan.onRemovePlanResult(plans.get(position));
                           }catch (Exception e){
                               Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                           }
                        }
                    });
                    builder.create().show();
                    return true;
                }
            });


        }



    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private MaterialCardView parent;
        private ImageView imgCheckedCircle, imgEmptyCircle, imgTrainingImage;
        private TextView txtName, txtTimeDescription, txtTime, txtDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgCheckedCircle = itemView.findViewById(R.id.checkedCircle);
            imgEmptyCircle = itemView.findViewById(R.id.emptyCircle);
            imgTrainingImage = itemView.findViewById(R.id.trainingImage);
            txtName = itemView.findViewById(R.id.txtName);
            txtTimeDescription = itemView.findViewById(R.id.txtTimeDescription);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtDescription = itemView.findViewById(R.id.txtDescription);

        }
    }
}
