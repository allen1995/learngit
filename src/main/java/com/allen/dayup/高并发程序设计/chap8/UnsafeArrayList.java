package com.allen.dayup.高并发程序设计.chap8;

import java.util.ArrayList;

/**
 * @Auther: allen
 * @Date: 2020-04-07 20:08
 * @Description:
 */
public class UnsafeArrayList {

    static ArrayList list = new ArrayList(8);

    static class AddTask implements Runnable {

        @Override
        public void run() {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10000; i++) {
                list.add(new Object());
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new AddTask(),"t1");
        Thread t2 = new Thread(new AddTask(),"t2");
        t1.start();
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t3");

        t3.start();
    }
}
