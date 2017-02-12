package com.syang7081.actfrademo.activityfragmentdatademo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syang7081 on 2/11/2017.
 */

public abstract class BaseActivity extends FragmentActivity
{
    public static final String TAG = BaseActivity.class.getSimpleName();
    public static final String KEY_ACTIVITY_STATE = "key_activity_state";
    public static final int ON_ACTIVITY_STARTED = 1;
    public static final int ON_ACTIVITY_RESUMED = ON_ACTIVITY_STARTED + 1;
    public static final int ON_ACTIVITY_PAUSED = ON_ACTIVITY_RESUMED + 1;
    public static final int ON_ACTIVITY_DESTROYED = ON_ACTIVITY_PAUSED + 1;


    List<WeakReference<BaseFragment>> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ACTIVITY_STATE, ON_ACTIVITY_STARTED);
        postData(bundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ACTIVITY_STATE, ON_ACTIVITY_RESUMED);
        postData(bundle);
    }

    @Override
    public void onPause() {
        super.onResume();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ACTIVITY_STATE, ON_ACTIVITY_PAUSED);
        postData(bundle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ACTIVITY_STATE, ON_ACTIVITY_DESTROYED);
        postData(bundle);
    }

    public void onReceiveData(List<Bundle> bundles) {
        Log.d(TAG, "Received bundles: " + bundles);
    }

    protected void postData(Bundle bundle) {
        ArrayList<Bundle> list = new ArrayList<>();
        list.add(bundle);
        postData(list);
    }

    protected void postData(List<Bundle> bundles) {
        for(WeakReference<BaseFragment> ref : fragmentList) {
            BaseFragment f = ref.get();
            if (f != null) {
                f.onReceiveData(bundles);
            }
        }
    }

    @Override
    public void onAttachFragment (Fragment fragment) {
        if (fragment instanceof BaseFragment) {
            fragmentList.add(new WeakReference(fragment));
        }
        else {
            Log.w(TAG, "Fragment is not inherited from BaseFragment: " + fragment);
        }
    }
}
