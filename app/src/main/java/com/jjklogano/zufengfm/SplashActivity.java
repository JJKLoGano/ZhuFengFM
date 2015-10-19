package com.jjklogano.zufengfm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import java.util.logging.Handler;

/**
 * 启动扉页
 */
public class SplashActivity extends FragmentActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Thread(this).start();

    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent= new Intent();

        //TODO 如果没有显示欢迎页，启动欢迎页，否则直接启动首页

        SharedPreferences preferences=getSharedPreferences(Constants.SP_NAME,MODE_PRIVATE);

        //利用SP保存字段，判断是哦否显示欢迎页，保存的是程序版本号，用该版本号与当前程序版本号比较，更精确，兼容性更好
        int wsv = preferences.getInt(Constants.SP_KEY_WELCOMESHOWVERSION, 0);

        int versionCode = BuildConfig.VERSION_CODE;

        if(wsv!=versionCode){
            //TODO 显示欢迎页
            intent.setClass(getApplicationContext(),WelcomeActivity.class);
        }else{
            //TODO 显示主页面
            intent.setClass(getApplicationContext(),MainActivity.class);
        }

        startActivity(intent);

        finish();
    }
}
