package com.allen.dayup.java8.utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allen
 * @Date: 2020-03-29 08:57
 * @Description:
 */
public class StringUtils {
    public static void main(String[] args) {
        //String legalName = "一路灯控面板";
        //System.out.println(isLegalDevcieName("一路灯控面板","测试字符", "一路"));
        Map<String,Object> map = new HashMap<>();
        System.out.println(map.get("test"));
    }

    /**
     *
     * @param toCheckDeviceName:待校验的字符串
     * @param deviceName: 设备昵称
     * @param standardName: 标准语料中的设备类型
     * @return
     */
    private static boolean isLegalDevcieName(String toCheckDeviceName,String deviceName,String standardName) {
        Map<Character,Boolean> legalNameMap = new HashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        if( toCheckDeviceName == null || toCheckDeviceName.length() == 0){
            return true;
        }

        if( toCheckDeviceName.startsWith("好太太") && toCheckDeviceName.substring(3).length() == 0){
            return true;
        }

        if( toCheckDeviceName.startsWith("好太太")){
            toCheckDeviceName = toCheckDeviceName.substring(3);
        }

        String legalName = deviceName + standardName;
        int len = legalName.length();
        for (int i = 0; i < len; i++) {
            int val = legalName.charAt(i);
            legalNameMap.put(legalName.charAt(i),true);
        }

        int check = 0;
        for (int i = 0; i < toCheckDeviceName.length(); i++) {
            if( legalNameMap.containsKey(toCheckDeviceName.charAt(i))){
                check++;
            }
        }

        return Float.valueOf(decimalFormat.format((float)check/toCheckDeviceName.length())) > 0.30 ;
    }
}
