package com.jjklogano.zufengfm.client;

import com.jjklogano.zufengfm.utils.HttpTools;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class ClientAPI {

    /**
     * 服务器根路径，便于迁移使用
     */
    public static final String API_POINT="http://mobile.ximalaya.com";

    /**
     * 获取发现分类<br/>
     *
     * API  /mobile/discovery/v1/categories?device=android&picVersion=10&scale=2
     *
     * @return 分类详情
     */
    public static JSONObject getDiscoverCategories(){
        JSONObject ret=null;

        byte[] data = HttpTools.doGet(API_POINT + "/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2");

        if (data != null) {
            try {
                String str = new String(data,"utf-8");
                ret = new JSONObject(str);
            } catch (UnsupportedEncodingException | JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
