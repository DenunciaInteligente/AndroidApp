package com.example.android.denunciainteligente;

import android.content.Context;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by roman on 12/06/2017.
 */

public class FragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "haz tu Denuncia", "Eventos" };
    private Context context;

    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DenunciaFragment();
        }
         else {
            return new GaleriaFragment();
        }

    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 2;
    }}