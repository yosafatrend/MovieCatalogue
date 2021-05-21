package com.yorren.moviecatalogue.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yorren.moviecatalogue.R;
import com.yorren.moviecatalogue.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHomeBinding activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());

        SectionsPageAdapter sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager(), this);

        activityHomeBinding.viewPager.setAdapter(sectionsPageAdapter);
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager);

        if (getSupportActionBar() != null){
            getSupportActionBar().setElevation(0);
        }
    }
}