package com.rovot.gymapp;

import java.util.ArrayList;

// Utility class for managing training and plan data
public class Utils {
    private static ArrayList<Training> trainings; // List of available training programs
    private static final String TAG = "Utils"; // Tag for logging
    private static ArrayList<Plan> plans; // List of user's planned trainings

    // Initializes the list of training programs with sample data
    public static void initTrainings(){
        if(trainings == null){
            trainings = new ArrayList<>(); // Create a new ArrayList if it's not initialized
        }

        // Create Training objects with sample data (id, name, short description, long description, image URL)
        Training pushUp = new Training(1, "Push up", "An exercise in which a person lies facing the floor...",
                "The definition of a push-up is an exercise done laying with face, palms and toes facing down...",
                "https://www.istreetwatch.co.uk/wp-content/uploads/2019/01/push-ups.jpg");
        trainings.add(pushUp); // Add the Training object to the list

        Training squat = new Training(2, "Squat", "If you crouch down very low and sit on your heels...",
                "A squat is a strength exercise in which the trainee lowers their hips from a standing position...",
                "https://lmimirror3pvr.azureedge.net/static/media/16949/921e38e6-9020-4dd9-a619-7726cadc7284/fit-planet-60-hero-image-960x540.jpg");
        trainings.add(squat);

        Training legPress = new Training(3, "Leg Press", "The leg press is a weight training exercise...",
                "The leg press is a weight training exercise in which the individual pushes a weight or resistance...",
                "https://www.fitnessfactoryoutlet.com/images/products/14392.png");
        trainings.add(legPress);

        Training pectorals = new Training(4, "Pectorals", "Amazing for building chest muscles",
                "Your pectoral muscles are one of the largest muscle groups in your upper body...",
                "https://www.korrukmag.com/wp-content/uploads/2019/11/2756-serious-man-training-upper-body-using-fly-machine-1060869384-0effce7eff3044289055fcd16a9c6788.jpg");
        trainings.add(pectorals);

        Training pullUps = new Training(5, "Pull-ups", "An exercise involving raising oneself with one's arms...",
                "A pull-up is an upper-body strength exercise...",
                "https://www.fititnow.com/wp-content/uploads/2020/02/3-Simple-Tips-To-Improve-Your-Pull-Ups.jpg");
        trainings.add(pullUps);
    }

    // Returns the list of training programs
    public static ArrayList<Training> getTrainings() {
        return trainings;
    }

    // Adds a new plan to the list of plans
    public static boolean addPlan(Plan plan){
        if(plans == null){
            plans = new ArrayList<>(); // Create a new ArrayList if it's not initialized
        }
        return plans.add(plan); // Add the plan to the list and return true if successful
    }

    // Returns the list of user's planned trainings
    public static ArrayList<Plan> getPlans() {
        return plans;
    }

    public static  boolean removePlan(Plan plan) {
        return plans.remove(plan);
    }

}