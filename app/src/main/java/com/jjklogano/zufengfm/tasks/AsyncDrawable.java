package com.jjklogano.zufengfm.tasks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import java.lang.ref.WeakReference;

/**
 * Created
 * Author : LoGano(贾璟琨)
 * Email : mengpangzhi@hotmial.com
 * Date : 2015/10/12
 */
public class AsyncDrawable extends BitmapDrawable {
    private final WeakReference<ImageLoadTask> taskWeakReference;

    /**
     * 模拟一个BitmapDrawable对象，可以直接给ImageView设置
     *
     * @param res
     * @param bitmap
     * @param task
     */
    public AsyncDrawable(Resources res, Bitmap bitmap, ImageLoadTask task) {
        super(res, bitmap);
        this.taskWeakReference = new WeakReference<ImageLoadTask>(task);
    }

    /**
     * 获取当前Drawable包含的异步任务
     *
     * @return
     */
    public ImageLoadTask getImageLoadTask() {
        ImageLoadTask ret = null;
        ret = taskWeakReference.get();
        return ret;
    }
}
