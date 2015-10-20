package com.jjklogano.zufengfm.bean.DiscoverRecommend;

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
public class RecommendAlbums {


    /**
     * ret : 0
     * title : 小编推荐
     * hasMore : true
     * list : [{"albumId":3005249,"coverLarge":"http://fdfs.xmcdn.com/group16/M01/7A/D3/wKgDbFYKqqHCamtQAAIv621_oBE247_mobile_large.jpg","title":"3D环绕音乐","tags":"翻唱|原创,文艺|小众,清新|催眠","tracks":75,"playsCounts":139888,"isFinished":0,"serialState":0,"trackId":9333769,"trackTitle":"3D:睡不着就听听星夜的声音"},{"albumId":222885,"coverLarge":"http://fdfs.xmcdn.com/group6/M0A/B1/66/wKgDg1UMAumSUUUXAAUK_-QFgJ0834_mobile_large.jpg","title":"非常不着调","tags":"笑话,脱口秀,流行","tracks":198,"playsCounts":37090695,"isFinished":0,"serialState":0,"trackId":9312053,"trackTitle":"每次看选秀节目,都能有故事听"},{"albumId":2991922,"coverLarge":"http://fdfs.xmcdn.com/group12/M09/75/F1/wKgDXFYCabDifAXPAAMVnFG1EIM871_mobile_large.jpg","title":"乌盆记（想不到的推理结局）","tags":"畅销书,悬疑,恐怖","tracks":33,"playsCounts":711070,"isFinished":2,"serialState":2,"trackId":8939178,"trackTitle":"乌盆记:史上最恐怖的小说"}]
     */

    private int ret;
    private String title;
    private boolean hasMore;
    private List<Album> list;

    public void setRet(int ret) {
        this.ret = ret;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public void setList(List<Album> list) {
        this.list = list;
    }

    public int getRet() {
        return ret;
    }

    public String getTitle() {
        return title;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public List<Album> getList() {
        return list;
    }

    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            ret = jsonObject.getInt("ret");
            title = jsonObject.getString("title");
            hasMore = jsonObject.getBoolean("hasMore");
            list = new ArrayList<>();
            JSONArray array = jsonObject.getJSONArray("list");
            for (int i = 0; i < array.length(); i++) {
                Album album=new Album();
                album.parseJson(array.getJSONObject(i));
                list.add(album);
            }
        }
    }

}
