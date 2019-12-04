package com.allen.dayup.thinkinjava.chap16.section5;

import com.allen.dayup.thinkinjava.chap16.BerylliumSphere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2019/12/4 15:52
 * @Description:
 */
public class ArraysOfGenerics {

    public static void main(String[] args) {
        List<String>[] ls;

        List[] la = new List[10];
        ls = (List<String>[]) la;

        Object[] objects = ls;
        objects[1] = new ArrayList<String>();


        List<BerylliumSphere>[] beryLists = new List[10];
        for (int i = 0; i < 10; i++) {
            beryLists[i] = new ArrayList<BerylliumSphere>();
            beryLists[i].add(new BerylliumSphere());
            beryLists[i].add(new BerylliumSphere());
        }

        System.out.println("beryLists: " + Arrays.deepToString(beryLists));

    }
}
