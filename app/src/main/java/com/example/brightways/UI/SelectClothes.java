package com.example.brightways.UI;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.brightways.Adapters.FragmentAdapter;
import com.example.brightways.R;
import com.google.android.material.tabs.TabLayout;

public class SelectClothes extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_clothes);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        button = findViewById(R.id.btnBack);
        button.setOnClickListener(v -> onBackPressed());
    }
}