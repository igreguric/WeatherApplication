package com.ferit.ivan.weather_app.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ferit.ivan.weather_app.R;
import com.ferit.ivan.weather_app.base.BaseFragment;
import com.ferit.ivan.weather_app.main.adapter.SideMenuAdapter;

/**
 * Created by ivan on 7/20/16.
 */
public class SideMenuFragment extends BaseFragment {

    //Ui Widgets
    private ListView mSideMenuListView;
    private SideMenuAdapter mSideMenuAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_side_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mSideMenuListView = (ListView) layoutView.findViewById(R.id.adapter_view);
        mSideMenuAdapter = new SideMenuAdapter();
        mSideMenuListView.setAdapter(mSideMenuAdapter);
    }

    @Override
    protected void prepareData() {
    }
}
