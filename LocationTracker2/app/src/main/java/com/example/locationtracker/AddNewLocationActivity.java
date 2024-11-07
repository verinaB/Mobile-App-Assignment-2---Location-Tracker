package com.example.locationtracker;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.R;

import com.example.locationtracker.R;

public class AddNewLocationActivity extends AppCompatActivity {

    private EditText editTextLocationName;
    private EditText editTextLatitude;
    private EditText editTextLongitude;
    private Button buttonSaveLocation;

    private SavedLocationViewModel locationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_location);

        // Initialize UI components
        editTextLocationName = findViewById(R.id.edit_text_location_name);
        editTextLatitude = findViewById(R.id.edit_text_latitude);
        editTextLongitude = findViewById(R.id.edit_text_longitude);
        buttonSaveLocation = findViewById(R.id.button_save_location);

        // Initialize ViewModel
        locationViewModel = new ViewModelProvider(this).get(SavedLocationViewModel.class);

        // Set button click listener
        buttonSaveLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveLocation();
            }
        });
    }

    private void saveLocation() {
        // Get input from user
        String locationName = editTextLocationName.getText().toString().trim();
        String latitudeStr = editTextLatitude.getText().toString().trim();
        String longitudeStr = editTextLongitude.getText().toString().trim();

        // Validate inputs
        if (TextUtils.isEmpty(locationName) || TextUtils.isEmpty(latitudeStr) || TextUtils.isEmpty(longitudeStr)) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        double latitude;
        double longitude;
        try {
            latitude = Double.parseDouble(latitudeStr);
            longitude = Double.parseDouble(longitudeStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid latitude or longitude", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new SavedLocation object
        SavedLocation newLocation = new SavedLocation(locationName, latitude, longitude);

        // Insert the location into the database using the ViewModel
        locationViewModel.insert(newLocation);

        // Show success message and close the activity
        Toast.makeText(this, "Location saved successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
