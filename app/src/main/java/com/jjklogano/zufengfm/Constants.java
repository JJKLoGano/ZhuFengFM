package com.jjklogano.zufengfm;

/**
 * 定义了通用内容的常量，可在全局中使用
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/19<br/>
 */
public class Constants {

    public static final String SP_NAME="app";

    //欢迎页显示版本
    public static final String SP_KEY_WELCOMESHOWVERSION="wsv";

    public static final int TASK_RESULT_OK = 0;


    //==================================================
    //异步任务Action
    public static final int TASK_ACTION_ADVERTISMENT = 0;
    public static final int TASK_ACTION_DISCOVER_CATEGORIES = 1;
    public static final int TASK_ACTION_DISCOVER_RECOMMNEND = 2;
    public static final int TASK_ACTION_ALBUM_DETAIL = 3;
    public static final int TASK_ACTION_ALBUM_DETAIL_REFRESH=4;



    public static final String TAG_DISCOVER_RECOMMENDS_ALBUM= "albumRecommend:";

    //服务启动类别
    public static final int SERVICE_START_TYPE_NULL = 0;
    public static final int SERVICE_START_TYPE_PLAY = 1;
    public static final int SERVICE_START_TYPE_CHANGE_STATUS = 2;
            ;
}
