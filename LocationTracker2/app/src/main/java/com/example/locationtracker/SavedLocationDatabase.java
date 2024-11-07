package com.example.locationtracker;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SavedLocation.class}, version = 1)
public abstract class SavedLocationDatabase extends RoomDatabase {

    private static SavedLocationDatabase instance;

    public abstract SavedLocationDao savedLocationDao();

    public static synchronized SavedLocationDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            SavedLocationDatabase.class, "saved_location_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
