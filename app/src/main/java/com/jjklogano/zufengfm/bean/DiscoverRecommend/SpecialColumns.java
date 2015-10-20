package com.jjklogano.zufengfm.bean.DiscoverRecommend;

import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/20<br/>
 */
public class SpecialColumns {

    /**
     * ret : 0
     * title : 精品听单
     * hasMore : true
     * list : [{"columnType":1,"specialId":341,"title":"10首一听就沦陷的翻唱歌曲","subtitle":"不是每","footnote":"10首声音","coverPath":"http","contentType":"2"},{"columnType":1,"specialId":407,"title":"6大魔幻小说遇上传统评书","subtitle":"当","footnote":"6首声音","coverPath":"http","contentType":"2"}]
     */

    private int ret;
    private String title;
    private boolean hasMore;
    private List<SpecialColumn> list;

    public void setRet(int ret) {
        this.ret = ret;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public void setList(List<SpecialColumn> list) {
        this.list = list;
    }

    public int getRet() {
        return ret;
    }

    public String getTitle() {
        return title;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public List<SpecialColumn> getList() {
        return list;
    }

    public static class SpecialColumn {
        /**
         * columnType : 1
         * specialId : 341
         * title : 10首一听就沦陷的翻唱歌曲
         * subtitle : 不是每
         * footnote : 10首声音
         * coverPath : http
         * contentType : 2
         */

        private int columnType;
        private int specialId;
        private String title;
        private String subtitle;
        private String footnote;
        private String coverPath;
        private String contentType;

        public void setColumnType(int columnType) {
            this.columnType = columnType;
        }

        public void setSpecialId(int specialId) {
            this.specialId = specialId;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setFootnote(String footnote) {
            this.footnote = footnote;
        }

        public void setCoverPath(String coverPath) {
            this.coverPath = coverPath;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public int getColumnType() {
            return columnType;
        }

        public int getSpecialId() {
            return specialId;
        }

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getFootnote() {
            return footnote;
        }

        public String getCoverPath() {
            return coverPath;
        }

        public String getContentType() {
            return contentType;
        }
    }
}
