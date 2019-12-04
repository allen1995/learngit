package com.allen.dayup.thinkinjava.chap16;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2019/12/4 14:27
 * @Description:
 */
public class MultiDimWrapperArray {

    public static void main(String[] args) {

        Integer[][] a1 = {
                {1,2,4},
                {4,5,6},
                {7,8,9}
        };

        Double[][] a2 = {
                {1.1,2.123,2.23},
                {1.11,3.11,3.22},
                {1d,2.1212,233.2312,4.2323,32.12}
        };

        String[][] a3 = {
                {"dog","pig","tiger","cat","mouse"},
                {"java","python","c#","ruby","js","mysql"},
                {"语文","数学","英文"}
        };

        System.out.println("a1: " + Arrays.deepToString(a1));
        System.out.println("a2: " + Arrays.deepToString(a2));
        System.out.println("a3: " + Arrays.deepToString(a3));
    }
}
