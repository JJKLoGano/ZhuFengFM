package com.jjklogano.zufengfm;

import android.app.Application;
import com.jjklogano.zufengfm.cache.FileCache;
import com.jjklogano.zufengfm.cache.MemoryCache;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/21<br/>
 */
public class ZhuFengApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MemoryCache.newInstance(getApplicationContext());
        FileCache.newInstance(getApplicationContext());
    }
}
