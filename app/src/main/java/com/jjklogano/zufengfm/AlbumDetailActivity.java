package com.jjklogano.zufengfm;

import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.jjklogano.zufengfm.adapters.AlbumDeailAdapter;
import com.jjklogano.zufengfm.bean.albumdetails.AlbumDetail;
import com.jjklogano.zufengfm.bean.albumdetails.AlbumTrack;
import com.jjklogano.zufengfm.tasks.AlbumDetailTask;
import com.jjklogano.zufengfm.tasks.TaskCallBack;
import com.jjklogano.zufengfm.tasks.TaskResult;
import com.jjklogano.zufengfm.utils.HttpTools;
import com.jjklogano.zufengfm.widgets.FullListView;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetailActivity extends AppCompatActivity implements TaskCallBack ,AppBarLayout.OnOffsetChangedListener {

    private SwipeRefreshLayout refreshLayout;
    private AppBarLayout appBarLayout;
    private ListView listView;

    private List<AlbumTrack> tracks;

    private int pageNum=1;
    private AlbumDeailAdapter adapter;
    private ImageView imgCover;
    private TextView textTilte;
    private TextView textSubTilte;

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

        Bundle attrs = getIntent().getBundleExtra("trackInfo");
        if (attrs != null) {
            attrs.putInt("pageNum",pageNum);
        }
        new AlbumDetailTask(this,attrs).execute();
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

        appBarLayout = (AppBarLayout) findViewById(R.id.album_detail_appbar);

        //为swipeRefreshLayout 添加冲突处理
        SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) findViewById(R.id.album_detail_refresh);


    }

    @Override
    public void onTaskFinished(TaskResult result) {
        AlbumDetail albumDetail = (AlbumDetail) result.data;
        tracks.clear();
        this.tracks.addAll(albumDetail.getTracks());
        adapter.notifyDataSetChanged();

        HttpTools.loadImage(getApplicationContext(),imgCover,albumDetail.getCoverLarge());
        textTilte.setText(albumDetail.getTitle());
        textSubTilte.setText(albumDetail.getIntro());

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

    }
}
