package com.allen.dayup.高并发程序设计.chap3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: allen
 * @Date: 2020-03-21 09:02
 * @Description:
 */
public class CyclicBarrierDemo {

    public static class Soldier implements Runnable {

        private String soldier;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(String soldierName, CyclicBarrier cyclicBarrier) {
            this.soldier = soldierName;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            try {
                cyclicBarrier.await();
                doSomeWork();
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doSomeWork() {

            try {
                Thread.sleep(Math.abs(new Random().nextInt() * 10000) );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":任务完成！");
        }
    }

    public static class BarrierRun implements Runnable {

        private boolean flag;
        private int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {

            if( flag ){
                System.out.println("司令：【士兵】" + N + "个，任务完成！");
            } else {
                System.out.println("司令：【士兵】" + N + "个，集合完毕！");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        Thread[] allThreads = new Thread[10];

        boolean flag = false;
        int N = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new BarrierRun(flag, N));

        for (int i = 0; i < 10; i++) {
            System.out.println("士兵" + i + "报道！");
            allThreads[i] = new Thread(new Soldier("士兵" + i, cyclicBarrier));
            allThreads[i].start();
        }
    }
}
