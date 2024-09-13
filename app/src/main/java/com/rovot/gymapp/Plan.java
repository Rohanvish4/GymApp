package com.rovot.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

// Plan class representing a training plan with associated details
public class Plan implements Parcelable {
    private Training training;      // The training program associated with this plan
    private int minute;            // Duration of the training in minutes
    private String day;             // Day of the week for this plan
    private boolean isAccomplished; // Flag indicating if the plan is accomplished

    // Constructor to initialize a Plan object
    public Plan(Training training, int minute, String day, boolean isAccomplished) {
        this.training = training;
        this.minute = minute;
        this.day = day;
        this.isAccomplished = isAccomplished;
    }

    // Constructor used for creating objects from Parcel (for Parcelable implementation)
    protected Plan(Parcel in) {
        training = in.readParcelable(Training.class.getClassLoader()); // Read the Training object from the Parcel
        minute = in.readInt();
        day = in.readString();
        isAccomplished = in.readByte() != 0; // Read the boolean value from the Parcel
    }

    // Creator object required for Parcelable implementation
    // This creates Plan objects from Parcels and defines how to create arrays of Plan objects
    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    // Getter and setter methods for all fields
    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    // Overrides toString() method to provide a string representation of the Plan object
    @Override
    public String toString() {
        return "Plan{" +
                "training=" + training +
                ", minute=" + minute +
                ", day='" + day + '\'' +
                ", isAccomplished=" + isAccomplished +
                '}';
    }

    // Required methods for Parcelable implementation
    @Override
    public int describeContents() {
        return 0;
    }

    // Writes the Plan object's data to the Parcel for transferring between components
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(training, flags); // Write the Training object to the Parcel
        dest.writeInt(minute);
        dest.writeString(day);
        dest.writeByte((byte) (isAccomplished ? 1 : 0)); // Write the boolean value to the Parcel
    }
}