package com.example.locationtracker;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.locationtracker.R;

public class LocationDetailActivity extends AppCompatActivity {

    public static final String EXTRA_LOCATION_NAME = "com.example.locationtracker.EXTRA_LOCATION_NAME";
    public static final String EXTRA_LOCATION_LATITUDE = "com.example.locationtracker.EXTRA_LOCATION_LATITUDE";
    public static final String EXTRA_LOCATION_LONGITUDE = "com.example.locationtracker.EXTRA_LOCATION_LONGITUDE";

    private TextView textViewName;
    private TextView textViewLatitude;
    private TextView textViewLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);

        // Initialize UI components
        textViewName = findViewById(R.id.text_view_name);
        textViewLatitude = findViewById(R.id.text_view_latitude);
        textViewLongitude = findViewById(R.id.text_view_longitude);

        // Retrieve data passed from the calling activity
        String locationName = getIntent().getStringExtra(EXTRA_LOCATION_NAME);
        double latitude = getIntent().getDoubleExtra(EXTRA_LOCATION_LATITUDE, 0.0);
        double longitude = getIntent().getDoubleExtra(EXTRA_LOCATION_LONGITUDE, 0.0);

        // Set data to views
        textViewName.setText("Name: " + locationName);
        textViewLatitude.setText("Latitude: " + latitude);
        textViewLongitude.setText("Longitude: " + longitude);
    }
}
