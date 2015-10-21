package com.jjklogano.zufengfm.adapters;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/21<br/>
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.jjklogano.zufengfm.bean.discoverRecommend.DiscoverRecommendItem;

import java.util.List;

/**
 * 发现-》推荐部分的ListView的Adapter
 */
public class DiscoverRecommendAdapter extends BaseAdapter {
    private Context context;
    private List<DiscoverRecommendItem> items;

    public DiscoverRecommendAdapter(Context context, List<DiscoverRecommendItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (items != null) {
            count=items.size();
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        //1、获取数据
        DiscoverRecommendItem item=items.get(position);

        return view;
    }
}
