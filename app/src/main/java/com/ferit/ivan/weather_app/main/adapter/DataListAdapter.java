package com.ferit.ivan.weather_app.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ferit.ivan.weather_app.R;
import com.ferit.ivan.weather_app.main.model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 7/27/16.
 */
public class DataListAdapter extends BaseAdapter {

    private final List<Data> mSensorsData = new ArrayList<>();

    public void setSensors(@NonNull List<Data> sensordata) {
        mSensorsData.clear();
        mSensorsData.addAll(sensordata);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mSensorsData.size();
    }

    @Override
    public Data getItem(int position) {
        return mSensorsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mSensorsData.get(position).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_data_item, parent, false);
            holder = new ViewHolder();
            holder.mDataTextView = (TextView) convertView.findViewById(R.id.data);
            holder.mDateTextView = (TextView) convertView.findViewById(R.id.date);
            holder.mDataExplanationTextView = (TextView) convertView.findViewById(R.id.data_explanation);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Data item = getItem(position);
        holder.mDataTextView.setText(item.getS1());
        holder.mDataTextView.setText(item.getS2());
        holder.mDataTextView.setText(item.getS3());
        holder.mDataTextView.setText(item.getS4());
        holder.mDateTextView.setText(item.getDate());
        holder.mDataExplanationTextView.setText(R.string.air_temp);
        holder.mDataExplanationTextView.setText(R.string.air_humidity);
        holder.mDataExplanationTextView.setText(R.string.soil_temp);
        holder.mDataExplanationTextView.setText(R.string.soil_humidity);

        return convertView;

    }

    private static class ViewHolder {
        private TextView mDataTextView;
        private TextView mDateTextView;
        private TextView mDataExplanationTextView;


    }

}
