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
import com.ferit.ivan.weather_app.commons.requests.BackendRequest;
import com.ferit.ivan.weather_app.commons.volley.ResponseListener;
import com.ferit.ivan.weather_app.commons.volley.VolleyErrorHelper;
import com.ferit.ivan.weather_app.main.adapter.DataListAdapter;
import com.ferit.ivan.weather_app.main.model.Data;


import java.util.List;

/**
 * Created by ivan on 7/27/16.
 */
public class DataListFragment extends BaseFragment {

    private ListView mDataListView;
    private DataListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareUI(view);
    }

    @Override
    protected void prepareUI(@NonNull View layoutView) {
        mDataListView = (ListView) layoutView.findViewById(R.id.adapter_view);
        mAdapter = new DataListAdapter();
        mDataListView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareData();
    }

    @Override
    protected void prepareData() {
        BackendRequest.getsInstance(getActivity()).requestPosts(new ResponseListener<List<Data>>() {
            @Override
            public void onResponse(List<Data> data) {
                mAdapter.setSensors(data);
            }

            @Override
            public void onError(Object error) {
                VolleyErrorHelper.handleErrorWithToast(error, getActivity());
            }

        });
    }
}
