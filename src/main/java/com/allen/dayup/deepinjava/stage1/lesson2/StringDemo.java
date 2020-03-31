package com.allen.dayup.deepinjava.stage1.lesson2;

import java.lang.reflect.Field;

/**
 * @Auther: allen
 * @Date: 2020-03-24 13:28
 * @Description:
 */
public class StringDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String value = "Hello";

        String value2 = new String("Hello");

        System.out.println("value:" + value);
        System.out.println("value2:" + value2);

        Field valueField =  String.class.getDeclaredField("value");
        valueField.setAccessible(true);
        valueField.set(value, "World".toCharArray());

        System.out.println("value:" + value);
        System.out.println("value2:" + value2);
    }
}
