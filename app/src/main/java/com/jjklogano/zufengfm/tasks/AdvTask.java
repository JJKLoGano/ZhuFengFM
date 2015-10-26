package com.jjklogano.zufengfm.tasks;

import com.jjklogano.zufengfm.Constants;
import com.jjklogano.zufengfm.client.ClientAPI;
import com.jjklogano.zufengfm.utils.ParseUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/24<br/>
 */
public class AdvTask extends BaseTask {

    public AdvTask(TaskCallBack callBack) {
        super(callBack);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret=new TaskResult();
        JSONObject splashAdv = ClientAPI.getSplashAdv();

        ret.action= Constants.TASK_ACTION_ADVERTISMENT;

        if(splashAdv!=null){
            try {
                ret.ret=splashAdv.getInt("ret");
                ret.data = ParseUtils.parseSplashAdv(splashAdv);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
