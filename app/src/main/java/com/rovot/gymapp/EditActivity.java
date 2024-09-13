package com.rovot.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanAdapter.RemovePlan {


    private TextView txtDay;
    private RecyclerView recyclerView;
    private Button btnAddPlan;

    private PlanAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        initView();

        adapter = new PlanAdapter(this);
        adapter.setType("edit");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();

        if(intent != null){
            String day = intent.getStringExtra("day");

            if(day != null){
                txtDay.setText(day);

                ArrayList<Plan> plans = getPlansByDay(day);
                adapter.setPlans(plans);
            }

        }

        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EditActivity.this, AllTrainingsActivity.class);
                // Clear existing tasks and start a new task for AllTrainingsActivity
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

    private ArrayList<Plan> getPlansByDay(String day) {
        ArrayList<Plan> plans = new ArrayList<>();
        ArrayList<Plan> allPlans = Utils.getPlans();
        for (Plan plan : allPlans) {
            if (plan.getDay().equalsIgnoreCase(day)) {
                plans.add(plan);
            }
        }
        return plans;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, PlanActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }

    private void initView() {

        txtDay = findViewById(R.id.txtDay);
        recyclerView = findViewById(R.id.recyclerView);
        btnAddPlan = findViewById(R.id.btnAddPlan);
    }

    @Override
    public void onRemovePlanResult(Plan plan) {
        if(Utils.removePlan(plan)){
            Toast.makeText(this, "Training Removed", Toast.LENGTH_SHORT).show();
            adapter.setPlans(getPlansByDay(plan.getDay()));
        }
    }
}