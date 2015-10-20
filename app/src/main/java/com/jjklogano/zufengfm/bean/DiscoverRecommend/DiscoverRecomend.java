package com.jjklogano.zufengfm.bean.DiscoverRecommend;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class DiscoverRecomend {

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


}
