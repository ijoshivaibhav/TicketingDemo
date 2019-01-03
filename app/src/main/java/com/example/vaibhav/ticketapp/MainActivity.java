package com.example.vaibhav.ticketapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.parent,new MainFragment())
                .addToBackStack(null).commit();
    }

}
