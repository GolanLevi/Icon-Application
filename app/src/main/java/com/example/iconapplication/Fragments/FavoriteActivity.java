package com.example.iconapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iconapplication.Models.GYM;
import com.example.iconapplication.R;
import com.example.iconapplication.Utilities.DataManager;
import com.example.iconapplication.Utilities.GYMAdapter;

import java.util.ArrayList;

public class FavoriteActivity extends Fragment {

    private RecyclerView recyclerView;
    private GYMAdapter gymAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        recyclerView = view.findViewById(R.id.favorite_LST_gyms);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<GYM> favoriteGyms = (ArrayList<GYM>) DataManager.loadFavorites(getContext());
        gymAdapter = new GYMAdapter(favoriteGyms, getContext());
        recyclerView.setAdapter(gymAdapter);

        return view;
    }
}
