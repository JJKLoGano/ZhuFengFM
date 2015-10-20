package com.jjklogano.zufengfm.fragments.discover;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjklogano.zufengfm.Constants;
import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.fragments.BaseFragment;
import com.jjklogano.zufengfm.tasks.DiscoverRecommendTask;
import com.jjklogano.zufengfm.tasks.TaskCallBack;
import com.jjklogano.zufengfm.tasks.TaskResult;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverRecommendFragment extends BaseFragment implements TaskCallBack {


    public DiscoverRecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.discover_recommend_fragment, container, false);
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        
    }

    private void initData() {
        DiscoverRecommendTask task=new DiscoverRecommendTask(this);
        task.execute();
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int action = result.action;

            if (action== Constants.TASK_ACTION_DISCOVER_RECOMMNEND){
                //TODO 将诶过从发现-分类任务中返回，获取的是分类
                if(result.ret == Constants.TASK_RESULT_OK){
                    //TODO 加载成功
                    Object data = result.data;
                    if (data != null && data instanceof List) {
                        List list = (List) data;

                        Log.d("recommend", "List = " + list);
                    }
                }else{
                    //TODO 加载失败
                }
            }
        }
    }
}
