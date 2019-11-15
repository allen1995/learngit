package com.allen.dayup.thinkinjava.chap15;

import java.lang.reflect.Array;

/**
 * @Auther: 20190598
 * @Date: 2019/11/13 14:47
 * @Description:
 */
public class ArrayMaker<T> {

    private Class<T> kind;

    public ArrayMaker(Class<T> kind){
        this.kind = kind;
    }

    T[] create(int size){
        return (T[])Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> arrayMaker = new ArrayMaker<>(String.class);

        String[] stringArray = arrayMaker.create(10);
    }
 }
