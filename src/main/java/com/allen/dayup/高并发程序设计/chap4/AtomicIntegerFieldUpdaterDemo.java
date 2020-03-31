package com.allen.dayup.高并发程序设计.chap4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Auther: allen
 * @Date: 2020-03-30 21:19
 * @Description:
 */
public class AtomicIntegerFieldUpdaterDemo {

    static class Candidate {
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    //检查updaterScore是否正常
    static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(){
                @Override
                public void run() {
                    scoreUpdater.getAndIncrement(stu);
                    allScore.getAndIncrement();
                }
            };
            threads[i].start();
        }

        for (int i = 0; i < 10000; i++) {
            threads[i].join();
        }

        System.out.println("scoreUpdater:" + scoreUpdater.get(stu));

        System.out.println("allScore:" + allScore.get());
    }
}
