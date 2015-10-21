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
public class DiscoveryColumns extends DiscoverRecommendItem{


    /**
     * ret : 0
     * title : 发现新奇
     * list : [{"id":1,"orderNum":2,"title":"听友圈子","subtitle":"玩个游戏呗 格式：回答楼上问题+想问楼下问题","coverPath":"http://fdfs.xmcdn.com/group9/M07/1C/8C/wKgDYlV3rd2zGc9PAAAgRAu1VLU052.png","contentType":"xzone","url":"","sharePic":"","enableShare":false,"contentUpdatedAt":0},{"id":2,"orderNum":1,"title":"活动","subtitle":"百度地图\u2014寻找最美女声","coverPath":"http://fdfs.xmcdn.com/group9/M07/1C/8C/wKgDYlV3reewe4kXAAAUNfIrwHU252.png","contentType":"activity","url":"","sharePic":"","enableShare":false,"isHot":true,"contentUpdatedAt":0},{"id":3,"orderNum":3,"title":"新声活商城","subtitle":"各种新奇的有声智能硬件","coverPath":"http://fdfs.xmcdn.com/group9/M07/1C/8D/wKgDYlV3rfDRIBojAAAVB1veXSo547.png","contentType":"html5.mall","url":"http://www.wemart.cn/v2/weimao/index.html?disableCache=true&shopId=shop000201506058853#mad/shop000201506058853/39","sharePic":"http://fdfs.xmcdn.com/group9/M07/1C/A6/wKgDZlV3rfqDOg0lAAAVB1veXSo522.png","enableShare":true,"isExternalUrl":true,"contentUpdatedAt":1436751267000},{"id":4,"orderNum":4,"title":"酷音铃声","subtitle":"千万条精品铃声快来下载吧","coverPath":"http://fdfs.xmcdn.com/group9/M07/1C/8D/wKgDYlV3rfvCtVcOAAAVglTbKTU541.png","contentType":"html5.audio","url":"http://m.diyring.cc/friend/d450780628b741f1","sharePic":"http://fdfs.xmcdn.com/group15/M00/1C/B5/wKgDZVV3ri7wl9faAAAVglTbKTU535.png","enableShare":true,"isExternalUrl":true,"contentUpdatedAt":0}]
     * locationInHotRecommend : 0
     */
    private int locationInHotRecommend;
    private List<DiscoveryColumn> list;


    public void setLocationInHotRecommend(int locationInHotRecommend) {
        this.locationInHotRecommend = locationInHotRecommend;
    }

    public void setList(List<DiscoveryColumn> list) {
        this.list = list;
    }


    public int getLocationInHotRecommend() {
        return locationInHotRecommend;
    }

    public List<DiscoveryColumn> getList() {
        return list;
    }


    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            super.parseJson(jsonObject);
            locationInHotRecommend  =jsonObject.getInt("locationInHotRecommend");
            JSONArray array = jsonObject.getJSONArray("list");
            list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                DiscoveryColumn discoveryColumn=new DiscoveryColumn();
                discoveryColumn.parseJson(array.getJSONObject(i));
                list.add(discoveryColumn);
            }
        }
    }

    public static class DiscoveryColumn {
        /**
         * id : 1
         * orderNum : 2
         * title : 听友圈子
         * subtitle : 玩个游戏呗 格式：回答楼上问题+想问楼下问题
         * coverPath : http://fdfs.xmcdn.com/group9/M07/1C/8C/wKgDYlV3rd2zGc9PAAAgRAu1VLU052.png
         * contentType : xzone
         * url :
         * sharePic :
         * enableShare : false
         * contentUpdatedAt : 0
         */

        private int id;
        private int orderNum;
        private String title;
        private String subtitle;
        private String coverPath;
        private String contentType;
        private String url;
        private String sharePic;
        private boolean enableShare;
        private int contentUpdatedAt;

        public void setId(int id) {
            this.id = id;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setCoverPath(String coverPath) {
            this.coverPath = coverPath;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setSharePic(String sharePic) {
            this.sharePic = sharePic;
        }

        public void setEnableShare(boolean enableShare) {
            this.enableShare = enableShare;
        }

        public void setContentUpdatedAt(int contentUpdatedAt) {
            this.contentUpdatedAt = contentUpdatedAt;
        }

        public int getId() {
            return id;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getCoverPath() {
            return coverPath;
        }

        public String getContentType() {
            return contentType;
        }

        public String getUrl() {
            return url;
        }

        public String getSharePic() {
            return sharePic;
        }

        public boolean getEnableShare() {
            return enableShare;
        }

        public int getContentUpdatedAt() {
            return contentUpdatedAt;
        }

        public void parseJson(JSONObject jsonObject) throws JSONException {
            if (jsonObject != null) {
                id = jsonObject.getInt("id");
                orderNum = jsonObject.getInt("orderNum");
                title = jsonObject.getString("title");
                subtitle = jsonObject.getString("subtitle");
                coverPath = jsonObject.getString("coverPath");
                contentType = jsonObject.getString("contentType");
                url = jsonObject.getString("url");
                sharePic = jsonObject.getString("sharePic");
                enableShare = jsonObject.getBoolean("enableShare");
                contentUpdatedAt = jsonObject.getInt("contentUpdatedAt");
            }
        }
    }
}
