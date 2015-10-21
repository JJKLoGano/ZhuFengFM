package com.jjklogano.zufengfm.adapters;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/21<br/>
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.bean.discoverRecommend.*;
import com.jjklogano.zufengfm.tasks.AsyncDrawable;
import com.jjklogano.zufengfm.tasks.ImageLoadTask;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 发现-》推荐部分的ListView的Adapter
 */
public class DiscoverRecommendAdapter extends BaseAdapter {

    private static final int TYPE_COUNT=3;

    private static final int TYPE_RECOMMENDALBUMS = 0;
    private static final int TYPE_DISCOVERYCOLUMNS = 1;
    private static final int TYPE_SPECIALCOLUMS = 2;
    private static final int TYPE_HOTRECOMMENDS = 0;


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
    public int getItemViewType(int position) {
        int type=0;
        DiscoverRecommendItem item = items.get(position);
        if (item instanceof RecommendAlbums){//小编推荐
            type = TYPE_RECOMMENDALBUMS;
        }else if(item instanceof DiscoveryColumns){//发现新奇
            type = TYPE_DISCOVERYCOLUMNS;
        }else if(item instanceof SpecialColumns){//精品听单
            type = TYPE_SPECIALCOLUMS;
        }
//        else if (item instanceof HotRecommends.Recommends){//小分类群
//            type = TYPE_HOTRECOMMENDS;
//        }
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        //1、获取数据
        DiscoverRecommendItem item = items.get(position);

        if (item instanceof RecommendAlbums) {//小编推荐
            view = bindAlbumsView(position, convertView, parent);
        }
        else if(item instanceof DiscoveryColumns){//发现新奇
            view = bindColumnView(position,convertView,parent);
        }else if(item instanceof SpecialColumns){//精品听单
            view = bindSpecialView(position, convertView, parent);
        }
//        else if(item instanceof HotRecommends.Recommends){//精品听单
//            view = bindAlbumsView(position, convertView, parent);
//        }
        return view;
    }

    /**
     * 使用反射找到指定ID代表的View
     * @param container
     * @param fieldName
     * @return
     */
    public static View findView(View container,String fieldName){
        View ret = null;
        if (container != null && fieldName!=null) {
            Class<R.id> idClass = R.id.class;
            try {
                Field declaredField = idClass.getDeclaredField(fieldName);
                int id = declaredField.getInt(idClass);
                ret = container.findViewById(id);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return ret;
    }

    public void loadImage(ImageView imageView,String url){
        ImageLoadTask imageLoadTask = new ImageLoadTask(imageView, 256, 128);

        //采用指定一Drawable来进行图片错位处理
        AsyncDrawable drawable = new AsyncDrawable(context.getResources(),
                null,
                imageLoadTask);
        imageView.setImageDrawable(drawable);

        //先设置，后执行
        imageLoadTask.execute(url);
    }


    private View bindAlbumsView(int position,View convertView,ViewGroup parent){
        View view=null;
        //复用
        if (convertView != null) {
            view = convertView;
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.discover_recommend_album_item,parent,false);
        }
        //ViewHolder
        AlbumViewHolder holder = (AlbumViewHolder) view.getTag();
        if (holder == null) {
            holder = new AlbumViewHolder();
            view.setTag(holder);

            holder.txtTitle = (TextView) view.findViewById(R.id.discover_recommend_album_item_title);
            holder.txtMore = (TextView) view.findViewById(R.id.discover_recommend_album_item_more);

            holder.albumIcons = new ImageView[3];
            holder.albumNames = new TextView[3];
            holder.trackNames = new TextView[3];

            for (int i = 0; i < 3; i++) {
                holder.albumIcons[i] = (ImageView) findView(view,"discover_recommend_album_item_icon_"+i);
                holder.albumNames[i] = (TextView) findView(view,"discover_recommend_album_item_name_"+i);
                holder.trackNames[i] = (TextView) findView(view,"discover_recommend_album_item_track_name_"+i);
            }
        }

        //设置内容
        RecommendAlbums albums = (RecommendAlbums) items.get(position);
        String title = albums.getTitle();
        holder.txtTitle.setText(title);

        List<AlbumRecommend> list = albums.getList();

        for (int i = 0; i < 3; i++) {
            AlbumRecommend albumRecommend = list.get(i);

            loadImage(holder.albumIcons[i],albumRecommend.getCoverLarge());

            holder.albumNames[i].setText(albumRecommend.getTitle());
            holder.trackNames[i].setText(albumRecommend.getTrackTitle());
        }

        return view;
    }


    private View bindColumnView(int position,View convertView,ViewGroup parent){
        View view=null;
        //复用
        if (convertView != null) {
            view = convertView;
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.discover_recommend_discover_item,parent,false);
        }
        //ViewHolder
        DiscoverViewHolder holder = (DiscoverViewHolder) view.getTag();
        if (holder == null) {
            holder = new DiscoverViewHolder();
            view.setTag(holder);

            holder.txtTitle = (TextView) view.findViewById(R.id.discover_recommend_discover_item_title);

            holder.discoverIcons = new ImageView[4];
            holder.discoverTitles= new TextView[4];
            holder.subTitles = new TextView[4];

            for (int i = 0; i < 4; i++) {
                holder.discoverIcons[i] = (ImageView) findView(view,"discover_recommend_discover_item_icon_"+i);
                holder.discoverTitles[i] = (TextView) findView(view,"discover_recommend_discover_item_title_"+i);
                holder.subTitles[i] = (TextView) findView(view,"discover_recommend_discover_item_subtitle_"+i);
            }
        }

        //设置内容
        DiscoveryColumns columns = (DiscoveryColumns) items.get(position);
        String title = columns.getTitle();
        holder.txtTitle.setText(title);

        List<DiscoveryColumns.DiscoveryColumn> list = columns.getList();

        for (int i = 0; i < 4; i++) {
            DiscoveryColumns.DiscoveryColumn discoveryColumn = list.get(i);

            loadImage(holder.discoverIcons[i],discoveryColumn.getCoverPath());

            holder.discoverTitles[i].setText(discoveryColumn.getTitle());
            holder.subTitles[i].setText(discoveryColumn.getSubtitle());
        }

        return view;
    }

