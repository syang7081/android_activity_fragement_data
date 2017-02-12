package com.syang7081.actfrademo.activityfragmentdatademo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by syang7081 on 2/11/2017.
 */

public class FragmentLevelOne extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_level_one, container, false);
        //Has one child fragment
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_holder, new FragmentLevelTwo()).commit();

        return view;
    }

    @Override
    public void onReceiveData(List<Bundle> bundles) {
        Log.d("FragmentLevelOne", "received data: " + bundles.toString());
        super.onReceiveData(bundles);
    }
}
