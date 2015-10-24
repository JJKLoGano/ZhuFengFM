package com.jjklogano.zufengfm.bean.albumdetails;

import com.jjklogano.zufengfm.bean.AlbumBasic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/23<br/>
 */
public class AlbumDetail extends AlbumBasic {

    /**
     * categoryId : 4
     * categoryName : 综艺娱乐
     * coverOrigin : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720.jpg
     * coverSmall : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720_mobile_small.jpg
     * coverMiddle : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720_mobile_meduim.jpg
     * coverWebLarge : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720_web_large.jpg
     * createdAt : 1376650745000
     * updatedAt : 1435591762000
     * uid : 2629577
     * nickname : 枕边疯电台
     * isVerified : true
     * avatarPath : http://fdfs.xmcdn.com/group3/M00/64/F8/wKgDslJ68TnQpnVPAAU-A1zGGqI128_mobile_small.jpg
     * intro : 更多请关注微信公众账号： caicaifm
     * introRich : 更多请关注微信公众账号： caicaifm
     * shares : 0
     * hasNew : false
     * isFavorite : false
     * playTimes : 180613694
     * status : 1
     * serializeStatus : 0
     * serialState : 0
     */

    private int categoryId;
    private String categoryName;
    private String coverOrigin;
    private String coverSmall;
    private String coverMiddle;
    private String coverWebLarge;
    private long createdAt;
    private long updatedAt;
    private int uid;
    private String nickname;
    private boolean isVerified;
    private String avatarPath;
    private String intro;
    private String introRich;
    private int shares;
    private boolean hasNew;
    private boolean isFavorite;
    private long playTimes;
    private int status;
    private int serializeStatus;
    private int serialState;
    private List<AlbumTrack> tracks;

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCoverOrigin(String coverOrigin) {
        this.coverOrigin = coverOrigin;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public void setCoverMiddle(String coverMiddle) {
        this.coverMiddle = coverMiddle;
    }

    public void setCoverWebLarge(String coverWebLarge) {
        this.coverWebLarge = coverWebLarge;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setIntroRich(String introRich) {
        this.introRich = introRich;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public void setHasNew(boolean hasNew) {
        this.hasNew = hasNew;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void setPlayTimes(long playTimes) {
        this.playTimes = playTimes;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setSerializeStatus(int serializeStatus) {
        this.serializeStatus = serializeStatus;
    }

    public void setSerialState(int serialState) {
        this.serialState = serialState;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCoverOrigin() {
        return coverOrigin;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public String getCoverMiddle() {
        return coverMiddle;
    }

    public String getCoverWebLarge() {
        return coverWebLarge;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public int getUid() {
        return uid;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public String getIntro() {
        return intro;
    }

    public String getIntroRich() {
        return introRich;
    }

    public int getShares() {
        return shares;
    }

    public boolean isHasNew() {
        return hasNew;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public long getPlayTimes() {
        return playTimes;
    }

    public int getStatus() {
        return status;
    }

    public int getSerializeStatus() {
        return serializeStatus;
    }

    public int getSerialState() {
        return serialState;
    }

    public List<AlbumTrack> getTracks() {
        return tracks;
    }

    public void setTracks(List<AlbumTrack> tracks) {
        this.tracks = tracks;
    }

    /**
    * nickname : 枕边疯电台
    * isVerified : true
            * avatarPath : http://fdfs.xmcdn.com/group3/M00/64/F8/wKgDslJ68TnQpnVPAAU-A1zGGqI128_mobile_small.jpg
            * intro : 更多请关注微信公众账号： caicaifm
    * introRich : 更多请关注微信公众账号： caicaifm
    * shares : 0
            * hasNew : false
            * isFavorite : false
            * playTimes : 180613694
     */
    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            JSONObject album = jsonObject.getJSONObject("album");
            super.parseJson(album);
            nickname = album.getString("nickname");
            intro = album.getString("intro");
            introRich = album.getString("introRich");
            avatarPath = album.getString("avatarPath");
            isFavorite = album.getBoolean("isFavorite");
            playTimes = album.getLong("playTimes");
            JSONArray jsonArray = jsonObject.getJSONObject("tracks").getJSONArray("list");
            tracks = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                AlbumTrack albumTrack=new AlbumTrack();
                albumTrack.parseJson(jsonArray.getJSONObject(i));
                tracks.add(albumTrack);
            }
        }
    }
}
