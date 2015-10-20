package com.jjklogano.zufengfm.bean.DiscoverRecommend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class Entrances {

    /**
     * ret : 0
     * list : [{"id":1,"entranceType":"live","coverPath":"http://fdfs.xmcdn.com/group15/M0A/6E/58/wKgDaFXxN2qRMtjIAAAGQuZzM2Q045.png","title":"热门直播"}]
     */

    private int ret;
    private List<Entrance> list;

    public void setRet(int ret) {
        this.ret = ret;
    }

    public void setList(List<Entrance> list) {
        this.list = list;
    }

    public int getRet() {
        return ret;
    }

    public List<Entrance> getList() {
        return list;
    }


    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            ret = jsonObject.getInt("ret");
            list=new ArrayList<>();
            JSONArray array = jsonObject.getJSONArray("list");
            for (int i = 0; i < array.length(); i++) {
                Entrance entrance=new Entrance();
                entrance.parseJson(array.getJSONObject(i));
                list.add(entrance);
            }
        }
    }

    public static class Entrance {
        /**
         * id : 1
         * entranceType : live
         * coverPath : http://fdfs.xmcdn.com/group15/M0A/6E/58/wKgDaFXxN2qRMtjIAAAGQuZzM2Q045.png
         * title : 热门直播
         */

        private int id;
        private String entranceType;
        private String coverPath;
        private String title;

        public void setId(int id) {
            this.id = id;
        }

        public void setEntranceType(String entranceType) {
            this.entranceType = entranceType;
        }

        public void setCoverPath(String coverPath) {
            this.coverPath = coverPath;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public String getEntranceType() {
            return entranceType;
        }

        public String getCoverPath() {
            return coverPath;
        }

        public String getTitle() {
            return title;
        }

        public void parseJson(JSONObject jsonObject) throws JSONException {
            if (jsonObject != null) {
                id = jsonObject.getInt("id");
                entranceType = jsonObject.getString("entranceType");
                coverPath = jsonObject.getString("coverPath");
                title = jsonObject.getString("title");
            }
        }
    }


}
