package com.rovot.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

// Training class representing a training program with details
public class Training implements Parcelable {
    private int id;             // Unique identifier for the training
    private String name;        // Name of the training
    private String shortDescription; // Short description of the training
    private String longDescription;  // Detailed description of the training
    private String imageUrl;     // URL of the training image

    // Constructor to initialize a Training object
    public Training(int id, String name, String shortDescription, String longDescription, String imageUrl) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.imageUrl = imageUrl;
    }

    // Constructor used for creating objects from Parcel (for Parcelable implementation)
    protected Training(Parcel in) {
        id = in.readInt();
        name = in.readString();
        shortDescription = in.readString();
        longDescription = in.readString();
        imageUrl = in.readString();
    }

    // Creator object required for Parcelable implementation
    // This creates Training objects from Parcels and defines how to create arrays of Training objects
    public static final Creator<Training> CREATOR = new Creator<Training>() {
        @Override
        public Training createFromParcel(Parcel in) {
            return new Training(in);
        }

        @Override
        public Training[] newArray(int size) {
            return new Training[size];
        }
    };

    // Getter and setter methods for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Overrides toString() method to provide a string representation of the Training object
    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    // Required methods for Parcelable implementation
    @Override
    public int describeContents() {
        return 0;
    }

    // Writes the Training object's data to the Parcel for transferring between components
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(shortDescription);
        dest.writeString(longDescription);
        dest.writeString(imageUrl);
    }
}