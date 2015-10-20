package com.jjklogano.zufengfm.tasks;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.jjklogano.zufengfm.cache.FileCache;
import com.jjklogano.zufengfm.cache.MemoryCache;
import com.jjklogano.zufengfm.utils.HttpTools;
import com.jjklogano.zufengfm.utils.ImageDecodeTools;

import java.lang.ref.WeakReference;

/**
 * 图片加载异步任务<br/>
 * 已实现三级缓存<br/>
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/12<br/>
 */
public class ImageLoadTask extends AsyncTask<String, Integer, Bitmap> {

    //使用弱引用来进行ImageView的医用，当UI销毁是，任务不再使用ImageVIew
    private final WeakReference<ImageView> ImageViewReference;

    //图片需求宽高
    private int requestWidth;
    private int requestHeight;

    /**
     * 图片加载异步任务
     *
     * @param imageView     ImageView 需要显示的ImageView
     * @param requestWidth  请求的宽度，0表示不进行缩放
     * @param requestHeight 请求的宽度，0表示不进行缩放
     */
    public ImageLoadTask(ImageView imageView, int requestWidth, int requestHeight) {
        ImageViewReference = new WeakReference<ImageView>(imageView);
        this.requestHeight = requestHeight;
        this.requestWidth = requestWidth;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap ret = null;
        byte[] data = null;
        if (params != null && params.length > 0) {
            String url = params[0];
            //获取url中对应的内存缓存
            data = MemoryCache.getInstance().getFromMemory(url);
            if(data!=null){
                //内存中存在，不需要从文件或网络中加载
            }else {
                data = FileCache.getInstance().load(url);
                if (data != null) {
                    //TODO 有文件，不需要联网
                    Log.d("have!", "doInBackground havelocal");
                } else {
                    //TODO 联网下载文件
                    Log.d("have!", "doInBackground donthavelocal");
                    data = HttpTools.doGet(url);
                    //保存到内存中
                    MemoryCache.getInstance().addToMemory(url,data);
                    //保存文件到缓存中
                    FileCache.getInstance().save(url, data);
                }
            }
        }
        ret= ImageDecodeTools.decode(data, requestWidth, requestHeight);
        return ret;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            //获取弱引用包含的对象（可能为空）
            ImageView imageView = ImageViewReference.get();
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                //每一个图片都可以包含AsyncDrawable对象，用于处理图片错位
                if (drawable != null && drawable instanceof AsyncDrawable) {
                    //需要检测图片错位
                    ImageLoadTask imageLoadTask = ((AsyncDrawable) drawable).getImageLoadTask();
                    //当前ImageVIew内部包含的AsyncDrawable和当前任务是对应的，可以设置图片
                    if (this == imageLoadTask) {
                        imageView.setImageBitmap(bitmap);
                    }
                } else {//不用检测图片错位情况
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }
}
