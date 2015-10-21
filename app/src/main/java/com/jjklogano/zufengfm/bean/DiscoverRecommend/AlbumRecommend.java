package com.jjklogano.zufengfm.bean.discoverRecommend;

import com.jjklogano.zufengfm.bean.AlbumBasic;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */

/**
 * 专辑推荐单项，被小编推荐、热门推荐中的子项使用
 */
public class AlbumRecommend extends AlbumBasic{

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

    private long playsCounts;
    private int isFinished;
    private int serialState;
    private long trackId;
    private String trackTitle;

    public void setPlaysCounts(long playsCounts) {
        this.playsCounts = playsCounts;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public void setSerialState(int serialState) {
        this.serialState = serialState;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }


    public long getPlaysCounts() {
        return playsCounts;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public int getSerialState() {
        return serialState;
    }

    public long getTrackId() {
        return trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            super.parseJson(jsonObject);
            playsCounts = jsonObject.optLong("playsCounts", 0);
            isFinished = jsonObject.optInt("isFinished", 0);
            serialState = jsonObject.optInt("serialState", 0);
            trackId = jsonObject.getLong("trackId");
            trackTitle = jsonObject.getString("trackTitle");
        }
    }
}
