package com.teach.android.educationonline.ui.entity;

import java.io.Serializable;
import java.util.List;

/**
 * File description.
 *
 * @author 作者:lyc
 * @date 2017/12/21 0021
 */


public class BannerModel implements Serializable{

    /**
     * total : 1
     * course : null
     * status : 1
     * column : [{"buy_notice":"æ\u0099\u0092u","column_details":"ç½\u0091å\u0090§","column_id":"c7ada78af60b4471a73e","column_intro":"æ\u0098¯æ\u009b´å¤\u009a","column_price":"100.0","column_title":"123456","column_url":"sa45aw5s21a5w","course_id":"","crowd":"12å²\u0081","currentpage":0,"pagesize":0,"take_num":0,"ts":"2017-11-22 09:42:07","update_num":0,"user_id":10007},{"buy_notice":"æ\u0099\u0092u","column_details":"ç½\u0091å\u0090§","column_id":"d0ba831a677e4fb6825a","column_intro":"æ\u0098¯æ\u009b´å¤\u009a","column_price":"100.0","column_title":"é\u0098¿æ\u0096¯å\u0093\u0088","column_url":"sa45aw5s21a5w","course_id":"","crowd":"12å²\u0081","currentpage":0,"pagesize":0,"take_num":0,"ts":"2017-11-22 09:55:46","update_num":0,"user_id":10007}]
     * records : 2
     */

    private int total;
    private Object course;
    private int status;
    private int records;
    private List<ColumnBean> column;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getCourse() {
        return course;
    }

    public void setCourse(Object course) {
        this.course = course;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public List<ColumnBean> getColumn() {
        return column;
    }

    public void setColumn(List<ColumnBean> column) {
        this.column = column;
    }

    public static class ColumnBean {
        /**
         * buy_notice : æu
         * column_details : ç½å§
         * column_id : c7ada78af60b4471a73e
         * column_intro : æ¯æ´å¤
         * column_price : 100.0
         * column_title : 123456
         * column_url : sa45aw5s21a5w
         * course_id :
         * crowd : 12å²
         * currentpage : 0
         * pagesize : 0
         * take_num : 0
         * ts : 2017-11-22 09:42:07
         * update_num : 0
         * user_id : 10007
         */

        private String buy_notice;
        private String column_details;
        private String column_id;
        private String column_intro;
        private String column_price;
        private String column_title;
        private String column_url;
        private String course_id;
        private String crowd;
        private int currentpage;
        private int pagesize;
        private int take_num;
        private String ts;
        private int update_num;
        private int user_id;

        public String getBuy_notice() {
            return buy_notice;
        }

        public void setBuy_notice(String buy_notice) {
            this.buy_notice = buy_notice;
        }

        public String getColumn_details() {
            return column_details;
        }

        public void setColumn_details(String column_details) {
            this.column_details = column_details;
        }

        public String getColumn_id() {
            return column_id;
        }

        public void setColumn_id(String column_id) {
            this.column_id = column_id;
        }

        public String getColumn_intro() {
            return column_intro;
        }

        public void setColumn_intro(String column_intro) {
            this.column_intro = column_intro;
        }

        public String getColumn_price() {
            return column_price;
        }

        public void setColumn_price(String column_price) {
            this.column_price = column_price;
        }

        public String getColumn_title() {
            return column_title;
        }

        public void setColumn_title(String column_title) {
            this.column_title = column_title;
        }

        public String getColumn_url() {
            return column_url;
        }

        public void setColumn_url(String column_url) {
            this.column_url = column_url;
        }

        public String getCourse_id() {
            return course_id;
        }

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public String getCrowd() {
            return crowd;
        }

        public void setCrowd(String crowd) {
            this.crowd = crowd;
        }

        public int getCurrentpage() {
            return currentpage;
        }

        public void setCurrentpage(int currentpage) {
            this.currentpage = currentpage;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getTake_num() {
            return take_num;
        }

        public void setTake_num(int take_num) {
            this.take_num = take_num;
        }

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }

        public int getUpdate_num() {
            return update_num;
        }

        public void setUpdate_num(int update_num) {
            this.update_num = update_num;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
    }
}