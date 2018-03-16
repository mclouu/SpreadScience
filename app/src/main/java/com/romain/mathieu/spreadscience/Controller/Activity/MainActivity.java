package com.romain.mathieu.spreadscience.Controller.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.romain.mathieu.spreadscience.R;
import com.romain.mathieu.spreadscience.View.PageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureViewPagerAndTabs();
    }


    //-------------
    // VIEW PAGER
    //-------------

    private void configureViewPagerAndTabs() {
        //Get ViewPager from layout
        ViewPager pager = findViewById(R.id.activity_main_viewpager);
        //Set Adapter PageAdapter and glue it together
        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));

        //Get TabLayout from layout
        TabLayout tabs = findViewById(R.id.activity_main_tabs);
        //Glue TabLayout and ViewPager together
        tabs.setupWithViewPager(pager);
        //Design purpose. Tabs have the same width
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }


    //------------
    // MENU
    //------------

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_notif:

                return true;
            case R.id.menu_help:

                return true;
            case R.id.menu_about:

                return true;
            case R.id.menu_search:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
