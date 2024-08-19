package com.example.iconapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.iconapplication.Fragments.FavoriteActivity;
import com.example.iconapplication.Fragments.HomeActivity;
import com.example.iconapplication.Fragments.MapActivity;
import com.example.iconapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.navigation_home);
        bottomNav.setOnItemSelectedListener(navListener);

        Fragment selectedFragment = new HomeActivity();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit();

    }

    private NavigationBarView.OnItemSelectedListener navListener =
            item -> {
                int itemId = item.getItemId();
                Fragment selectedFragment = null;

                if (itemId == R.id.navigation_home) {
                    selectedFragment = new HomeActivity();
                } else if (itemId == R.id.navigation_favorite) {
                    selectedFragment = new FavoriteActivity();
                } else if (itemId == R.id.navigation_map) {
                    selectedFragment = new MapActivity();

                } else {
                    selectedFragment = new HomeActivity();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            };
}
