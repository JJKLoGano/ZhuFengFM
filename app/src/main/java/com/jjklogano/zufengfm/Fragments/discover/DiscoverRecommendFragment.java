package com.jjklogano.zufengfm.fragments.discover;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import com.jjklogano.zufengfm.Constants;
import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.adapters.DiscoverRecommendAdapter;
import com.jjklogano.zufengfm.bean.discoverRecommend.DiscoverRecommend;
import com.jjklogano.zufengfm.bean.discoverRecommend.DiscoverRecommendItem;
import com.jjklogano.zufengfm.fragments.BaseFragment;
import com.jjklogano.zufengfm.tasks.DiscoverRecommendTask;
import com.jjklogano.zufengfm.tasks.TaskCallBack;
import com.jjklogano.zufengfm.tasks.TaskResult;

import java.util.ArrayList;
import java.util.List;


public class DiscoverRecommendFragment extends BaseFragment implements TaskCallBack {

    private DiscoverRecommendAdapter adapter;
    private List<DiscoverRecommendItem> items;
    private ListView listView;


    public DiscoverRecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.discover_recommend_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.discover_recommend_list);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items = new ArrayList<>();
        adapter=new DiscoverRecommendAdapter(getContext(),items);
    }

    /**
     * 在OnResume中刷新数据
     */
    @Override
    public void onResume() {
        super.onResume();
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
                    if (data != null && data instanceof DiscoverRecommend) {
                        items.clear();
                        items.addAll(((DiscoverRecommend)data).getItemList());
                        adapter.notifyDataSetChanged();
                        Log.d("recommend", "List = " + data.toString());
                    }
                }else{
                    //TODO 加载失败
                }
            }
        }
    }
}
