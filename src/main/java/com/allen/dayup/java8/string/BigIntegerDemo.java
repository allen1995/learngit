package com.allen.dayup.java8.string;

import java.math.BigInteger;

/**
 * @Auther: 20190598
 * @Date: 2020/4/3 17:04
 * @Description:
 */
public class BigIntegerDemo {
    static BigInteger value1 = new BigInteger("100");
    static BigInteger value2 = new BigInteger("50");

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new addTask());
        Thread t2 = new Thread(new subTask());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(value1);
    }


    static class addTask implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value1 = value1.add(value2);
            }
        }
    }

    static class subTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                value1 = value1.subtract(value2);
            }
        }
    }
}
