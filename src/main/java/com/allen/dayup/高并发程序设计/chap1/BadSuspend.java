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
            synchronized (u){

                System.out.println("in " + Thread.currentThread().getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //对照观察t1和t2，休眠主线程让t1阻塞，而t2在阻塞之前调用resume

        t1.start();
        //主线程休眠100毫秒，保证t1已经阻塞
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
