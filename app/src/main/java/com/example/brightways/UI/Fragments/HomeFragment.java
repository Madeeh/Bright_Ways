package com.example.brightways.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.brightways.Chat.LoginChatActivity;
import com.example.brightways.R;
import com.example.brightways.UI.PracticeWork;
import com.example.brightways.UI.SearchProductsActivity;
import com.example.brightways.UI.SelectClothes;
import com.example.brightways.UI.TestWork;


public class HomeFragment extends Fragment {
    public HomeFragment() {

    }

    ImageButton button;
    Button orderButton, buttonNew, buttonSearch, BtnChat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        BtnChat = view.findViewById(R.id.buttonChat);
        BtnChat.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LoginChatActivity.class);
            startActivity(intent);
        });


        buttonSearch = view.findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SearchProductsActivity.class);
            startActivity(intent);
        });

        buttonNew = view.findViewById(R.id.buttonNew);
        buttonNew.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), PracticeWork.class);
            startActivity(intent);
        });

        orderButton = view.findViewById(R.id.orderBtn);
        orderButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), TestWork.class);
            startActivity(intent);
        });


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