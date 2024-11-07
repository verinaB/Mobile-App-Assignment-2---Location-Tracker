package com.example.locationtracker;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SavedLocationDao {

    @Insert
    void insert(SavedLocation location);

    @Update
    void update(SavedLocation location); // This ensures Room can generate the update method

    @Delete
    void delete(SavedLocation location);

    @Query("SELECT * FROM saved_location_table")
    LiveData<List<SavedLocation>> getAllLocations(); // Return LiveData for observing changes
}
