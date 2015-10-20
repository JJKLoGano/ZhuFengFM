package com.jjklogano.zufengfm.fragments.discover;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.fragments.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverLiveFragment extends BaseFragment {


    public DiscoverLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.discover_live_fragment, container, false);
    }


    @Override
    public String getFragmentTitle() {
        return "直播";
    }
}
