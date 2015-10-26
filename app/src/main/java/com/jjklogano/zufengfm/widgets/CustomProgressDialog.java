package com.jjklogano.zufengfm.widgets;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.jjklogano.zufengfm.R;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/24<br/>
 */
public class CustomProgressDialog extends ProgressDialog {

    private AnimationDrawable mAnimation;
    private Context mContext;
    private ImageView mImageView;
    private String mLoadingTip;
    private TextView mLoadingTv;
    private int count = 0;
    private String oldLoadingTip;
    private int mResid;

    public CustomProgressDialog(Context context, String content, int id) {
        super(context);
        this.mContext = context;
        this.mLoadingTip = content;
        this.mResid = id;
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {

        mImageView.setImageResource(mResid);
        // 通过ImageView对象拿到背景显示的AnimationDrawable
        mAnimation = (AnimationDrawable) mImageView.getDrawable();
        // 为了防止在onCreate方法中只显示第一帧的解决方案之一
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();

            }
        });
        mLoadingTv.setText(mLoadingTip);

    }

    public void setContent(String str) {
        mLoadingTv.setText(str);
    }

    private void initView() {
        setContentView(R.layout.progress_dialog);
        mLoadingTv = (TextView) findViewById(R.id.loadingTv);
        mImageView = (ImageView) findViewById(R.id.loadingIv);
    }

}
