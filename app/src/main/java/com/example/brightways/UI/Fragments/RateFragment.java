package com.example.brightways.UI.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.brightways.Adapters.FragmentAdapterPriceList;
import com.example.brightways.R;
import com.google.android.material.tabs.TabLayout;


public class RateFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageButton button;

    public RateFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rate, container, false);

        viewPager = view.findViewById(R.id.viewPagerPriceList);
        viewPager.setAdapter(new FragmentAdapterPriceList(getActivity().getSupportFragmentManager()));

        tabLayout = view.findViewById(R.id.tabLayoutPriceList);
        tabLayout.setupWithViewPager(viewPager);

        button = view.findViewById(R.id.btnBackPriceList);
        button.setOnClickListener(v -> getActivity().onBackPressed());
        return view;
    }
}