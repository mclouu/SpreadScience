package com.romain.mathieu.spreadscience.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.romain.mathieu.spreadscience.Controller.Fragment.EmptyFragment;
import com.romain.mathieu.spreadscience.Controller.Fragment.NewsPageFragment;
import com.romain.mathieu.spreadscience.Controller.Fragment.TopStoriesPageFragment;

/**
 * Created by romain on 16/03/2018.
 */

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewsPageFragment.newInstance();
            case 1:
                return TopStoriesPageFragment.newInstance();
            case 2:
                return EmptyFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return (3); // number of page to show
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "NEWS";
            case 1:
                return "TOP STORIES";
            case 2:
                return "EMPTY";
            default:
                return null;
        }
    }
}
