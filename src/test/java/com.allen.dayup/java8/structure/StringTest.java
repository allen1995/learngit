package com.allen.dayup.java8.structure;

import org.junit.Test;

/**
 * @Auther: 20190598
 * @Date: 2021/6/28 16:33
 * @Description:
 */
public class StringTest {

    @Test
    public void testStringBuilder() {
        StringBuilder builder = new StringBuilder();

        long current = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            builder.append(i);
        }

        System.out.println("StringBuilder拼接耗时:" + (System.currentTimeMillis() - current));
    }

    @Test
    public void testString() {
        String s = "";

        long current = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s += i;
        }

        System.out.println("String拼接耗时:" + (System.currentTimeMillis() - current));
    }
}
