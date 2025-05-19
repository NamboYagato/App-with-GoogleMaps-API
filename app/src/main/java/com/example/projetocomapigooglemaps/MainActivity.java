package com.example.projetocomapigooglemaps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private List<Marker> marker = new ArrayList<>();
    private TextInputEditText location_input;
    private Button add_location_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location_input = findViewById(R.id.location_input);
        add_location_button = findViewById(R.id.add_location_button);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        add_location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(view view) {
                addLocation();
            }
        });
    }

    public void addLocation() {
        String location = location_input.getText() != null ? location_input.getText().toString() : "";
        if (location.isEmpty()) {
            Toast.makeText(this, "Please enter a location", Toast.LENGTH_SHORT).show();
            return;
        }

        double latitude = -2.0 + Math.random() * 4.0;
        double longitude = -44.0 + Math.random() * 4.0;

        LatLng position = new LatLng(latitude, longitude);
        Marker marker = mMap.addMarker(new MarkerOptions().position(position).title(location));
        markers.add(marker);
        location_input.setText("");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
    }
}
