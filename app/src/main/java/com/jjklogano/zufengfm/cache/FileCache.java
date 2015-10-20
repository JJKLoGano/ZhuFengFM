package com.jjklogano.zufengfm.cache;

import android.content.Context;
import android.os.Environment;
import com.jjklogano.zufengfm.utils.EncryptTools;
import com.jjklogano.zufengfm.utils.StreamTools;

import java.io.*;

/**
 * 文件缓存类<br/>
 * 三级缓存<br/>
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/12<br/>
 */
public class FileCache {
    private static FileCache ourInstance;
    private Context context;

    public static FileCache newInstance(Context context){
        if (context != null) {
            ourInstance=new FileCache(context);
        }else{
            throw new IllegalArgumentException("Context MUST BE SET");
        }
        return ourInstance;
    }

    public static FileCache getInstance() {
        if (ourInstance == null) {
            throw new IllegalStateException("newInstance() MUST BE CALLED BEFORE getInstance()");
        }
        return ourInstance;
    }

    private FileCache(Context context) {
        this.context=context;
    }

    /**
     * 从文件加载对应内容
     * @param url 网址
     * @return
     */
    public byte[] load(String url){
        //TODO 通过网址找文件
        byte[] ret=null;
        if (url != null) {
            //1、文件缓存目录
            File cacheDir = null;
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                cacheDir=context.getExternalCacheDir();
            } else {
                //内部存储缓存
                cacheDir = context.getCacheDir();
            }
            //2、映射文件名称
            String fileName= EncryptTools.getMD5String(url);
            File targetFile = new File(cacheDir,fileName);
            //3、IO操作取文件
            if(targetFile.exists()){
                FileInputStream fin= null;
                try {
                    fin = new FileInputStream(targetFile);
                    ret = StreamTools.readStream(fin);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    /**
     * 保存对应数据到文件中
     * @param url
     * @param data
     */
    public void save(String url,byte[] data){
        //TODO 通过网址存文件
        if(url!=null&&data!=null) {
            //1、文件缓存目录
            File cacheDir = null;
            String state = Environment.getExternalStorageState();

            if (Environment.MEDIA_MOUNTED.equals(state)) {
                cacheDir=context.getExternalCacheDir();
            } else {
                //内部存储缓存
                cacheDir = context.getCacheDir();
            }

            //2、映射文件名称
            String fileName= EncryptTools.getMD5String(url);

            File targetFile = new File(cacheDir,fileName);

            //3、IO操作
            FileOutputStream fout=null;
            try {
                fout = new FileOutputStream(targetFile);
                fout.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fout != null) {
                    try {
                        fout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
