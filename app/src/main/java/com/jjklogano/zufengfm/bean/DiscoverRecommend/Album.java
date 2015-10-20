package com.jjklogano.zufengfm.bean.DiscoverRecommend;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class Album {

    /**
     * albumId : 2991922
     * coverLarge : http://fdfs.xmcdn.com/group12/M09/75/F1/wKgDXFYCabDifAXPAAMVnFG1EIM871_mobile_large.jpg
     * title : 乌盆记（想不到的推理结局）
     * tags : 畅销书,悬疑,恐怖
     * tracks : 33
     * playsCounts : 711070
     * isFinished : 2
     * serialState : 2
     * trackId : 8939178
     * trackTitle : 乌盆记:史上最恐怖的小说
     */

    private int albumId;
    private String coverLarge;
    private String title;
    private String tags;
    private int tracks;
    private int playsCounts;
    private int isFinished;
    private int serialState;
    private int trackId;
    private String trackTitle;

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public void setPlaysCounts(int playsCounts) {
        this.playsCounts = playsCounts;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public void setSerialState(int serialState) {
        this.serialState = serialState;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public String getTitle() {
        return title;
    }

    public String getTags() {
        return tags;
    }

    public int getTracks() {
        return tracks;
    }

    public int getPlaysCounts() {
        return playsCounts;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public int getSerialState() {
        return serialState;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            albumId = jsonObject.getInt("albumId");
            coverLarge = jsonObject.getString("coverLarge");
            title = jsonObject.getString("title");
            tags = jsonObject.getString("tags");
            tracks = jsonObject.getInt("tracks");
            playsCounts = jsonObject.getInt("playsCounts");
            isFinished = jsonObject.getInt("isFinished");
            serialState = jsonObject.getInt("serialState");
            trackId = jsonObject.getInt("trackId");
            trackTitle = jsonObject.getString("trackTitle");
        }
    }
}
