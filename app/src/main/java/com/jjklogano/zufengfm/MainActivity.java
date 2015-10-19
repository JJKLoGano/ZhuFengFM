package com.jjklogano.zufengfm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import com.jjklogano.zufengfm.Fragments.CustomTingFragment;
import com.jjklogano.zufengfm.Fragments.DiscoverFragment;
import com.jjklogano.zufengfm.Fragments.DownloadTingFragment;
import com.jjklogano.zufengfm.Fragments.PersonalFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    /**
     * 主界面中第一层Fragment，发现，定制听，下载听，我
     */
    private Fragment[] fragments;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        fragments=new Fragment[4];

        fragments[0]=new DiscoverFragment();

        fragments[1] = new CustomTingFragment();

        fragments[2] = new DownloadTingFragment();

        fragments[3] = new PersonalFragment();

        manager =getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        for (Fragment fragment : fragments) {
            transaction
                    .add(R.id.main_fragment_container, fragment)
                    .hide(fragment);
        }
        transaction.show(fragments[0]);

        transaction.commit();

        RadioGroup group= (RadioGroup) findViewById(R.id.main_tab_bar);

        group.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int index=0;
        switch (checkedId){
            case R.id.main_tab_item_discover:
                index=0;
                break;
            case R.id.main_tab_item_custom:
                index=1;
                break;
            case R.id.main_tab_item_download:
                index=2;
                break;
            case R.id.main_tab_item_personal:
                index=3;
                break;
        }
        if (manager != null&&index<fragments.length) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.show(fragments[index]).commit();
        }
    }
}
