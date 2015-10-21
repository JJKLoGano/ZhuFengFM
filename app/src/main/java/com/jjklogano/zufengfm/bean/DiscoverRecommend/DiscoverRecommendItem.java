package com.jjklogano.zufengfm.bean.discoverRecommend;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/21<br/>
 */
public class DiscoverRecommendItem {
    private String title;
    private int ret;
    private boolean hasMore;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public void parseJson(JSONObject jsonObject) throws JSONException {
        title = jsonObject.getString("title");
        ret = jsonObject.optInt("ret");
        hasMore = jsonObject.optBoolean("hasMore");
    }
}
