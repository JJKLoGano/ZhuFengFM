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
public class HotRecommends extends DiscoverRecommendItem{

    private List<RecommendAlbums> list;


    public void setList(List<RecommendAlbums> list) {
        this.list = list;
    }


    public List<RecommendAlbums> getList() {
        return list;
    }

    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            super.parseJson(jsonObject);
            list=new ArrayList<>();
            JSONArray array = jsonObject.getJSONArray("list");
            for (int i = 0; i < array.length(); i++) {
                RecommendAlbums recommends = new RecommendAlbums();
                recommends.parseJson(array.getJSONObject(i));
                list.add(recommends);
            }
        }
    }


//    public static class Recommends extends DiscoverRecommendItem{
//
//        private String title;
//        private String contentType;
//        private boolean isFinished;
//        private int categoryId;
//        private int count;
//        private boolean hasMore;
//        private List<AlbumRecommend> list;
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public void setContentType(String contentType) {
//            this.contentType = contentType;
//        }
//
//        public void setIsFinished(boolean isFinished) {
//            this.isFinished = isFinished;
//        }
//
//        public void setCategoryId(int categoryId) {
//            this.categoryId = categoryId;
//        }
//
//        public void setCount(int count) {
//            this.count = count;
//        }
//
//        public void setHasMore(boolean hasMore) {
//            this.hasMore = hasMore;
//        }
//
//        public void setList(List<AlbumRecommend> list) {
//            this.list = list;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public String getContentType() {
//            return contentType;
//        }
//
//        public boolean getIsFinished() {
//            return isFinished;
//        }
//
//        public int getCategoryId() {
//            return categoryId;
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public boolean getHasMore() {
//            return hasMore;
//        }
//
//        public List<AlbumRecommend> getList() {
//            return list;
//        }
//
//        public void parseJson(JSONObject jsonObject) throws JSONException {
//            if (jsonObject != null) {
//                title = jsonObject.getString("title");
//                contentType = jsonObject.getString("contentType");
//                isFinished = jsonObject.getBoolean("isFinished");
//                categoryId = jsonObject.getInt("categoryId");
//                count = jsonObject.getInt("count");
//                hasMore=  jsonObject.getBoolean("hasMore");
//                list=  new ArrayList<>();
//                JSONArray array = jsonObject.getJSONArray("list");
//                for (int i = 0; i < array.length(); i++) {
//                    AlbumRecommend albumRecommend =new AlbumRecommend();
//                    albumRecommend.parseJson(array.getJSONObject(i));
//                    list.add(albumRecommend);
//                }
//            }
//        }
//    }
}