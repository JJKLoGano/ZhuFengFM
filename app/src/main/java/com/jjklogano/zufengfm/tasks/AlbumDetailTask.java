package com.jjklogano.zufengfm.tasks;

import android.os.Bundle;
import com.jjklogano.zufengfm.Constants;
import com.jjklogano.zufengfm.client.ClientAPI;
import com.jjklogano.zufengfm.utils.ParseUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/23<br/>
 */
public class AlbumDetailTask extends BaseTask {
    private Bundle attrs;

    public AlbumDetailTask(TaskCallBack callBack, Bundle attrs) {
        super(callBack);
        this.attrs = attrs;
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult ret = new TaskResult();
        long albumId = attrs.getLong("albumId");
        long trackId = attrs.getLong("trackId");
        int pageNum = attrs.getInt("pageNum");

        JSONObject categories = ClientAPI.getAlbumDetails(albumId,trackId,pageNum);

        ret.action = Constants.TASK_ACTION_ALBUM_DETAIL;

        if (categories != null) {
            try {
                ret.ret = categories.getInt("ret");
                ret.data = ParseUtils.parseAlbumDetail(categories);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

}
