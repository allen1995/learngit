package com.allen.dayup.高并发程序设计.chap4;

import java.security.cert.CertificateExpiredException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Random共享一个实例与每个线成一个random实例性能分析
 * @Auther: allen
 * @Date: 2020-03-27 22:35
 * @Description:
 */
public class RandomPerformanceAnalysis {

    public static final int GEN_COUNT = 100000;

    public static final int THREAD_COUNT = 4;

    static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);

    public static Random random = new Random(123);

    public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>(){
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RndTask implements Callable<Long> {

        private int mode = 0;

        public RndTask(int mode) {
            this.mode = mode;
        }

        public Random getRandom(){
            if( mode == 0 ){
                return random;
            } else if( mode == 1 ){
                return tRnd.get();
            }
            return null;
        }


        @Override
        public Long call() throws Exception {

            long start = System.currentTimeMillis();
            for (int i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend " + (end - start) + "ms");
            return end - start;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] futs = new Future[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = exe.submit(new RndTask(0));
        }

        long totalTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime += futs[i].get();
        }
        System.out.println("多线程访问同一个实例：" + totalTime + "ms");

        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = exe.submit(new RndTask(0));
        }

        totalTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime += futs[i].get();
        }
        System.out.println("多线程访问不同实例：" + totalTime + "ms");
    }
}
