package com.ferit.ivan.weather_app.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

/**
 * Created by ivan on 7/4/16.
 */
public abstract class BaseFragment extends Fragment {

    protected abstract void prepareUI(@NonNull View layoutView);

    protected abstract void prepareData();

    protected void replaceFragment(int layoutId, @NonNull BaseFragment fragment, boolean addToBackStack){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(layoutId, fragment);
        if (addToBackStack){
            transaction.addToBackStack(fragment.getTag());
        }
        transaction.commit();
    }

}
