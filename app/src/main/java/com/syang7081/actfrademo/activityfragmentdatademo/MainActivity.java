package com.syang7081.actfrademo.activityfragmentdatademo;

import android.os.Bundle;
import android.util.Log;

import java.util.List;


/**
 * Created by syang7081 on 2/11/2017.
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_1, new FragmentLevelOne()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_2, new FragmentLevelThree()).commit();
    }

    @Override
    public void onReceiveData(List<Bundle> bundles) {
        super.onReceiveData(bundles);
        Log.d("Main activity", "received data: " + bundles.toString());
    }
}
