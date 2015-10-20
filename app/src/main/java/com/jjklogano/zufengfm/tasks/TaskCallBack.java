package com.jjklogano.zufengfm.tasks;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */

/**
 * 异步任务回调接口
 * @see TaskResult
 */
public interface TaskCallBack {
    /**
     * 当异步任务执行完成时会回调这个方法，将结果传递给相应实现类
     * @param result 返回结果
     */
    void onTaskFinished(TaskResult result);

}
