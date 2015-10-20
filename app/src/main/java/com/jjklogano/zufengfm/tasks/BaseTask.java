package com.jjklogano.zufengfm.tasks;

import android.os.AsyncTask;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public abstract class BaseTask extends AsyncTask<String,Void,TaskResult> {
    private TaskCallBack callBack;

    public BaseTask(TaskCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected void onPostExecute(TaskResult result) {
        if(callBack!=null){
            callBack.onTaskFinished(result);
        }
    }
}
