package com.example.locationtracker;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class SavedLocationViewModel extends AndroidViewModel {
    private SavedLocationRepository repository;
    private LiveData<List<SavedLocation>> allLocations;

    public SavedLocationViewModel(@NonNull Application application) {
        super(application);
        repository = new SavedLocationRepository(application);
        allLocations = repository.getAllLocations();
    }

    // Insert a new location
    public void insert(SavedLocation location) {
        repository.insert(location);
    }

    // Update an existing location
    public void update(SavedLocation location) {
        repository.update(location); // Add this method to call the repository's update method
    }

    // Delete a specific location
    public void delete(SavedLocation location) {
        repository.delete(location); // Add this method to call the repository's delete method
    }

    // Retrieve all locations
    public LiveData<List<SavedLocation>> getAllLocations() {
        return allLocations;
    }
}
