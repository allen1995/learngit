package com.allen.dayup.高并发程序设计.chap3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: allen
 * @Date: 2020-03-25 08:57
 * @Description:
 */
public class ExtThreadPool {

    static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行：" + Thread.currentThread().getId()+ ",Task name=" + name);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(5,5,0,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(10)){

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行：" + ((MyTask) r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成：" + ((MyTask)r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出.");
            }
        };

        for (int i = 0; i < 5; i++) {
            es.execute(new MyTask("Task_" + i));
        }

        es.shutdown();
    }
}
