package com.android.guille.tp10.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.guille.tp10.R;
import com.android.guille.tp10.adapter.TabPageAdapter;

public class TabFragment extends Fragment {

    private TabPageAdapter mAdapter;
    private ViewPager mViewPager;
    private View root;

    public TabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_tab, container, false);

        mAdapter = new TabPageAdapter(getFragmentManager());
        mViewPager = (ViewPager) root.findViewById(R.id.pager);
        mViewPager.setAdapter(mAdapter);

        TabLayout tab = (TabLayout) root.findViewById(R.id.tab);
        tab.setupWithViewPager(mViewPager);

        return root;
    }

}
