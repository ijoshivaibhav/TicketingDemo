package com.example.vaibhav.ticketapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.base_layout, new DetailFragment())
                .addToBackStack(null).commit();

        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.parent, new MainFragment())
                .addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 2) {
           System.exit(0);
        } else {
            System.exit(0);
//            super.onBackPressed();
        }
    }
}
