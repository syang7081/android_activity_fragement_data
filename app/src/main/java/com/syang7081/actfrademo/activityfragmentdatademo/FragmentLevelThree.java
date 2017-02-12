package com.syang7081.actfrademo.activityfragmentdatademo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by syang7081 on 2/11/2017.
 */

public class FragmentLevelThree extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_level_three, container, false);
        return view;
    }

    @Override
    public void onReceiveData(List<Bundle> bundles) {
        super.onReceiveData(bundles);
        Log.d("FragmentLevelThree", "received data: " + bundles.toString());
        /* send data to root activity
        Bundle b = new Bundle();
        b.putString("Greeting", "Hello Activity, this is from " + this);
        List<Bundle> list = new ArrayList<>();
        list.add(b);
        ((BaseActivity) getActivity()).onReceiveData(list);
        */
    }
}
