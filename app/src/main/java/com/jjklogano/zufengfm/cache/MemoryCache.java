package com.jjklogano.zufengfm.cache;

import android.content.Context;
import android.util.LruCache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 内存缓存类<br/>
 * 一级、二级缓存<br/>
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/12<br/>
 */
public class MemoryCache{
    private static MemoryCache ourInstance;

    private static LruCache<String,byte[]> lruCache;
    private static Map<String,SoftReference<byte[]>> softCache;

    private MemoryCache (Context context){

    }
    public static MemoryCache newInstance(Context context){
        if (context != null) {
            ourInstance=new MemoryCache(context);
            softCache=new HashMap<>();
            lruCache=new LruCache<String,byte[]>(2*1024*1024){
                @Override
                protected void entryRemoved(boolean evicted, String key, byte[] oldValue, byte[] newValue) {
                    super.entryRemoved(evicted, key, oldValue, newValue);
                    if(evicted)
                        //将移除的成员存放到二级缓存中
                        softCache.put(key, new SoftReference<>(oldValue));
                }
            };
        }else{
            throw new IllegalArgumentException("Context MUST BE SET");
        }
        return ourInstance;
    }

    public static MemoryCache getInstance() {
        if (ourInstance == null) {
            throw new IllegalStateException("newInstance() MUST BE CALLED BEFORE getInstance()");
        }
        return ourInstance;
    }

    public void addToMemory(String url,byte[] data){
        lruCache.put(url,data);
    }

    public byte[] getFromMemory(String url){
        byte[] ret=null;
        //先从一级缓存中获取
        ret=lruCache.get(url);
        if (ret == null) {
            //从二级缓存中读取
            SoftReference<byte[]> softReference = softCache.get(url);
            if(softReference!=null){
                ret=softReference.get();
                if(ret!=null){//二级缓存中存在
                    //将图片对象存放在一级缓存
                    lruCache.put(url,ret);
                    //从二级缓存中移除
                    softCache.remove(url);
                }
            }
        }
        return ret;
    }




}
