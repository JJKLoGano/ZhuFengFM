package com.jjklogano.zufengfm.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.bean.albumdetails.AlbumTrack;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/23<br/>
 */
public class AlbumDeailAdapter extends BaseAdapter {
    private Context context;
    private List<AlbumTrack> tracks;

    public AlbumDeailAdapter(Context context, List<AlbumTrack> tracks) {
        this.context = context;
        this.tracks = tracks;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (tracks != null) {
            ret = tracks.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return tracks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tracks.get(position).getTrackId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        if (convertView != null) {
            view = convertView;
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.album_detail_item,null,false);
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder= new ViewHolder();
            holder.textIntro = (TextView) view.findViewById(R.id.album_detail_item_intro);
            holder.textLastUpdate = (TextView) view.findViewById(R.id.album_detail_item_lastupdate);
            holder.textCount = (TextView) view.findViewById(R.id.album_detail_item_count);
            holder.textCommit = (TextView) view.findViewById(R.id.album_detail_item_commit);
            holder.textTime = (TextView) view.findViewById(R.id.album_detail_item_time);
            view.setTag(holder);
        }

        AlbumTrack albumTrack = tracks.get(position);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
        holder.textIntro.setText(albumTrack.getTitle());
        holder.textTime.setText(simpleDateFormat.format(albumTrack.getDuration()));
        holder.textCount.setText(albumTrack.getPlaytimes() + "");
        holder.textCommit.setText(albumTrack.getComments() + "");
        long createdAt = albumTrack.getCreatedAt();
        if (createdAt<0){
            createdAt =-createdAt;
        }
        Log.d("creat" ,createdAt+"");
        long time = createdAt/(long)(1000*60*60);
        if(time<24){
            holder.textLastUpdate.setText(time + "小时前");
        }else{
            time = time/24;
            if (time<30){
                holder.textLastUpdate.setText(time + "天前");
            }else {
                time = time/30;
                if(time<12)
                    holder.textLastUpdate.setText(time + "个月前");
                else{
                    time = time/12;
                    holder.textLastUpdate.setText(time+"年前");
                }
            }
        }


        return view;
    }

    public static class ViewHolder{
        TextView textIntro;
        TextView textCount;
        TextView textCommit;
        TextView textTime;
        TextView textLastUpdate;
    }
}
