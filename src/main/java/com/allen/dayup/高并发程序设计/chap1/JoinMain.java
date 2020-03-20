package com.allen.dayup.高并发程序设计.chap1;

/**
 * @Auther: allen
 * @Date: 2020-03-19 21:50
 * @Description:
 */
public class JoinMain {
    public static volatile int i = 0;

    static class AddThread extends Thread{

        @Override
        public void run() {
            for(;i < 10000;i++ ){

            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join();
        System.out.println(i);
    }
}
