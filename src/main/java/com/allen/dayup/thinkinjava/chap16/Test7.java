package com.allen.dayup.thinkinjava.chap16;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2019/12/4 15:24
 * @Description:
 */
public class Test7 {

    public static void main(String[] args) {
        BerylliumSphere[][][] result = generateThridDimArrayByBery(2,2,2);
        System.out.println("result: " + Arrays.deepToString(result));
    }

    public static BerylliumSphere[][][] generateThridDimArrayByBery(int a, int b, int c){
        BerylliumSphere[][][] result = new BerylliumSphere[a][][];

        for (int i = 0; i < a; i++) {
            result[i] = new BerylliumSphere[b][];
            for (int j = 0; j < b; j++) {
                result[i][j] = new BerylliumSphere[c];
                for (int k = 0; k < c; k++) {
                    result[i][j][k] = new BerylliumSphere();
                }
            }
        }

        return result;
    }
}
