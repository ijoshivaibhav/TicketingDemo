package com.example.vaibhav.ticketapp.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.vaibhav.ticketapp.activities.MainActivity;
import com.example.vaibhav.ticketapp.fragments.FragmentTabOne;
import com.example.vaibhav.ticketapp.fragments.FragmentTabTwo;


public class TabAdapter extends FragmentStatePagerAdapter {
    private Context context;
    int tabCount;
    private String[] tabTitles;


    public TabAdapter(FragmentManager fm, int tabCount, MainActivity myActivity) {
        super(fm);
        this.tabCount = tabCount;
        this.context = myActivity;
        tabTitles = new String[]{"Tab 1", "Tab 2"};
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentTabOne();
            case 1:
                return new FragmentTabTwo();

            default:
                return null;
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return tabCount;
    }


}
