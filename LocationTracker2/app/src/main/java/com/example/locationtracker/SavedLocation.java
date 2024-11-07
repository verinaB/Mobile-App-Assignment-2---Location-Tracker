package com.example.locationtracker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "saved_location_table")
public class SavedLocation {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private double latitude;
    private double longitude;

    public SavedLocation(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
