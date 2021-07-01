package com.allen.dayup.java8.serialize;

import java.io.Serializable;

public class BVTempPassword implements Serializable {

    private int id;

    private int index;

    /**
     * 用户id
     */
    private String userid;
    /**
     * 设备id
     */
    private String iotid;
//    /**
//     * 密码
//     */
//    private String passwordid;


    /**
     * 离线临时密码，6位
     */
    private String password;
    /**
     * 是否已使用
     */
    private boolean isused;
    /**
     * 使用者手机号码
     */
    private String phone;

    /**
     * 是否被选中
     */
    private boolean isSelect;

    /**
     * 是否被编辑
     */
    private boolean isEdit;

    /**
     * 开始时间
     */
    private long starttime;

    /**
     * 结束时间
     */
    private long endtime;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }


//    public BVTempPassword() {
//    }


//
//
//    public BVTempPassword(int index, String userid, String iotid, String passwordid, boolean isused, String phone) {
//        this.index = index;
//        this.userid = userid;
//        this.iotid = iotid;
////        this.passwordid = passwordid;
//        this.isused = isused;
//        this.phone = phone;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getIotid() {
        return iotid;
    }

    public void setIotid(String iotid) {
        this.iotid = iotid;
    }

//    public String getPasswordid() {
//        return passwordid;
//    }
//
//    public void setPasswordid(String passwordid) {
//        this.passwordid = passwordid;
//    }

    public boolean isIsused() {
        return isused;
    }

    public void setIsused(boolean isused) {
        this.isused = isused;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }


}
