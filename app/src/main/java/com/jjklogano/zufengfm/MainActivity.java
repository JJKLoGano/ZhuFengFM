package com.jjklogano.zufengfm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import com.jjklogano.zufengfm.fragments.CustomTingFragment;
import com.jjklogano.zufengfm.fragments.DiscoverFragment;
import com.jjklogano.zufengfm.fragments.DownloadTingFragment;
import com.jjklogano.zufengfm.fragments.PersonalFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    /**
     * 主界面中第一层Fragment，发现，定制听，下载听，我
     */
    private Fragment[] fragments;
    private FragmentManager manager;
    private int showingIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        manager = getSupportFragmentManager();

        //TODO 测试横竖屏切换数组对象状态，内部是否置空
        fragments = new Fragment[4];

        if (savedInstanceState != null) {
            //activity重新创建，还原fragment
            int len = fragments.length;

            for (int i = 0; i < len; i++) {
                //TODO FRAGMENT
                fragments[i] = manager.findFragmentByTag("f" + i);
            }
            FragmentTransaction transaction = manager.beginTransaction();

            for (int i = 0; i < fragments.length; i++) {
                transaction
                        .hide(fragments[i]);
            }
            transaction.show(fragments[0]);

            transaction.commit();
        } else {
            fragments[0] = new DiscoverFragment();

            fragments[1] = new CustomTingFragment();

            fragments[2] = new DownloadTingFragment();

            fragments[3] = new PersonalFragment();

            FragmentTransaction transaction = manager.beginTransaction();

            for (int i = 0; i < fragments.length; i++) {
                transaction
                        .add(R.id.main_fragment_container, fragments[i], "f" + i)
                        .hide(fragments[i]);
            }
            transaction.show(fragments[0]);

            transaction.commit();
        }
        showingIndex = 0;

        RadioGroup group = (RadioGroup) findViewById(R.id.main_tab_bar);

        group.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int index = 0;
        switch (checkedId) {
            case R.id.main_tab_item_discover:
                index = 0;
                break;
            case R.id.main_tab_item_custom:
                index = 1;
                break;
            case R.id.main_tab_item_download:
                index = 2;
                break;
            case R.id.main_tab_item_personal:
                index = 3;
                break;
        }
        if (manager != null && index < fragments.length) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.hide(fragments[showingIndex]).show(fragments[index]).commit();
            showingIndex = index;
        }
    }
}
