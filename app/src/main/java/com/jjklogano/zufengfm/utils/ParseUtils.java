package com.jjklogano.zufengfm.utils;

import android.util.Log;
import com.jjklogano.zufengfm.Constants;
import com.jjklogano.zufengfm.bean.DiscoverCategory;
import com.jjklogano.zufengfm.bean.albumdetails.AlbumDetail;
import com.jjklogano.zufengfm.bean.discoverRecommend.DiscoverRecommend;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析工具类
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class ParseUtils {


    public static List<DiscoverCategory> parseDiscoverCategories(JSONObject jsonObject){
         List<DiscoverCategory> ret = null;
        if (jsonObject != null) {
            try {
                int code = jsonObject.getInt("ret");
                if (code == Constants.TASK_RESULT_OK){
                    ret=new ArrayList<>();

                    JSONArray list = jsonObject.getJSONArray("list");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject object = list.getJSONObject(i);

                        DiscoverCategory category=new DiscoverCategory();
                        //利用实体类实现内部解析，外部的代码调用方法即可，代码简洁
                        category.parseJson(object);

                        ret.add(category);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
             }
        }
        return ret;
    }

    public static DiscoverRecommend parseDiscoverRecommend(JSONObject jsonObject) {
        DiscoverRecommend ret = null;

        if (jsonObject != null) {
            try {
                int code = jsonObject.getInt("ret");
                if (code == Constants.TASK_RESULT_OK){
                    ret=new DiscoverRecommend();
                    ret.parseJson(jsonObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
    public static AlbumDetail parseAlbumDetail(JSONObject jsonObject) {
        AlbumDetail ret = null;

        if (jsonObject != null) {
            try {
                Log.d("json",jsonObject.toString());
                int code = jsonObject.getInt("ret");
                if (code == Constants.TASK_RESULT_OK){
                    ret=new AlbumDetail();
                    ret.parseJson(jsonObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
}
