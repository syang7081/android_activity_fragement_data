package com.syang7081.actfrademo.activityfragmentdatademo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by syang7081 on 2/11/2017.
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private List<WeakReference<BaseFragment>> fragmentList = new ArrayList<>();

    public void onReceiveData(List<Bundle> bundles) {
        // Relay to child fragments
        postData(bundles);
    }

    protected void postData(Bundle bundle) {
        ArrayList<Bundle> list = new ArrayList<>();
        list.add(bundle);
        postData(list);
    }

    protected void postData(List<Bundle> bundles) {
        for (WeakReference<BaseFragment> ref : fragmentList) {
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
