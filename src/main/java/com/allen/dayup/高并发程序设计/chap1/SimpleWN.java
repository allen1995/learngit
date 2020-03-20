package com.allen.dayup.高并发程序设计.chap1;

/**
 * @Auther: allen
 * @Date: 2020-03-19 21:04
 * @Description:
 */
public class SimpleWN {

    private static Object object = new Object();

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }

    public static class T1 extends Thread{

        @Override
        public void run() {

            System.out.println("Thread T1 started!");
            synchronized (object){

                try {
                    System.out.println("Thread T1 Waited!");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread T1 end!");
            }
        }
    }

    public static class T2 extends Thread{

        @Override
        public void run() {

            System.out.println("Thread T2 started!");

            synchronized (object){

                object.notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread t2 end!");
            }
        }
    }
}
