package com.jjklogano.zufengfm.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.adapters.CommonFragmentAdapter;
import com.jjklogano.zufengfm.fragments.discover.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment {

    private List<BaseFragment> fragments;
    private View view;
    private FragmentManager childFragmentManager;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private CommonFragmentAdapter adapter;

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.discover_fragment, container, false);

        initView(savedInstanceState);

        return view;
    }

    private void initView(Bundle savedInstanceState) {
        tabLayout = (TabLayout) view.findViewById(R.id.discover_tab_bar);

        //2、viewPager
        viewPager = (ViewPager) view.findViewById(R.id.discover_view_pager);

        childFragmentManager = getChildFragmentManager();

        fragments = new ArrayList<>();
        fragments.add(new DiscoverRecommendFragment());
        fragments.add(new DiscoverCategoryFragment());
        fragments.add(new DiscoverLiveFragment());
        fragments.add(new DiscoverRatingFragment());
        fragments.add(new DiscoverAnchorFragment());


        adapter = new CommonFragmentAdapter(childFragmentManager, fragments);

        viewPager.setAdapter(adapter);

        //实现tabLayout与ViewPager连动
        //需要ViewPager内部制定的adapter中实现getPageTitle()方法
        tabLayout.setupWithViewPager(viewPager);
    }


}
