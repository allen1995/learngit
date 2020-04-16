package com.allen.dayup.arithmetic;

import com.allen.dayup.高并发程序设计.chap3.CountTask;

import java.util.Random;
import java.util.UUID;

/**
 * @Auther: 20190598
 * @Date: 2020/1/9 09:42
 * @Description:
 */
public class test {

    public static void main(String[] args) {
        //System.out.println(UUID.randomUUID().toString().replaceAll("-",""));

        int a = 0;
        count(a);
        System.out.println(a);
    }

    private static void count(int a){
        a++;
    }
}
