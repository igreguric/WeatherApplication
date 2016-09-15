package com.ferit.ivan.weather_app.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ferit.ivan.weather_app.R;

/**
 * Created by ivan on 7/19/16.
 */
public class SideMenuAdapter extends BaseAdapter {

    private final Categories[] mCategories = Categories.values();

    @Override
    public int getCount() {
        return mCategories.length;
    }

    @Override
    public Categories getItem(int position) {
        return mCategories[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_side_menu, parent, false);
            holder = new ViewHolder();
            holder.mTitleTextView = (TextView) convertView.findViewById(R.id.content_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Categories item = getItem(position);
        holder.mTitleTextView.setText(item.getStringId());
        return convertView;
    }

    private static class ViewHolder {
        private TextView mTitleTextView;
    }

    public enum Categories {
        air_temp(R.string.air_temp),
        air_humidity(R.string.air_humidity),
        soil_temp(R.string.soil_temp),
        soil_humidity(R.string.soil_humidity);

        int stringId;

        Categories(int stringId) {
            this.stringId = stringId;
        }

        public int getStringId() {
            return this.stringId;
        }
    }

}
