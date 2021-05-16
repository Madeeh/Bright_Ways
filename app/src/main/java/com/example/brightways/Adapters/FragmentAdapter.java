package com.example.brightways.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.brightways.UI.Fragments.KidsFragment;
import com.example.brightways.UI.Fragments.MenFragment;
import com.example.brightways.UI.Fragments.OrderFragment;
import com.example.brightways.UI.Fragments.OthersFragment;
import com.example.brightways.UI.Fragments.WomenFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WomenFragment();
            case 1:
                return new MenFragment();
            case 2:
                return new KidsFragment();
            case 3:
                return new OthersFragment();

            default:
                return new WomenFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "WOMEN";
        }
        else if (position == 1) {
            title = "MEN";
        }
        else if (position == 2) {
            title = "KIDS";
        }
        else if (position == 3) {
            title = "OTHERS";
        }
        return title;
    }
}
