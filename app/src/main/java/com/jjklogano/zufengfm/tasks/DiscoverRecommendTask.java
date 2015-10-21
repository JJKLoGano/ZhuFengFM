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
public class DiscoverRecommendTask extends BaseTask {

    public DiscoverRecommendTask(TaskCallBack callBack) {
        super(callBack);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret=new TaskResult();
        JSONObject recommend = ClientAPI.getDiscoverRecommends("and-f6",true,true);

        ret.action= Constants.TASK_ACTION_DISCOVER_RECOMMNEND;

        if(recommend!=null){
            try {
                ret.ret=recommend.getInt("ret");
                ret.data = ParseUtils.parseDiscoverRecommend(recommend);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
