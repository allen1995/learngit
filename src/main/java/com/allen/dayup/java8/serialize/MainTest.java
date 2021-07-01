package com.allen.dayup.java8.serialize;

import com.alibaba.fastjson.JSON;

/**
 * @Auther: 20190598
 * @Date: 2021/7/1 13:43
 * @Description:
 */
public class MainTest {

    public static void main(String[] args) {
        String param = "{\n" +
                "        \"periodpassword\": [],\n" +
                "        \"offlinetemppassword\": []\n" +
                "    }";


        BVPasswordsVo o = JSON.parseObject(param, BVPasswordsVo.class);

        System.out.println(o.getOfflinetemppassworddd());
        System.out.println(o.getPeriodpassword());

        System.out.println(o);
    }
}
