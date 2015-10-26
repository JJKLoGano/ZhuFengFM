package com.jjklogano.zufengfm.bean;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/24<br/>
 */
public class Advs {

    /**
     * link : http://ad.ximalaya.com/adrecord?sdn=H4sIAAAAAAAAAKtWykhNTEktUrLKK83J0VFKzs_PzkyF8QoSixJzU0tSi4qVrKqVElM8S1JzPVOUrJQMDcwMLZVqawHA2UsKPwAAAA&ad=10619&jt=http%3A%2F%2Fallnewtucson.beijing-hyundai.com.cn%2F%3Fzhuge_referrer%3Dximalaya
     * cover : http://fdfs.xmcdn.com/group16/M09/8A/E6/wKgDalYp2Mzxe3J4AAC-TExE_b0602.jpg
     * name :
     * description :
     * scheme :
     * linkType : 1
     * displayType : 1
     * clickType : 1
     * openlinkType : 0
     * loadingShowTime : 3000
     * thirdStatUrl : null
     * adtype : 0
     * startAt : 1445616000000
     * endAt : 1445702399000
     * adid : 10619
     */

    private String link;
    private String cover;
    private String name;
    private String description;
    private String scheme;
    private int linkType;
    private int displayType;
    private int clickType;
    private int openlinkType;
    private int loadingShowTime;
    private Object thirdStatUrl;
    private int adtype;
    private long startAt;
    private long endAt;
    private int adid;

    public void setLink(String link) {
        this.link = link;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setLinkType(int linkType) {
        this.linkType = linkType;
    }

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }

    public void setClickType(int clickType) {
        this.clickType = clickType;
    }

    public void setOpenlinkType(int openlinkType) {
        this.openlinkType = openlinkType;
    }

    public void setLoadingShowTime(int loadingShowTime) {
        this.loadingShowTime = loadingShowTime;
    }

    public void setThirdStatUrl(Object thirdStatUrl) {
        this.thirdStatUrl = thirdStatUrl;
    }

    public void setAdtype(int adtype) {
        this.adtype = adtype;
    }

    public void setStartAt(long startAt) {
        this.startAt = startAt;
    }

    public void setEndAt(long endAt) {
        this.endAt = endAt;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    public String getLink() {
        return link;
    }

    public String getCover() {
        return cover;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getScheme() {
        return scheme;
    }

    public int getLinkType() {
        return linkType;
    }

    public int getDisplayType() {
        return displayType;
    }

    public int getClickType() {
        return clickType;
    }

    public int getOpenlinkType() {
        return openlinkType;
    }

    public int getLoadingShowTime() {
        return loadingShowTime;
    }

    public Object getThirdStatUrl() {
        return thirdStatUrl;
    }

    public int getAdtype() {
        return adtype;
    }

    public long getStartAt() {
        return startAt;
    }

    public long getEndAt() {
        return endAt;
    }

    public int getAdid() {
        return adid;
    }
    /**
     * link : http://ad.ximalaya.com/adrecord?sdn=H4sIAAAAAAAAAKtWykhNTEktUrLKK83J0VFKzs_PzkyF8QoSixJzU0tSi4qVrKqVElM8S1JzPVOUrJQMDcwMLZVqawHA2UsKPwAAAA&ad=10619&jt=http%3A%2F%2Fallnewtucson.beijing-hyundai.com.cn%2F%3Fzhuge_referrer%3Dximalaya
     * cover : http://fdfs.xmcdn.com/group16/M09/8A/E6/wKgDalYp2Mzxe3J4AAC-TExE_b0602.jpg
     * name :
     * description :
     * scheme :
     * linkType : 1
     * displayType : 1
     * clickType : 1
     * openlinkType : 0
     * loadingShowTime : 3000
     * thirdStatUrl : null
     * adtype : 0
     * startAt : 1445616000000
     * endAt : 1445702399000
     * adid : 10619
     */
    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            JSONArray array = jsonObject.getJSONArray("data");
            int index = (int)(Math.random()*array.length());

            Log.d("index",index+""+array.length());
            JSONObject object = array.getJSONObject(index);

            link = object.getString("link");
            cover = object.getString("cover");
            name = object.optString("name");
            description = object.optString("description");
            scheme = object.optString("scheme");
            linkType = object.optInt("linkType");
            displayType = object.optInt("displayType");
            clickType = object.optInt("clickType");
            openlinkType = object.optInt("openlinkType");
            loadingShowTime = object.optInt("loadingShowTime");
            thirdStatUrl = object.optString("thirdStatUrl");
            adtype = object.optInt("adtype");
            startAt = object.getLong("startAt");
            endAt = object.getLong("endAt");
            adid = object.getInt("adid");
        }
    }

}
