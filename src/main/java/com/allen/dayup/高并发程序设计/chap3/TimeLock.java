package com.allen.dayup.高并发程序设计.chap3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: allen
 * @Date: 2020-03-20 14:48
 * @Description:
 */
public class TimeLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)){
                Thread.sleep(6000);
            }else {
                System.out.println("get lock failed!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if( lock.isHeldByCurrentThread() ){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock timeLock1 = new TimeLock();
        TimeLock timeLock2 = new TimeLock();
        new Thread(timeLock1).start();
        new Thread(timeLock2).start();
    }
}
