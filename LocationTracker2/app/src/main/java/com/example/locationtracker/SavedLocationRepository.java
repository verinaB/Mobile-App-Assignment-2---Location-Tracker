package com.example.locationtracker;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SavedLocationRepository {
    private final SavedLocationDao savedLocationDao;
    private final LiveData<List<SavedLocation>> allLocations;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public SavedLocationRepository(Application application) {
        SavedLocationDatabase database = SavedLocationDatabase.getInstance(application);
        savedLocationDao = database.savedLocationDao();
        allLocations = savedLocationDao.getAllLocations();
    }

    // Insert a location into the database
    public void insert(SavedLocation location) {
        executorService.execute(() -> savedLocationDao.insert(location));
    }

    // Update an existing location in the database
    public void update(SavedLocation location) {
        executorService.execute(() -> savedLocationDao.update(location));
    }

    // Delete a specific location from the database
    public void delete(SavedLocation location) {
        executorService.execute(() -> savedLocationDao.delete(location));
    }

    // Retrieve all locations from the database
    public LiveData<List<SavedLocation>> getAllLocations() {
        return allLocations;
    }
}
