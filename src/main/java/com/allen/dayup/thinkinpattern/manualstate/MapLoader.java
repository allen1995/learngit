package com.allen.dayup.thinkinpattern.manualstate;

import java.util.Map;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 15:28
 * @Description: 工具类，定义状态
 */
public class MapLoader {

    public static void load(Map map, Object[][] pairs){
        for (int i = 0; i < pairs.length; i++) {
            map.put(pairs[i][0],pairs[i][1]);
        }
    }
}
