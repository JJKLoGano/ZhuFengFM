package com.jjklogano.zufengfm.utils;


import android.content.Context;
import android.os.Build;
import android.widget.ImageView;
import com.jjklogano.zufengfm.tasks.AsyncDrawable;
import com.jjklogano.zufengfm.tasks.ImageLoadTask;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Http请求工具类
 * Created
 * Author : LoGano(贾璟琨)
 * Email : mengpangzhi@hotmial.com
 * Date : 2015/10/12
 */

public final class HttpTools {
    public static final String USER_AGENT = "ting_4.1.7(" + Build.MODEL + "," + Build.VERSION.SDK_INT + ")";
    private static final int CONNECT_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 10000;

    private HttpTools() {

    }

    public static void close(Object stream) {
        if (stream != null) {
            try {
                if (stream instanceof Closeable) {
                    ((Closeable) stream).close();
                } else if (stream instanceof HttpURLConnection) {
                    ((HttpURLConnection) stream).disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] doGet(String url) {
        byte[] ret = null;
        if (url != null) {
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            //联网下载文件
            try {
                URL u = new URL(url);
                connection = (HttpURLConnection) u.openConnection();
                //配置连接
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(CONNECT_TIMEOUT);
                connection.setReadTimeout(READ_TIMEOUT);

                //设置通用头信息,告诉服务器客户端可接收数据类型
//                connection.setRequestProperty("accept", "application/*,text/*，image/*.*/*");
                //设置内容压缩格式
                connection.setRequestProperty("Accept-Encoding", "gzip");
                //USER-AGENT
                connection.setRequestProperty("User-Agent", USER_AGENT);

                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    //给data赋值
                    inputStream = connection.getInputStream();
                    //TODO 进行输入流gzip解压缩
                    String encoding = connection.getHeaderField("Content-Encoding");
                    if ("gzip".equals(encoding)) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    ret = StreamTools.readStream(inputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(connection);
                close(inputStream);
            }
        }
        return ret;
    }

    public static byte[] doPost(String url, HashMap<String, String> params) {
        byte[] ret = null;
        if (url != null) {
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            //post方式联网下载文件
            try {
                URL u = new URL(url);
                connection = (HttpURLConnection) u.openConnection();
                connection.setRequestMethod("POST");// 提交模式
                connection.setDoOutput(true);// 是否输入参数

                StringBuilder paramString = new StringBuilder();
                // 表单参数与get形式一样
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    paramString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
                byte[] bypes = paramString.toString().getBytes();
                outputStream = connection.getOutputStream();
                outputStream.write(bypes);// 输入参数

                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    //给data赋值
                    inputStream = connection.getInputStream();
                    ret = StreamTools.readStream(inputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(connection);
                close(outputStream);
                close(inputStream);
            }
        }
        return ret;
    }
    public static void loadImage(Context context,ImageView imageView,String url){
        ImageLoadTask imageLoadTask = new ImageLoadTask(imageView, 256, 128);

        //采用指定一Drawable来进行图片错位处理
        AsyncDrawable drawable = new AsyncDrawable(context.getResources(),
                null,
                imageLoadTask);
        imageView.setImageDrawable(drawable);

        //先设置，后执行
        imageLoadTask.execute(url);
    }

}