    private View bindSpecialView(int position,View convertView,ViewGroup parent){
        View view=null;
        //复用
        if (convertView != null) {
            view = convertView;
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.discover_recommend_special_item,parent,false);
        }
        //ViewHolder
        SpecialViewHolder holder = (SpecialViewHolder) view.getTag();
        if (holder == null) {
            holder = new SpecialViewHolder();
            view.setTag(holder);

            holder.txtTitle = (TextView) view.findViewById(R.id.discover_recommend_special_item_title);
            holder.txtMore = (TextView) view.findViewById(R.id.discover_recommend_special_item_more);

            holder.specialIcons = new ImageView[2];
            holder.specialTitles= new TextView[2];
            holder.subTitles = new TextView[2];
            holder.counts = new TextView[2];

            for (int i = 0; i < 2; i++) {
                holder.specialIcons[i] = (ImageView) findView(view,"discover_recommend_special_item_icon_"+i);
                holder.specialTitles[i] = (TextView) findView(view,"discover_recommend_special_item_title_"+i);
                holder.subTitles[i] = (TextView) findView(view,"discover_recommend_special_item_subtitle_"+i);
                holder.counts[i] = (TextView) findView(view,"discover_recommend_special_item_count_"+i);
            }
        }

        //设置内容
        SpecialColumns columns = (SpecialColumns) items.get(position);
        String title = columns.getTitle();
        holder.txtTitle.setText(title);

        List<SpecialColumns.SpecialColumn> list = columns.getList();

        for (int i = 0; i < 2; i++) {
            SpecialColumns.SpecialColumn specialColumn = list.get(i);

            loadImage(holder.specialIcons[i],specialColumn.getCoverPath());

            holder.specialTitles[i].setText(specialColumn.getTitle());
            holder.subTitles[i].setText(specialColumn.getSubtitle());
            holder.counts[i].setText(specialColumn.getFootnote());
        }
        return view;
    }



    /**
     * 小编推荐、其他子类型使用
     */
    private static class AlbumViewHolder{
        TextView txtTitle;
        TextView txtMore;

        ImageView[] albumIcons;//三张图片，在不同的Relative中
        TextView[] albumNames;//三个专辑标题
        TextView[] trackNames;//三个曲目名称

    }

    private static class SpecialViewHolder{
        TextView txtTitle;
        TextView txtMore;

        ImageView[] specialIcons;
        TextView[] specialTitles;
        TextView[] subTitles;
        TextView[] counts;
    }

    private static class DiscoverViewHolder {
        TextView txtTitle;

        ImageView[] discoverIcons;
        TextView[] discoverTitles;
        TextView[] subTitles;
    }


    }
