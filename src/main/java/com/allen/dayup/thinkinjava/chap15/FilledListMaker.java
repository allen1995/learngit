package com.allen.dayup.thinkinjava.chap15;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2019/11/13 14:56
 * @Description:
 */
public class FilledListMaker<T> {

    List<T> create(T t, int n){
        List<T> result = new  ArrayList<T>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }

        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker<String>();

        List<String> list = stringMaker.create("Hello",4);
        System.out.println(list);
    }
}
