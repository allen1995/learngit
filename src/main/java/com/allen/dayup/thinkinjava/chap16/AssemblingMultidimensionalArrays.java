package com.allen.dayup.thinkinjava.chap16;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2019/12/4 14:18
 * @Description:
 */
public class AssemblingMultidimensionalArrays {

    public static void main(String[] args) {
        Integer[][] a = new Integer[3][];

        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * j;
            }
        }

        System.out.println(Arrays.deepToString(a));
    }
}
