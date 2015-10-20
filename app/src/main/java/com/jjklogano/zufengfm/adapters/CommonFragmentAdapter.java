package com.jjklogano.zufengfm.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.jjklogano.zufengfm.fragments.BaseFragment;

import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class CommonFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    public CommonFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        int ret=0;

        if (fragments != null) {
            ret=fragments.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String ret=null;
        BaseFragment baseFragment = fragments.get(position);
        ret=baseFragment.getFragmentTitle();
        return ret;
    }
}
