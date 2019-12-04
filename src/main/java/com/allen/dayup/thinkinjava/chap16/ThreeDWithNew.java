package com.allen.dayup.thinkinjava.chap16;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2019/12/4 14:04
 * @Description: 打印三维数组
 */
public class ThreeDWithNew {

    public static void main(String[] args) {
        int[][][] arr = new int[][][]{
            {{1,1,1,1},{3,2,2,2},{2,3,3,3}},
            {{1,1,1,1},{1,1,1,1},{1,1,1,1}}
        };
        System.out.println(Arrays.deepToString(arr));
    }
}
