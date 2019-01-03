package com.example.vaibhav.ticketapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment implements TabLayout.OnTabSelectedListener {
    View view;

    private TabLayout tabLayout;
    private static ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getMyActivity()).inflate(R.layout.fragment_patrol, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayoutwf);
        getMyActivity().getSupportActionBar().setTitle("Tickets");
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(5);

        viewPager = (ViewPager) view.findViewById(R.id.pagerwf);

        TabAdapter adapter = new TabAdapter(getChildFragmentManager(), tabLayout.getTabCount(), getMyActivity());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position, false);
                tabLayout.getTabAt(position).select();
                if (position == 0) {
                    tabLayout.getTabAt(position).setText("Tab 1");
                } else {
                    tabLayout.getTabAt(position).setText("Tab 2");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        tabLayout.setOnTabSelectedListener(this);


        return view;
    }

    public static void setFragment(MoviePojo pojo) {
        viewPager.setCurrentItem(1, false);
        FragmentTabTwo fragmentTabTwo = new FragmentTabTwo();
        fragmentTabTwo.displayReceivedData(pojo);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.displayReceivedData(pojo);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private MainActivity getMyActivity() {
        return (MainActivity) getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        getMyActivity().getSupportActionBar().setTitle("Tickets");
    }



}
