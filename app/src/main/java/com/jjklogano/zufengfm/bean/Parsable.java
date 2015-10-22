package com.jjklogano.zufengfm.bean;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/22<br/>
 */

import org.json.JSONException;
import org.json.JSONObject;


public interface Parsable {

    /**
     * 描述可通过JSON\XML\CURSOR 解析的实体类接口
     */
    void parseJson(JSONObject jsonObject) throws JSONException;
}
