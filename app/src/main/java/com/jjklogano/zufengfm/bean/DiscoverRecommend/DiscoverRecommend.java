package com.jjklogano.zufengfm.bean.discoverRecommend;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class DiscoverRecommend {

    public Entrances entrances;
    public DiscoveryColumns discoveryColumns;
    public RecommendAlbums editorRecommendAlbums;
    public HotRecommends hotRecommends;
    public FocusImages focusImages;
    public SpecialColumns specialColumn;

    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            entrances = new Entrances();
            discoveryColumns = new DiscoveryColumns();
            editorRecommendAlbums = new RecommendAlbums();
            hotRecommends = new HotRecommends();
            focusImages = new FocusImages();
            specialColumn = new SpecialColumns();

            entrances.parseJson(jsonObject.getJSONObject("entrances"));
            discoveryColumns.parseJson(jsonObject.getJSONObject("discoveryColumns"));
            editorRecommendAlbums.parseJson(jsonObject.getJSONObject("editorRecommendAlbums"));
            hotRecommends.parseJson(jsonObject.getJSONObject("hotRecommends"));
            focusImages.parseJson(jsonObject.getJSONObject("focusImages"));
            specialColumn.parseJson(jsonObject.getJSONObject("specialColumn"));
        }
    }

    public List<DiscoverRecommendItem> getItemList(){
        List<DiscoverRecommendItem> items= new ArrayList<>();
        items.add(editorRecommendAlbums);
        items.add(specialColumn);
        items.add(discoveryColumns);
        items.addAll(hotRecommends.getList());
        return items;
    }

    @Override
    public String toString() {
        return "DiscoverRecommend{" +
                "entrances=" + entrances +
                ", discoveryColumns=" + discoveryColumns +
                ", editorRecommendAlbums=" + editorRecommendAlbums +
                ", hotRecommends=" + hotRecommends +
                ", focusImages=" + focusImages +
                ", specialColumn=" + specialColumn +
                '}';
    }


    public List<String> getImageList() {
        List<String> images = new ArrayList<>();
        focusImages.getList();
        for (FocusImages.FocusImage focusImage : focusImages.getList()) {
            images.add(focusImage.getPic());
        }
        return null;
    }
}
