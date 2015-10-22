package com.jjklogano.zufengfm.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.fragments.discover.DiscoverRecommendFragment;
import com.jjklogano.zufengfm.utils.DimensionUtil;

import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/22<br/>
 */
public class PicPagerAdapter extends PagerAdapter {

    private List<String> images;

    public PicPagerAdapter(List<String> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        //使用整型最大值描述假循环,通过取余映射到正确的数据
        int ret = 0;
        if (images != null) {
            if(images.size()>0)
                ret = Integer.MAX_VALUE;
        }
        return ret;
    }


    /**
     * 返回View 是否由object创建、管理
     * @param view
     * @param object 由instantiateItem()返回
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }


    /**
     * 根据指定位置，创建一个对象，可以是view，也可以是fragment
     * 永远不要调super！！！！！！
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int index = position%images.size();
        //TODO 跟据index获取数据和点击操作

        ImageView ret = new ImageView(container.getContext());

        ret.setImageResource(R.mipmap.ic_launcher);

        ViewGroup.LayoutParams lp =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        DimensionUtil.convertDipToPx(container.getContext(),60)
                );

        return ret;
    }


    /**
     * 根据指定位置，销毁一个view对象或fragmentUI，可以是view，也可以是fragment
     * 永远不要调super！！！！！！
     * @param container
     * @param position
     * @return
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
