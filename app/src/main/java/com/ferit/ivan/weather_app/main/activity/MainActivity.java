package com.ferit.ivan.weather_app.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ferit.ivan.weather_app.R;
import com.ferit.ivan.weather_app.base.BaseActivity;
import com.ferit.ivan.weather_app.commons.requests.BackendRequest;
import com.ferit.ivan.weather_app.main.adapter.SideMenuAdapter;
import com.ferit.ivan.weather_app.main.fragment.ShowAirHumFragment;
import com.ferit.ivan.weather_app.main.fragment.ShowAirTempFragment;
import com.ferit.ivan.weather_app.main.fragment.ShowSoilHumFragment;
import com.ferit.ivan.weather_app.main.fragment.ShowSoilTempFragment;
import com.ferit.ivan.weather_app.main.model.Data;

/**
 * Created by ivan on 7/14/16.
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDrawerLayout();
    }

    private void initDrawerLayout() {
        Toolbar mDrawerToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerToolbar.setTag(R.string.app_name);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_container);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mDrawerToolbar, R.string.app_name, R.string.app_name);
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        showFragment(new ShowAirTempFragment());

        ListView drawerList = (ListView) findViewById(R.id.drawer_list);
        drawerList.setAdapter(new SideMenuAdapter());
        drawerList.setOnItemClickListener(this);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void showFragment(Fragment fragment) {
        replaceFragment(R.id.fragment_container, fragment);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Data show = BackendRequest.getsInstance(this).getSensorData();
        switch (position) {
            case 0:
                if (show != null) {
                    showFragment(ShowAirTempFragment.newInstance(show));
                }
                break;
            case 1:
                if (show != null) {
                    showFragment(ShowAirHumFragment.newInstance(show));
                }
                break;
            case 2:
                if (show != null) {
                    showFragment(ShowSoilTempFragment.newInstance(show));
                }
                break;
            case 3:
                if (show != null) {
                    showFragment(ShowSoilHumFragment.newInstance(show));
                }
                break;
        }
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}
