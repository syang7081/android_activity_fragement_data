package com.syang7081.actfrademo.activityfragmentdatademo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by syang7081 on 2/11/2017.
 */

public class FragmentLevelTwo extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_level_two, container, false);
        // Has two child fragments
        Fragment fragment = new FragmentLevelThree();
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_holder, fragment).commit();
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_holder2,  new FragmentLevelThree()).commit();
        return view;
    }

    @Override
    public void onReceiveData(List<Bundle> bundles) {
        Log.d("FragmentLevelTwo", "received data: " + bundles.toString());
        List<Bundle> list = new ArrayList<>();
        list.addAll(bundles);
        Bundle bundle = new Bundle();
        bundle.putString("FragmentLevelTwo_data", "Hi there, data is added in FragmentLevelTwo");
        list.add(bundle);
        super.onReceiveData(list);
    }
}
