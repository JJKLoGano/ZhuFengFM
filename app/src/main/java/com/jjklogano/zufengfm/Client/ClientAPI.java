package com.jjklogano.zufengfm.client;

import android.util.Log;
import com.jjklogano.zufengfm.utils.HttpTools;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.PrivilegedAction;

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
        JSONObject ret=getData("/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2");
        return ret;
    }

    /**
     * 获取发现部分
     *
     * API  /mobile/discovery/v1/recommends?channel=and-f6&device=android&includeActivity=true&includeSpecial=true&scale=2&version=4.1.7.1
     * @param channel  渠道
     * @param includeActivity  是否包含活动
     * @param includeSpecial 是否包含精品听单
     * @return 返回数据
     */
    public static JSONObject getDiscoverRecommends(String channel,boolean includeActivity,boolean includeSpecial){
        if (channel != null) {
            channel = "and-f6";
        }
        JSONObject ret=getData("/mobile/discovery/v1/recommends?"
                +"channel=" +channel
                +"&device=android&includeActivity=" +includeActivity
                +"&includeSpecial=" +includeSpecial
                +"&scale=2&version=4.1.7.1");
        return ret;
    }

    /**
     * 获取专辑详情
     * API   :http://mobile.ximalaya.com/mobile/others/ca/album/track/  203355   /true/ 1 /20?device=android&pageSize=20&albumId=203355&isAsc=true
     *
     */
    public static JSONObject getAlbumDetails(long albumId,long trackId,int pageNum){
        JSONObject ret=getData("/mobile/others/ca/album/track/"
                + albumId
                + "/true/"
                + pageNum
                + "/20?device=android&pageSize=20&albumId="
                + albumId
                + "&isAsc=true");

        return ret;
    }

    public static JSONObject getSplashAdv(){
        JSONObject ret=null;
        byte[] data = HttpTools.doGet("http://ad.ximalaya.com/ting/loading?version=4.1.7&name=loading&appid=0&device=android");

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

    private static JSONObject getData(String path){
        JSONObject ret=null;

        byte[] data = HttpTools.doGet(API_POINT + path);

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
