package com.example.brightways.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.brightways.UI.Fragments.IronFragment;
import com.example.brightways.UI.Fragments.WashAndIronFragment;
import com.example.brightways.UI.Fragments.WashFragment;

public class FragmentAdapterPriceList extends FragmentPagerAdapter {
    public FragmentAdapterPriceList(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WashFragment();
            case 1:
                return new IronFragment();
            case 2:
                return new WashAndIronFragment();
            default:
                return new WashFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Wash";
        } else if (position == 1) {
            title = "Iron";
        } else if (position == 2) {
            title = "WashAndIron";
        }
        return title;
    }
}
