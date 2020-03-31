package com.allen.dayup.高并发程序设计.chap3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: allen
 * @Date: 2020-03-20 15:03
 * @Description:
 */
public class TryLock implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        if( lock == 1 ){
            while ( true ){
                if( lock1.tryLock() ){
                    try {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if( lock2.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getId() + ": My job done.");
                                return;
                            } finally {
                                    lock2.unlock();
                            }
                        }
                    } finally {
                            lock1.unlock();
                    }
                }
            }
        } else {
            while ( true ){
                if( lock2.tryLock() ){
                    try {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if( lock1.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getId() + ": My job done.");
                                return;
                            } finally {
                                if( lock1.isHeldByCurrentThread() ){
                                    lock1.unlock();
                                }
                            }
                        }
                    } finally {
                        if( lock2.isHeldByCurrentThread()){
                            lock2.unlock();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLock tryLock1 = new TryLock(1);
        TryLock tryLock2 = new TryLock(2);
        new Thread(tryLock1).start();
        new Thread(tryLock2).start();
    }
}
