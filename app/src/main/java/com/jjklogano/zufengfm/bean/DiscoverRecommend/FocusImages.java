package com.jjklogano.zufengfm.bean.discoverRecommend;

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
public class FocusImages extends  DiscoverRecommendItem{

    /**
     * ret : 0
     * list : [{"id":4791,"shortTitle":"苏得一抖的10个虐恋广播剧","longTitle":"苏得一抖的10个虐恋广播剧","pic":"http://fdfs.xmcdn.com/group14/M0A/88/A7/wKgDZFYmFcLgyMbqAAGl4wrzmwI901_android_large.jpg","type":9,"specialId":408,"subType":2,"isShare":false,"is_External_url":false},{"id":4790,"shortTitle":"扶老人险才3块","longTitle":"扶老人险才3块","pic":"http://fdfs.xmcdn.com/group16/M06/88/A9/wKgDbFYmEGXh_B64AAHIfsKkZvI002_android_large.jpg","type":2,"uid":30495264,"albumId":3086917,"isShare":false,"is_External_url":false},{"id":4768,"shortTitle":"比亚迪（3首页广告 1020）","longTitle":"比亚迪（3首页广告 1020）","pic":"http://fdfs.xmcdn.com/group15/M01/87/DC/wKgDaFYksh2Q19f9AAGNt6nm-Kg508_android_large.jpg","type":4,"url":"http://mall.bydauto.com.cn/index.php/drive/index/tang/memo/ximalaya/","isShare":false,"is_External_url":true},{"id":4792,"shortTitle":"万一单身一辈子，照样活的精彩！","longTitle":"万一单身一辈子，照样活的精彩！","pic":"http://fdfs.xmcdn.com/group12/M01/88/3C/wKgDW1YmFk-Qio3DAAGbEgmZ6BM067_android_large.jpg","type":3,"uid":1014665,"trackId":9289211,"isShare":false,"is_External_url":false},{"id":4789,"shortTitle":"魅族发布会（首页合作图）","longTitle":"魅族发布会（首页合作图）","pic":"http://fdfs.xmcdn.com/group16/M0A/88/A9/wKgDbFYmDrrCceKcAAEzdLKQVf0559_android_large.jpg","type":4,"url":"http://m.ximalaya.com/xlive/18","isShare":true,"is_External_url":false},{"id":4745,"shortTitle":"丰田","longTitle":"丰田","pic":"http://fdfs.xmcdn.com/group11/M03/79/04/wKgDa1Yg15HgMKXrAAFRTyA-gNE004_android_large.jpg","type":4,"url":"http://www.tpark-toyota.com/mobile/game.html","isShare":false,"is_External_url":true},{"id":4793,"shortTitle":"空战之父\u201c波爷\u201d：德国人有多怕他？","longTitle":"空战之父\u201c波爷\u201d：德国人有多怕他？","pic":"http://fdfs.xmcdn.com/group15/M05/88/A2/wKgDaFYmFqGS6f0uAAFiX5xE0Nw616_android_large.jpg","type":3,"uid":19269846,"trackId":9240040,"isShare":false,"is_External_url":false},{"id":4794,"shortTitle":"白岩松新书《白说》：漂亮的失败也是一种成功","longTitle":"白岩松新书《白说》：漂亮的失败也是一种成功","pic":"http://fdfs.xmcdn.com/group10/M03/88/51/wKgDaVYmFsjzfnQuAAFeNhQJTDQ609_android_large.jpg","type":3,"uid":1450037,"trackId":9039121,"isShare":false,"is_External_url":false}]
     * title : 焦点图
     */

    private List<FocusImage> list;

    public void setList(List<FocusImage> list) {
        this.list = list;
    }

    public List<FocusImage> getList() {
        return list;
    }

    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            super.parseJson(jsonObject);
            list=new ArrayList<>();
            JSONArray array = jsonObject.getJSONArray("list");
            for (int i = 0; i < array.length(); i++) {
                FocusImage focusImage=new FocusImage();
                focusImage.parseJson(array.getJSONObject(i));
                list.add(focusImage);
            }
        }
    }

    public static class FocusImage {
        /**
         * id : 4791
         * shortTitle : 苏得一抖的10个虐恋广播剧
         * longTitle : 苏得一抖的10个虐恋广播剧
         * pic : http://fdfs.xmcdn.com/group14/M0A/88/A7/wKgDZFYmFcLgyMbqAAGl4wrzmwI901_android_large.jpg
         * type : 9
         * specialId : 408
         * subType : 2
         * isShare : false
         * is_External_url : false
         */

        private int id;
        private String shortTitle;
        private String longTitle;
        private String pic;
        private int type;
        private int specialId;
        private int subType;
        private boolean isShare;
        private boolean is_External_url;

        public void setId(int id) {
            this.id = id;
        }

        public void setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
        }

        public void setLongTitle(String longTitle) {
            this.longTitle = longTitle;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setSpecialId(int specialId) {
            this.specialId = specialId;
        }

        public void setSubType(int subType) {
            this.subType = subType;
        }

        public void setIsShare(boolean isShare) {
            this.isShare = isShare;
        }

        public void setIs_External_url(boolean is_External_url) {
            this.is_External_url = is_External_url;
        }

        public int getId() {
            return id;
        }

        public String getShortTitle() {
            return shortTitle;
        }

        public String getLongTitle() {
            return longTitle;
        }

        public String getPic() {
            return pic;
        }

        public int getType() {
            return type;
        }

        public int getSpecialId() {
            return specialId;
        }

        public int getSubType() {
            return subType;
        }

        public boolean getIsShare() {
            return isShare;
        }

        public boolean getIs_External_url() {
            return is_External_url;
        }

        public void parseJson(JSONObject jsonObject) throws JSONException {
            if (jsonObject != null) {
                id = jsonObject.getInt("id");
                shortTitle = jsonObject.getString("shortTitle");
                longTitle = jsonObject.getString("longTitle");
                type = jsonObject.getInt("type");
                specialId = jsonObject.optInt("specialId");
                pic = jsonObject.getString("pic");
                subType = jsonObject.optInt("subType");
                isShare = jsonObject.optBoolean("isShare");
                is_External_url = jsonObject.optBoolean("is_External_url");
            }
        }
    }
}
