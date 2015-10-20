package com.jjklogano.zufengfm.tasks;

/**
 * Created<br/>
 * 异步任务回调接口定义数据
 * action代表数据归属
 * data代表数据，任意类型
 * ret 代表请求结果码
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class TaskResult {
    public int ret = -1;//0为成功
    public int action;
    public Object data;

}
