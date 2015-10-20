package com.jjklogano.zufengfm.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * 图片解码工具类<br/>
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/12<br/>
 */
public final class ImageDecodeTools {

    private ImageDecodeTools(){

    }

    public static Bitmap decode(byte[] data,int requestWidth,int  requestHeight){
        //TODO 采用二次采样（缩小图片尺寸的方式）
        Bitmap ret=null;
        //按照原始图片尺寸（分辨率）生成，并且每一个像素占用4个字节，若原图尺寸太大 ARGB
        //1、获取原始图片的宽高信息，用于进行采样
        //1.1创建Options，给BitmapFactory的内部解码器传递参数
        BitmapFactory.Options opts = new BitmapFactory.Options();
        //1、2设置inJustDecodeBounds=true,只进行图片宽高的获取，不分配图片内存，放使用这个参数时Bitmap.decodeXXXX()返回null；
        opts.inJustDecodeBounds = true;
        //采样解码
        BitmapFactory.decodeByteArray(data, 0, data.length, opts);
        //=================================================================
        //2、根据图片真实尺寸，于当前需要尺寸进行计算，生成图片采样率
        //2.2准备先是在手机上的尺寸。256x128? 128x64?
        //2.3 计算、设置图片采样率
        opts.inSampleSize = calculateInSampleSize(opts, requestWidth, requestHeight);//宽度的1/16，高度的1/16
        //2.4 开放解码，实际生成Bitmap
        opts.inJustDecodeBounds = false;
        //2.4.1 Bitmap.Config的说明
        opts.inPreferredConfig = Bitmap.Config.RGB_565;//要求解码器使用RGB_565颜色,一个像素两个字节
        //2.4.2 （过时）像素可回收，需要时重新解码，
        //opts.inPurgeable=true;
        //2.5 使用设置采样的参数，来进行解码
        ret = BitmapFactory.decodeByteArray(data, 0, data.length, opts);

        return ret;
    }

    /**
     * 计算图片二次采样采样率并且通过请求的宽高尺寸进行采样率计算
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return int 采样率
     */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        //当请求宽度、高度>0是缩放，否则原始大小
        if (reqWidth > 0 && reqHeight > 0) {
            if (height > reqHeight || width > reqWidth) {
                final int halfHeight = height / 2;
                final int halfWidth = width / 2;
                // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                // height and width larger than the requested height and width.
                while ((halfHeight / inSampleSize) >= reqHeight
                        && (halfWidth / inSampleSize) >= reqWidth) {
                    inSampleSize *= 2;
                }
            }
        }
        return inSampleSize;
    }
}
