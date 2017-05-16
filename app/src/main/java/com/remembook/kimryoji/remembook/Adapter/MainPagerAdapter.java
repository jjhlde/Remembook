package com.remembook.kimryoji.remembook.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.remembook.kimryoji.remembook.Fragment.MainWriteFragment;

/**
 * Created by KimRyoji on 2017-04-24.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 1 :
                break;
            case 2 :
                break;
            case 3 :
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
