package com.allen.dayup.高并发程序设计.chap4;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Auther: allen
 * @Date: 2020-03-30 18:22
 * @Description:
 */
public class AtomicIntegerArrayDemo {
    static AtomicIntegerArray array = new AtomicIntegerArray(10);

    static class AddTask implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                array.getAndIncrement(i%(array.length()));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddTask());
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println(array);
    }
}
