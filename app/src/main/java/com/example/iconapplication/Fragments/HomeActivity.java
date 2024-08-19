package com.example.iconapplication.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iconapplication.LoginActivity;
import com.example.iconapplication.Models.GYM;
import com.example.iconapplication.R;
import com.example.iconapplication.Utilities.DataManager;
import com.example.iconapplication.Utilities.GYMAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Locale;

public class HomeActivity extends Fragment {

    private RecyclerView recyclerView;
    private GYMAdapter gymAdapter;
    private EditText searchEditText;
    private Button logoutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.main_LST_gyms);
        searchEditText = view.findViewById(R.id.main_EDT_search);
        logoutButton = view.findViewById(R.id.btn_logout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<GYM> gyms = DataManager.getGyms();
        gymAdapter = new GYMAdapter(gyms, getContext());
        recyclerView.setAdapter(gymAdapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // לא בשימוש
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterGyms(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // לא בשימוש
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

    private void filterGyms(String query) {
        ArrayList<GYM> filteredList = new ArrayList<>();
        ArrayList<GYM> gyms = DataManager.getGyms(); // קבלת הרשימה המעודכנת מה-DataManager
        for (GYM gym : gyms) {
            if (gym.getName().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))) {
                filteredList.add(gym);
            }
        }
        gymAdapter.updateList(filteredList);
    }
}
