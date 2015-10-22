package com.jjklogano.zufengfm.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * 首页分类实体类
 *
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/19<br/>
 */
public class DiscoverCategory implements Parsable{


    /**
     * id : 3
     * name : book
     * title : 有声书
     * isChecked : false
     * orderNum : 1
     * coverPath : http://fdfs.xmcdn.com/group8/M07/17/A0/wKgDYFVxM-fQsucFAAAFRHjovdg062.png
     * selectedSwitch : false
     * isFinished : true
     * contentType : album
     */

    private int id;
    private String name;
    private String title;
    private boolean isChecked;
    private int orderNum;
    private String coverPath;
    private boolean selectedSwitch;
    private boolean isFinished;
    private String contentType;

    @Override
    public void parseJson(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            id = jsonObject.getInt("id");
            name = jsonObject.getString("name");
            title = jsonObject.getString("title");
            isChecked = jsonObject.optBoolean("isChecked", false);
            orderNum = jsonObject.getInt("orderNum");//TODO 是否必须？？
            coverPath = jsonObject.optString("coverPath");
            selectedSwitch = jsonObject.optBoolean("selectedSwitch");
            isFinished = jsonObject.optBoolean("selectedSwitch");
            contentType = jsonObject.optString("contentType");

        }
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public void setSelectedSwitch(boolean selectedSwitch) {
        this.selectedSwitch = selectedSwitch;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public boolean getSelectedSwitch() {
        return selectedSwitch;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public String getContentType() {
        return contentType;
    }
}
