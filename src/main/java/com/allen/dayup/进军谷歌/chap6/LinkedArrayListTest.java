package com.allen.dayup.进军谷歌.chap6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: allen
 * @Date: 2021-06-26 15:35
 * @Description:
 */
public class LinkedArrayListTest {

    public static void main(String[] args) {
       test_ArrayList_addFirst();
       test_LinkedList_addFirst();
    }

    private static void test_ArrayList_addFirst() {
        long starttime = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000 ; i++) {
            list.add(0, i);
        }

        System.out.printf("【ArrayList】总共耗时: %d", (System.currentTimeMillis() - starttime));
    }

    private static void test_LinkedList_addFirst() {
        long starttime = System.currentTimeMillis();

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000 ; i++) {
            list.add(0, i);
        }

        System.out.printf("【LinkedList】总共耗时: %d", (System.currentTimeMillis() - starttime));
    }

    private static void test_ArrayList_addMid() {
        long starttime = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000 ; i++) {
            list.add(list.size()/2, i);
        }

        System.out.printf("【ArrayList】总共耗时: %d", (System.currentTimeMillis() - starttime));
    }

    private static void test_LinkedList_addMid() {
        long starttime = System.currentTimeMillis();

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000 ; i++) {
            list.add(list.size()/2, i);
        }

        System.out.printf("【LinkedList】总共耗时: %d", (System.currentTimeMillis() - starttime));
    }

    private static void test_ArrayList_addLast() {
        long starttime = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000 ; i++) {
            list.add(list.size(), i);
        }

        System.out.printf("【ArrayList】总共耗时: %d", (System.currentTimeMillis() - starttime));
    }

    private static void test_LinkedList_addLast() {
        long starttime = System.currentTimeMillis();

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000 ; i++) {
            list.add(list.size(), i);
        }

        System.out.printf("【LinkedList】总共耗时: %d", (System.currentTimeMillis() - starttime));
    }
}
