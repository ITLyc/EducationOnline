package com.teach.android.educationonline.ui.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 作者:Lyc
 *         Created by Administrator on 2017/12/6 0006.
 *         com.teach.android.educationonline.ui.entity
 *         EducationOnline
 */

public class LiveUserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * attention : 0
     * auditStatus :
     * currentpage : 0
     * ip :
     * pagesize : 0
     * pay_pwd :
     * phoneNum : []
     * ts : 2017-12-08 15:02:18
     * user_bg_image :
     * user_id : 10038
     * user_intro : 这是简介信息
     * user_model : 18563996670
     * user_money : 0.0
     * user_name :
     * user_photo :
     * user_position :
     * user_profession :
     * user_pwd : 1a100d2c0dab19c4430e7d73762b3423
     */

    private int attention;
    private String auditStatus;
    private int currentpage;
    private String ip;
    private int pagesize;
    private String pay_pwd;
    private String ts;
    private String user_bg_image;
    private String user_id;
    private String user_intro;
    private String user_model;
    private String user_money;
    private String user_name;
    private String user_photo;
    private String user_position;
    private String user_profession;
    private String user_pwd;
    private List<?> phoneNum;

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getPay_pwd() {
        return pay_pwd;
    }

    public void setPay_pwd(String pay_pwd) {
        this.pay_pwd = pay_pwd;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getUser_bg_image() {
        return user_bg_image;
    }

    public void setUser_bg_image(String user_bg_image) {
        this.user_bg_image = user_bg_image;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_intro() {
        return user_intro;
    }

    public void setUser_intro(String user_intro) {
        this.user_intro = user_intro;
    }

    public String getUser_model() {
        return user_model;
    }

    public void setUser_model(String user_model) {
        this.user_model = user_model;
    }

    public String getUser_money() {
        return user_money;
    }

    public void setUser_money(String user_money) {
        this.user_money = user_money;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_position() {
        return user_position;
    }

    public void setUser_position(String user_position) {
        this.user_position = user_position;
    }

    public String getUser_profession() {
        return user_profession;
    }

    public void setUser_profession(String user_profession) {
        this.user_profession = user_profession;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public List<?> getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(List<?> phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "LiveUserModel{" +
                "attention=" + attention +
                ", auditStatus='" + auditStatus + '\'' +
                ", currentpage=" + currentpage +
                ", ip='" + ip + '\'' +
                ", pagesize=" + pagesize +
                ", pay_pwd='" + pay_pwd + '\'' +
                ", ts='" + ts + '\'' +
                ", user_bg_image='" + user_bg_image + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_intro='" + user_intro + '\'' +
                ", user_model='" + user_model + '\'' +
                ", user_money='" + user_money + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", user_position='" + user_position + '\'' +
                ", user_profession='" + user_profession + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}
