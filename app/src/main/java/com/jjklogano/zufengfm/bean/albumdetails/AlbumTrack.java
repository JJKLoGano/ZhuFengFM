package com.jjklogano.zufengfm.bean.albumdetails;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/23<br/>
 */
public class AlbumTrack {

    /**
     * trackId : 9387933
     * uid : 1000596
     * playUrl64 : http://fdfs.xmcdn.com/group7/M05/89/36/wKgDX1YmU5_CdQbSAN_aTJ17d1o811.mp3
     * playUrl32 : http://fdfs.xmcdn.com/group7/M05/89/36/wKgDX1YmU5axWxIMAG_tPcqEgys840.mp3
     * downloadUrl : http://download.xmcdn.com/group7/M05/89/2A/wKgDWlYmU4ORO19xAHQka4ZoEFY825.aac
     * playPathAacv164 : http://audio.xmcdn.com/group7/M05/89/2B/wKgDWlYmU5aSUFm3AOJKMRNCOOQ212.m4a
     * playPathAacv224 : http://audio.xmcdn.com/group7/M05/89/2B/wKgDWlYmU4yRBD0qAFZf8EJZxvM062.m4a
     * downloadAacUrl : http://audio.xmcdn.com/group7/M05/89/2B/wKgDWlYmU4yRBD0qAFZf8EJZxvM062.m4a
     * title : 糗事播报之重阳席上赋白菊，周二播报颇有趣——采采（2015.10.20）
     * duration : 1833
     * processState : 2
     * createdAt : 1445352330000
     * coverSmall : http://fdfs.xmcdn.com/group15/M05/88/A2/wKgDZVYmTaPD_fNBAAFtApzbD-s098_web_meduim.jpg
     * coverMiddle : http://fdfs.xmcdn.com/group15/M05/88/A2/wKgDZVYmTaPD_fNBAAFtApzbD-s098_web_large.jpg
     * coverLarge : http://fdfs.xmcdn.com/group15/M05/88/A2/wKgDZVYmTaPD_fNBAAFtApzbD-s098_mobile_large.jpg
     * nickname : 糗事播报
     * smallLogo : http://fdfs.xmcdn.com/group5/M05/90/97/wKgDtlRsQJmxnPW6AABmeagRyv0922_mobile_small.png
     * userSource : 1
     * albumId : 203355
     * albumTitle : 段子来了
     * albumImage : http://fdfs.xmcdn.com/group5/M03/A6/D8/wKgDtlR1MD_T1DQHAANqZDyk48s720_mobile_small.jpg
     * orderNum : 99999999
     * opType : 2
     * refUid : 2629577
     * refNickname : 枕边疯电台
     * refSmallLogo : http://fdfs.xmcdn.com/group3/M00/64/F8/wKgDslJ68TnQpnVPAAU-A1zGGqI128_mobile_small.jpg
     * isPublic : true
     * likes : 3374
     * playtimes : 289017
     * comments : 1138
     * shares : 0
     * status : 1
     * downloadSize : 7611499
     * downloadAacSize : 5660656
     */

    private int trackId;
    private int uid;
    private String playUrl64;
    private String playUrl32;
    private String downloadUrl;
    private String playPathAacv164;
    private String playPathAacv224;
    private String downloadAacUrl;
    private String title;
    private int duration;
    private int processState;
    private long createdAt;
    private String coverSmall;
    private String coverMiddle;
    private String coverLarge;
    private String nickname;
    private String smallLogo;
    private int userSource;
    private int albumId;
    private String albumTitle;
    private String albumImage;
    private int orderNum;
    private int opType;
    private int refUid;
    private String refNickname;
    private String refSmallLogo;
    private boolean isPublic;
    private int likes;
    private int playtimes;
    private int comments;
    private int shares;
    private int status;
    private int downloadSize;
    private int downloadAacSize;

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setPlayUrl64(String playUrl64) {
        this.playUrl64 = playUrl64;
    }

