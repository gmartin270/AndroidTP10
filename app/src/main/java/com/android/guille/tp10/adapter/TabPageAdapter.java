package com.android.guille.tp10.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.guille.tp10.fragment.ChatsFragment;
import com.android.guille.tp10.fragment.UsersFragment;

/**
 * Created by Guille on 07/06/2016.
 */
public class TabPageAdapter extends FragmentPagerAdapter {
    public TabPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment;

        if(i == 0)
            fragment = new UsersFragment();
        else
            fragment = new ChatsFragment();

        return fragment;
    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String tabName = "";

        if(position == 0)
            tabName = "USUARIOS";
        else
            tabName = "CHATS";

        return tabName;
    }
}
