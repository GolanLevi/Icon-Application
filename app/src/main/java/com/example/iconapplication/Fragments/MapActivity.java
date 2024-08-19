package com.example.iconapplication.Fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.iconapplication.Models.GYM;
import com.example.iconapplication.R;
import com.example.iconapplication.Utilities.DataManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

public class MapActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private Map<String, GYM> gymMarkersMap = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext());

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            updateMapWithCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        addGymMarkers();

        // הוספת מאזין ללחיצה על מרקר
        mMap.setOnMarkerClickListener(marker -> {
            GYM gym = gymMarkersMap.get(marker.getTitle());
            if (gym != null) {
                int currentExercisers = gym.getCurrentExercisers();
                String loadLevel = currentExercisers > 30 ? "רמת העומס גבוהה \uD83D\uDEA8\n" : "רמת העומס נמוכה \uD83C\uDFCB\uD83C\uDFFD\n";
                String message = "כמות מתאמנים: " + currentExercisers + "\n" + loadLevel;
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
            }
            return false; // החזרת false כדי שה-InfoWindow ייפתח כרגיל
        });
    }

    private void updateMapWithCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(requireActivity(), location -> {
                        if (location != null) {
                            LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 12));
                        }
                    });
        }
    }

    private void addGymMarkers() {
        for (GYM gym : DataManager.getGyms()) {
            LatLng location = new LatLng(gym.getLatitude(), gym.getLongitude());
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(location)
                    .title(gym.getName())
                    .snippet(gym.getAddress())
                    .icon(getScaledMarkerIcon())); // שימוש באייקון מותאם אישית מוקטן
            gymMarkersMap.put(marker.getTitle(), gym); // שמירת מידע המכון במפה לפי שם המכון
        }
    }

    private BitmapDescriptor getScaledMarkerIcon() {
        // טוען את האייקון מהמשאבים
        Bitmap originalIcon = BitmapFactory.decodeResource(getResources(), R.drawable.gym1);
        // שינוי גודל האייקון (100x100 הוא גודל דוגמה, אפשר לשנות לפי הצורך)
        Bitmap scaledIcon = Bitmap.createScaledBitmap(originalIcon, 100, 100, false);
        return BitmapDescriptorFactory.fromBitmap(scaledIcon);
    }
}
