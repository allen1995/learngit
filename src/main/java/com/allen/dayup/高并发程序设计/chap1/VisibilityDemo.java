package com.allen.dayup.高并发程序设计.chap1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: allen
 * @Date: 2020-03-19 22:00
 * @Description:
 */
public class VisibilityDemo {
    //线成可见，但是不满足原子性
    //static volatile int i = 0;

    static AtomicInteger i = new AtomicInteger();

    static class PlusTask implements Runnable{

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                //i++;
                i.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[10];

        for (int j = 0; j < 10; j++) {
            threads[j] = new Thread(new PlusTask());
            threads[j].start();
        }

        for (int j = 0; j < 10; j++) {
            threads[j].join();
        }
        System.out.println(i);
    }
}
