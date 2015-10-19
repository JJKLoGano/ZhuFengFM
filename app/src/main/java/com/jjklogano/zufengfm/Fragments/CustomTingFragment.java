package com.jjklogano.zufengfm.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjklogano.zufengfm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomTingFragment extends Fragment {


    public CustomTingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.custom_ting_fragment, container, false);
    }


}
