package com.example.android.denunciainteligente;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    // Find the view pager that will allow the user to swipe between fragments
    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

    // Create an adapter that knows which fragment should be shown on each page
    FragmentPageAdapter adapter = new FragmentPageAdapter(getSupportFragmentManager());

    // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);


    TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);



}

}