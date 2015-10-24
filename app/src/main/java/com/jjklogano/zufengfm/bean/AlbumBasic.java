package com.jjklogano.zufengfm.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/21<br/>
 */
public class AlbumBasic {
    private long albumId;
    private String coverLarge;
    private String title;
    private String tags;

    private int tracks;//曲目数

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            albumId = jsonObject.getLong("albumId");
            coverLarge = jsonObject.getString("coverLarge");
            title = jsonObject.getString("title");
            tags = jsonObject.getString("tags");
            tracks = jsonObject.getInt("tracks");
        }
    }

}
