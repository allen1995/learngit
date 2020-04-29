package com.allen.dayup.java8.stream;

/**
 * @Auther: allen
 * @Date: 2020-04-18 20:00
 * @Description:
 */
public class ActionDemo {

    public static void main(String[] args) {
        //匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("execute run.");
            }
        };

        //函数式编程
        Runnable runnable1 = () -> {
            System.out.println("lamdba execute run.");
        };
    }
}
