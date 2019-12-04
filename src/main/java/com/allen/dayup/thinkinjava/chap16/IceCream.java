package com.allen.dayup.thinkinjava.chap16;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: 20190598
 * @Date: 2019/12/4 13:19
 * @Description:
 */
public class IceCream {

    private static Random rand = new Random(47);

    private final static String[] FLAVORS = {"Chocolate","Straberry","Vanilla Fudge Swirl",
            "Mint Chip","Mocha Almod Fudge","Rum Raisin","Praline Cream","Mud pie"};

    /**
     * 生成一个长度为n的数组
     * @param n
     * @return
     */
    public static String[] generateArray(int n){
        if( n > FLAVORS.length ){
            throw new IllegalArgumentException("n is too big.");
        }

        String[] result = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];


        for (int i = 0; i < n; i++) {
            int t;

            //确保元素不会重复
            do {
                t = rand.nextInt(FLAVORS.length);
            }while (picked[t]);

            result[i] = FLAVORS[t];
            picked[t] = true;

        }

        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
             System.out.println(Arrays.toString(generateArray(3)));
        }
    }
}
