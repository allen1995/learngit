package com.allen.dayup.高并发程序设计.chap1;

/**
 * @Auther: allen
 * @Date: 2020-03-19 21:28
 * @Description:
 */
public class GoodSuspend {

    static Object lock = new Object();

    static class ChangeObjectThread extends Thread {

        volatile boolean suspendMe = false;

        public void suspendMe(){
            this.suspendMe = true;
        }

        public void resumeMe(){
            suspendMe = false;
            synchronized (this){

                notify();
            }
        }

        @Override
        public void run() {

            while (true){

                synchronized (this){
                    while ( suspendMe ) {

                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        synchronized (lock){
                            System.out.println("in ChangeObjectThread!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        Thread.yield();
                    }
                }
            }
        }
    }

    static class ReadObjectThread extends Thread{

        @Override
        public void run() {
            while (true){
                synchronized (lock){
                    System.out.println("in ReadObjectLock!");
                    Thread.yield();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.suspendMe();
        System.out.println("suspend t1 2 second");
        Thread.sleep(2000);
        System.out.println("resume t1");
        t1.resumeMe();
    }
}
