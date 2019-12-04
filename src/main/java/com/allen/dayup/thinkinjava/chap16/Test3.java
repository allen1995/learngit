package com.allen.dayup.thinkinjava.chap16;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: 20190598
 * @Date: 2019/12/4 14:40
 * @Description:
 */
public class Test3 {

    public static void main(String[] args) {
        //Double[][] a1 = generateDoubleDimArrays(2,3,100);
        //System.out.println("a1: " + Arrays.deepToString(a1));
        //
        //Double[][] a2 = generateDoubleDimArrays(4,5, 23);
        //System.out.println("a2: " + Arrays.deepToString(a2));
        //
        //Double[][] a3 = generateDoubleDimArrays(7, 3, 50);
        //System.out.println("a2: " + Arrays.deepToString(a3));

        Double[][][] a1 = generateThridDimArrays(2,3,4,100);
        System.out.println("a1: " + Arrays.deepToString(a1));

        Double[][][] a2 = generateThridDimArrays(4,4,4,100);
        System.out.println("a2: " + Arrays.deepToString(a2));

        Double[][][] a3 = generateThridDimArrays(7,2,1,100);
        System.out.println("a3: " + Arrays.deepToString(a3));
    }

    /**
     * 生成一个二维双精度数组
     * @param a: 数组的长度
     * @param b： 数组的二维长度
     * @param max: 数组初始值范围的最大值
     * @return
     */
    public static Double[][] generateDoubleDimArrays(int a, int b, int max){
        Double[][] result = new Double[a][];
        Random rand = new Random(47);

        for (int i = 0; i < a; i++) {
            result[i] = new Double[b];
            for (int j = 0; j < b; j++) {
                result[i][j] = Double.valueOf(rand.nextInt(max)) ;
            }
        }

        return result;
    }

    public static Double[][][] generateThridDimArrays(int a, int b,int c, int max){
        Double[][][] result = new Double[a][][];
        Random rand = new Random(47);

        for (int i = 0; i < a; i++) {
            result[i] = new Double[b][];
            for (int j = 0; j < b; j++) {
                result[i][j] = new Double[c];
                for (int k = 0; k < c ; k++) {
                    result[i][j][k] = Double.valueOf(rand.nextInt(max));
                }
            }
        }

        return result;
    }
}
