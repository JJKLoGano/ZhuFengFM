package com.jjklogano.zufengfm;

import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.*;
import com.jjklogano.zufengfm.adapters.AlbumDeailAdapter;
import com.jjklogano.zufengfm.bean.albumdetails.AlbumDetail;
import com.jjklogano.zufengfm.bean.albumdetails.AlbumTrack;
import com.jjklogano.zufengfm.tasks.AlbumDetailTask;
import com.jjklogano.zufengfm.tasks.TaskCallBack;
import com.jjklogano.zufengfm.tasks.TaskResult;
import com.jjklogano.zufengfm.utils.HttpTools;
import com.jjklogano.zufengfm.utils.ImageDecodeTools;
import com.jjklogano.zufengfm.widgets.CircleImageDrawable;
import com.jjklogano.zufengfm.widgets.FullListView;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetailActivity extends AppCompatActivity implements TaskCallBack ,AppBarLayout.OnOffsetChangedListener, SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    private SwipeRefreshLayout refreshLayout;
    private AppBarLayout appBarLayout;
    private ListView listView;

    private ArrayList<AlbumTrack> tracks;

    private int pageNum=1;
    private AlbumDeailAdapter adapter;
    private ImageView imgCover;
    private TextView textTilte;
    private TextView textSubTilte;
    private Bundle attrs;
    private CheckBox playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_detail_activity);
        initUI();
        loadData();
    }

    private void loadData() {

        tracks = new ArrayList<>();

        adapter = new AlbumDeailAdapter(getApplicationContext(),tracks);

        listView.setAdapter(adapter);

        attrs = getIntent().getBundleExtra("trackInfo");
        if (attrs != null) {
            attrs.putInt("pageNum", pageNum);
            attrs.putBoolean("isRefresh", false);
        }
        new AlbumDetailTask(this, attrs).execute();
    }


    private void initUI() {

        //设置顶部工具条
        Toolbar toolbar = (Toolbar) findViewById(R.id.album_detail_toolbar);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置顶部折叠布局参数
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        toolbarLayout.setTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imgCover = (ImageView) findViewById(R.id.album_detail_cover);
        textTilte = (TextView) findViewById(R.id.album_detail_title);
        textSubTilte = (TextView) findViewById(R.id.album_detail_subtitle);

        listView = (ListView) findViewById(R.id.album_detail_list);

        listView.setOnItemClickListener(this);

        appBarLayout = (AppBarLayout) findViewById(R.id.album_detail_appbar);

        //为swipeRefreshLayout 添加冲突处理
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.album_detail_refresh);

        refreshLayout.setOnRefreshListener(this);

        playButton = (CheckBox) findViewById(R.id.album_detail_play_btn);

        playButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        AlbumDetail albumDetail = (AlbumDetail) result.data;

        if (result.action == Constants.TASK_ACTION_ALBUM_DETAIL)
            tracks.clear();

        this.tracks.addAll(albumDetail.getTracks());
        adapter.notifyDataSetChanged();

        HttpTools.loadImage(getApplicationContext(),imgCover,albumDetail.getCoverLarge());
        textTilte.setText(albumDetail.getTitle());
        textSubTilte.setText(albumDetail.getIntro());

        if(refreshLayout.isRefreshing()){
            refreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        refreshLayout.setEnabled(verticalOffset == 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        appBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appBarLayout.removeOnOffsetChangedListener(this);
    }

    @Override
    public void onRefresh() {
        if (attrs != null) {
            attrs.putInt("pageNum", ++pageNum);
            attrs.putBoolean("isRefresh",true);
        }
        new AlbumDetailTask(this, attrs).execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(AlbumDetailActivity.this,MusicService.class);

        Bundle attrs = new Bundle();
        attrs.putInt("startType", Constants.SERVICE_START_TYPE_PLAY);
        attrs.putInt("playIndex", position);
        attrs.putParcelableArrayList("tracks", tracks);

        intent.putExtra("attrs", attrs);

        startService(intent);

        Bitmap bitmap = ((BitmapDrawable) imgCover.getDrawable()).getBitmap();
        bitmap = ImageDecodeTools.getRoundedCornerBitmap(bitmap);
        playButton.setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));

        playButton.setChecked(true);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Intent intent = new Intent(AlbumDetailActivity.this,MusicService.class);

            Bundle attrs = new Bundle();
            attrs.putInt("startType",Constants.SERVICE_START_TYPE_CHANGE_STATUS);
            intent.putExtra("attrs", attrs);

            startService(intent);
    }

}
