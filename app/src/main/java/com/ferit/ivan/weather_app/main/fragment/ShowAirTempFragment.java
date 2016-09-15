package com.ferit.ivan.weather_app.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ferit.ivan.weather_app.R;
import com.ferit.ivan.weather_app.base.BaseFragment;
import com.ferit.ivan.weather_app.commons.requests.BackendRequest;
import com.ferit.ivan.weather_app.commons.volley.ResponseListener;
import com.ferit.ivan.weather_app.commons.volley.VolleyErrorHelper;
import com.ferit.ivan.weather_app.main.adapter.DataListAdapter;
import com.ferit.ivan.weather_app.main.model.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 8/9/16.
 */
public class ShowAirTempFragment extends BaseFragment implements View.OnClickListener {

    public static final String BUNDLE_DATA = "bundle_data";

    private Data mWeatherData;

    private TextView mTempTxt;
    private TextView mDateTxt;

    public static Fragment newInstance(Data data) {
        Fragment fragment = new ShowAirTempFragment();
        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_airtemp_data, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mTempTxt = (TextView) layoutView.findViewById(R.id.s1);
        mDateTxt = (TextView) layoutView.findViewById(R.id.date);
        Button mRefreshBtn = (Button) layoutView.findViewById(R.id.refresh);
        mRefreshBtn.setOnClickListener(this);
    }

    @Override
    protected void prepareData(){
        Bundle args = getArguments();
        if (args != null && args.containsKey(BUNDLE_DATA)){
            mWeatherData = (Data) args.getSerializable(BUNDLE_DATA);
        }
        setUiData();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.refresh) {
            refreshData();
        }
    }

    private void refreshData() {
        BackendRequest.getsInstance(getActivity()).requestPosts(new ResponseListener<List<Data>>() {
            @Override
            public void onResponse(List<Data> data) {
                mWeatherData = data.get(0);
                setUiData();
            }

            @Override
            public void onError(Object error) {

            }
        });
    }

    private void setUiData() {
        if (mWeatherData == null) {
            refreshData();
            return;
        }
        mTempTxt.setText(mWeatherData.getS1());
        mDateTxt.setText(mWeatherData.getDate());
    }
}
