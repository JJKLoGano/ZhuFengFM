package com.jjklogano.zufengfm;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import com.jjklogano.zufengfm.bean.albumdetails.AlbumTrack;

import java.io.IOException;
import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/24<br/>
 */
public class MusicService extends Service implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private LocalBroadcastManager broadcastManager;
    private List<AlbumTrack> tracks;
    private int playIndex;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化播放器
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);

        //注册广播
//        broadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
//        broadcastManager.registerReceiver();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle attrs = intent.getBundleExtra("attrs");
        int startType = attrs.getInt("startType", Constants.SERVICE_START_TYPE_NULL);

        if (startType == Constants.SERVICE_START_TYPE_NULL) {

        } else if (startType == Constants.SERVICE_START_TYPE_PLAY) {
            //获取播放列表
            tracks = attrs.getParcelableArrayList("tracks");
            if (tracks != null) {
                //获取播放位置
                playIndex = attrs.getInt("playIndex", 0);

                if (playIndex >= tracks.size()) {
                    playIndex = 0;
                }
                //重置播放器状态
                mediaPlayer.reset();

                //获取曲目链接
                String url = tracks.get(playIndex).getPlayUrl32();
                if (url != null) {
                    url = tracks.get(playIndex).getPlayUrl64();
                }

                try {
                    if (url != null) {
                        mediaPlayer.setDataSource(url);
                        mediaPlayer.prepareAsync();// 进入就绪状态
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (startType == Constants.SERVICE_START_TYPE_CHANGE_STATUS) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
//        new ProgressThread().start();
    }

    //预留，切换进度
//    class ProgressChangeReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            // TODO Auto-generated method stub
//            int progress = intent.getIntExtra(Config.EXTRA_PROGRESS_CURRENT, 0);
//            if (mediaPlayer.isPlaying()) {
//                mediaPlayer.seekTo(progress * duration / 100);
//            }
//        }
//
//    }


}
