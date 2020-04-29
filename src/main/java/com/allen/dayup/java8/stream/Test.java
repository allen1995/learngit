package com.allen.dayup.java8.stream;

/**
 * @Auther: allen
 * @Date: 2020-04-25 08:01
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        f();
    }

    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }
}
