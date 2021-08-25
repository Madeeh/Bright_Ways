package com.example.brightways.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.brightways.R;
import com.example.brightways.UI.SearchProductsActivityKids;
import com.example.brightways.UI.SearchProductsActivityMen;
import com.example.brightways.UI.SearchProductsActivityOthers;
import com.example.brightways.UI.SearchProductsActivityWomen;

public class SearchFragment extends Fragment {

    Button womenBtn, menBtn, kidsBtn, othersBtn;


    public SearchFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.search_category, container, false);

        womenBtn = view.findViewById(R.id.women_search_btn);
        womenBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SearchProductsActivityWomen.class);
            startActivity(intent);
        });
        menBtn = view.findViewById(R.id.men_search_btn);
        menBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SearchProductsActivityMen.class);
            startActivity(intent);
        });
        kidsBtn = view.findViewById(R.id.kids_search_btn);
        kidsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SearchProductsActivityKids.class);
            startActivity(intent);
        });
        othersBtn = view.findViewById(R.id.others_search_btn);
        othersBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SearchProductsActivityOthers.class);
            startActivity(intent);
        });


        return view;
    }
}