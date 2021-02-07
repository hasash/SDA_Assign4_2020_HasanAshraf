package com.example.sdaassign4_2020;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * viewPager adapter. used to create the tabbed layout for the application
 * @author Hasan Ashraf
 */
public class ViewPageAdapter extends FragmentPagerAdapter {

    private Context context;

    ViewPageAdapter(FragmentManager fm, int behavior, Context nContext) {
        super(fm, behavior);
        context = nContext;
    }

    /**
     * Fragment method used to call the position of the tab that is selected from the main UI
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new Fragment();

        //finds the tab position (note array starts at 0)
        position = position+1;

        //finds the fragment
        switch (position)
        {
            case 1:
                //code
                fragment = new Welcome();
                break;
            case 2:
                //code
                fragment = new BookList();
                break;
            case 3:
                //code
                fragment = new Settings();
                break;
        }

        return fragment;
    }

    /**
     * The number of tabs that are called out are referenced in the getCount function
     */
    @Override
    public int getCount() {
        return 3;
    }

    /*
     * Setting the header on the tabbed layout present in the user interface
     * @param position
     * @return tabtitle
     */
    @Override
    public CharSequence getPageTitle(int position) {
        position = position+1;

        CharSequence tabTitle = "";

        //finds the fragment
        switch (position)
        {
            case 1:
                //code
                tabTitle = "Home";
                break;
            case 2:
                //code
                tabTitle = "BOOKS";
                break;
            case 3:
                //code
                tabTitle = "SETTINGS";
                break;
        }

        return tabTitle;
    }
}
