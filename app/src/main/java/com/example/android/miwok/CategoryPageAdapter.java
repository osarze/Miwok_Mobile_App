package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DELL on 1/20/2018.
 */

public class CategoryPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;

    public CategoryPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NumbersFragment();

            case 1:
                return new ColorsFragment();

            case 2:
                return new FamilyFragment();

            case 3:
                return new PhrasesFragment();

            default:
                return null;

        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Numbers";

            case 1:
                return "Colors";

            case 2:
                return "Family";

            case 3:
                return "Phrases";

            default:
                return null;
        }
    }
}