    public void setPlayUrl32(String playUrl32) {
        this.playUrl32 = playUrl32;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setPlayPathAacv164(String playPathAacv164) {
        this.playPathAacv164 = playPathAacv164;
    }

    public void setPlayPathAacv224(String playPathAacv224) {
        this.playPathAacv224 = playPathAacv224;
    }

    public void setDownloadAacUrl(String downloadAacUrl) {
        this.downloadAacUrl = downloadAacUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setProcessState(int processState) {
        this.processState = processState;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public void setCoverMiddle(String coverMiddle) {
        this.coverMiddle = coverMiddle;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSmallLogo(String smallLogo) {
        this.smallLogo = smallLogo;
    }

    public void setUserSource(int userSource) {
        this.userSource = userSource;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public void setRefUid(int refUid) {
        this.refUid = refUid;
    }

    public void setRefNickname(String refNickname) {
        this.refNickname = refNickname;
    }

    public void setRefSmallLogo(String refSmallLogo) {
        this.refSmallLogo = refSmallLogo;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setPlaytimes(int playtimes) {
        this.playtimes = playtimes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDownloadSize(int downloadSize) {
        this.downloadSize = downloadSize;
    }

    public void setDownloadAacSize(int downloadAacSize) {
        this.downloadAacSize = downloadAacSize;
    }

    public int getTrackId() {
        return trackId;
    }

    public int getUid() {
        return uid;
    }

    public String getPlayUrl64() {
        return playUrl64;
    }

    public String getPlayUrl32() {
        return playUrl32;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getPlayPathAacv164() {
        return playPathAacv164;
    }

    public String getPlayPathAacv224() {
        return playPathAacv224;
    }

    public String getDownloadAacUrl() {
        return downloadAacUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getProcessState() {
        return processState;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public String getCoverMiddle() {
        return coverMiddle;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSmallLogo() {
        return smallLogo;
    }

    public int getUserSource() {
        return userSource;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public int getOpType() {
        return opType;
    }

    public int getRefUid() {
        return refUid;
    }

    public String getRefNickname() {
        return refNickname;
    }

    public String getRefSmallLogo() {
        return refSmallLogo;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public int getLikes() {
        return likes;
    }

    public int getPlaytimes() {
        return playtimes;
    }

    public int getComments() {
        return comments;
    }

    public int getShares() {
        return shares;
    }

    public int getStatus() {
        return status;
    }

    public int getDownloadSize() {
        return downloadSize;
    }

    public int getDownloadAacSize() {
        return downloadAacSize;
    }
    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            trackId = jsonObject.getInt("trackId");
            uid = jsonObject.getInt("uid");
            playUrl32 = jsonObject.getString("playUrl32");
            playUrl64 = jsonObject.getString("playUrl64");
            downloadUrl = jsonObject.getString("downloadUrl");
            playPathAacv164 = jsonObject.getString("playPathAacv164");
            playPathAacv224 = jsonObject.getString("playPathAacv224");
            downloadAacUrl = jsonObject.getString("downloadAacUrl");
            title = jsonObject.getString("title");
            duration = jsonObject.getInt("duration");
            processState = jsonObject.getInt("processState");
            createdAt = jsonObject.getInt("createdAt");
            coverSmall = jsonObject.getString("coverSmall");
            coverMiddle = jsonObject.getString("coverMiddle");
            coverLarge = jsonObject.getString("coverLarge");
            nickname = jsonObject.getString("nickname");
            smallLogo = jsonObject.getString("smallLogo");
            userSource = jsonObject.getInt("userSource");
            albumId = jsonObject.getInt("albumId");
            albumTitle = jsonObject.getString("albumTitle");
            albumImage = jsonObject.getString("albumImage");
            orderNum = jsonObject.getInt("orderNum");
            opType = jsonObject.getInt("opType");
            refUid = jsonObject.optInt("refUid");
            refNickname = jsonObject.optString("refNickname");
            refSmallLogo = jsonObject.optString("refSmallLogo");
            isPublic = jsonObject.getBoolean("isPublic");
            likes = jsonObject.getInt("likes");
            playtimes = jsonObject.getInt("playtimes");
            comments = jsonObject.getInt("comments");
            shares = jsonObject.getInt("shares");
            status = jsonObject.getInt("status");
            downloadSize = jsonObject.getInt("downloadSize");
            downloadAacSize = jsonObject.getInt("downloadAacSize");
        }
    }
}
