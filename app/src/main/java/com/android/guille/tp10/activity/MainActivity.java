package com.android.guille.tp10.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.android.guille.tp10.R;

import com.android.guille.tp10.fragment.SettingsFragment;
import com.android.guille.tp10.fragment.TabFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private TabFragment tabFragment = new TabFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View container = findViewById(R.id.container);
        manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, tabFragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.preferences:
            {
                SettingsFragment settings = new SettingsFragment();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.replace(R.id.container, settings);
                transaction.addToBackStack("settings");
                transaction.commit();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
