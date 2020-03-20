package com.allen.dayup.高并发程序设计.chap1;

/**
 * @Auther: allen
 * @Date: 2020-03-19 21:16
 * @Description:
 */
public class BadSuspend {

    static Object u = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{

        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {

            System.out.println("in " + Thread.currentThread().getName());
            Thread.currentThread().suspend();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }
}
