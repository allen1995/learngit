package com.allen.dayup.java8.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @Auther: allen
 * @Date: 2020-04-03 20:39
 * @Description:
 */
public class RandomDemo {

    public static void main(String[] args) {
        //random();
        secureRandom();
    }


    private static void secureRandom(){
        SecureRandom sr = new SecureRandom();
        for (int i = 0; i < 50; i++) {
            System.out.println(sr.nextInt(10));
        }
    }

    /**
     * 产生伪随机数
     */
    private static void random(){
        Random random = new Random(123);
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
