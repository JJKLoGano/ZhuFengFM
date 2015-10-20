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

        }
    }



}
