package com.jjklogano.zufengfm.fragments.discover;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import com.jjklogano.zufengfm.Constants;
import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.adapters.DiscoverCategoryAdapter;
import com.jjklogano.zufengfm.bean.DiscoverCategory;
import com.jjklogano.zufengfm.fragments.BaseFragment;
import com.jjklogano.zufengfm.tasks.DiscoverCategoryTask;
import com.jjklogano.zufengfm.tasks.TaskCallBack;
import com.jjklogano.zufengfm.tasks.TaskResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverCategoryFragment extends BaseFragment implements TaskCallBack {


    private List<DiscoverCategory> categories;
    private View view;
    private ListView listView;
    private DiscoverCategoryAdapter adapter;

    public DiscoverCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.discover_category_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.discover_category_list);

        categories = new ArrayList<>();

        adapter = new DiscoverCategoryAdapter(getContext(),categories);

        listView.setAdapter(adapter);

        return view;
    }


    @Override
    public String getFragmentTitle() {
        return "分类";
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        DiscoverCategoryTask task=new DiscoverCategoryTask(this);
        task.execute();
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int action = result.action;

            if (action== Constants.TASK_ACTION_DISCOVER_CATEGORIES){
                //TODO 将诶过从发现-分类任务中返回，获取的是分类
                if(result.ret == Constants.TASK_RESULT_OK){
                    //TODO 加载成功
                    Object data = result.data;
                    if (data != null && data instanceof List) {
                        categories.clear();
                        categories.addAll((List<DiscoverCategory>) data);
                        adapter.notifyDataSetChanged();
                    }
                }else{
                    //TODO 加载失败
                }
            }
        }
    }
}
