package com.allen.dayup.高并发程序设计.chap3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: allen
 * @Date: 2020-03-25 09:11
 * @Description:
 */
public class DivTask implements Runnable{

    int a;
    int b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
        //throw new NullPointerException();
    }

    public static void main(String[] args) {
        ExecutorService pools = new TraceThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.SECONDS,
                new SynchronousQueue<>());

        for (int i = 1; i < 5; i++) {
            pools.execute(new DivTask(100,i));
            //pools.execute(new DivTask(100,i));
        }

        pools.shutdown();
    }
}
