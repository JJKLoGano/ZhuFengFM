package com.jjklogano.zufengfm.tasks;

import android.os.AsyncTask;
import com.jjklogano.zufengfm.Constants;
import com.jjklogano.zufengfm.client.ClientAPI;
import com.jjklogano.zufengfm.utils.ParseUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class DiscoverCategoryTask extends BaseTask {

    public DiscoverCategoryTask(TaskCallBack callBack) {
        super(callBack);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret=new TaskResult();
        JSONObject categories = ClientAPI.getDiscoverCategories();

        ret.action= Constants.TASK_ACTION_DISCOVER_CATEGORIES;

        if(categories!=null){
            try {
                ret.ret=categories.getInt("ret");
                ret.data = ParseUtils.parseDiscoverCategories(categories);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
