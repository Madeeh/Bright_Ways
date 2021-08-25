package com.example.brightways.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.brightways.R;
import com.example.brightways.UI.MapsActivity;
import com.example.brightways.UI.Reminder.MainPage;
import com.example.brightways.UI.SelectClothes;


public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    ImageButton button;
    Button Reminder, mapLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mapLocation = view.findViewById(R.id.mapLocation);
        mapLocation.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MapsActivity.class);
            startActivity(intent);
        });


        Reminder = view.findViewById(R.id.button2);
        Reminder.setOnClickListener(v -> {
                    Intent intent = new Intent(getContext(), MainPage.class);
                    startActivity(intent);
                }
        );

        button = view.findViewById(R.id.washBtn);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SelectClothes.class);
            startActivity(intent);

        });

        button = view.findViewById(R.id.select_shirt);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SelectClothes.class);
            startActivity(intent);
        });

        button = view.findViewById(R.id.IronBtn);
        button.setOnClickListener(v -> {

            Intent intent = new Intent(getContext(), SelectClothes.class);
            startActivity(intent);
        });

        return view;
    }

}