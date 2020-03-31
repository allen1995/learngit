package com.allen.dayup.高并发程序设计.chap3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: allen
 * @Date: 2020-03-20 10:00
 * @Description:
 */
public class IntLock extends Thread {

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        try {

            if( lock == 1 ){
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch ( InterruptedException e){
            e.printStackTrace();
        } finally {
            if( lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }

            if( lock2.isHeldByCurrentThread() ){
                lock2.unlock();
            }

            System.out.println(Thread.currentThread().getId() + " 线成执行完并退出!");
        }
    }

    public static void main(String[] args) {
        IntLock oneLockThread = new IntLock(1);
        IntLock twoLockThread = new IntLock(2);

        oneLockThread.start();
        twoLockThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        twoLockThread.interrupt();
    }
}
