package com.jjklogano.zufengfm.bean;

import java.util.List;

/**
 *
 * 首页分类实体类
 *
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/19<br/>
 */
public class Category {

    /**
     * id : 0
     * name : all
     * title : 热门
     * intro : null
     * is_display : true
     * cover_path : http://s1.xmcdn.com/css/img/common/category/hot.png
     * tag_list : ["治愈系","排行榜","英语","相声","新歌","老歌","访谈","脱口秀","鬼故事","评书","公开课","理财","国学","童话","声音日记","随手录","星座"]
     */

    private int id;
    private String name;
    private String title;
    private Object intro;
    private boolean is_display;
    private String cover_path;
    private List<String> tag_list;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIntro(Object intro) {
        this.intro = intro;
    }

    public void setIs_display(boolean is_display) {
        this.is_display = is_display;
    }

    public void setCover_path(String cover_path) {
        this.cover_path = cover_path;
    }

    public void setTag_list(List<String> tag_list) {
        this.tag_list = tag_list;
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

    public Object getIntro() {
        return intro;
    }

    public boolean getIs_display() {
        return is_display;
    }

    public String getCover_path() {
        return cover_path;
    }

    public List<String> getTag_list() {
        return tag_list;
    }
}
