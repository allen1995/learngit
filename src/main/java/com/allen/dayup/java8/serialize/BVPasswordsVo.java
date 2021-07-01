package com.allen.dayup.java8.serialize;

import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2021/7/1 13:42
 * @Description:
 */
public class BVPasswordsVo {

    List<BVPeriodPassword> periodpassword;

    List<BVTempPassword> offlinetemppassworddd;

    public List<BVPeriodPassword> getPeriodpassword() {
        return periodpassword;
    }

    public void setPeriodpassword(List<BVPeriodPassword> periodpassword) {
        this.periodpassword = periodpassword;
    }

    public List<BVTempPassword> getOfflinetemppassworddd() {
        return offlinetemppassworddd;
    }

    public void setOfflinetemppassworddd(List<BVTempPassword> offlinetemppassworddd) {
        this.offlinetemppassworddd = offlinetemppassworddd;
    }
}
