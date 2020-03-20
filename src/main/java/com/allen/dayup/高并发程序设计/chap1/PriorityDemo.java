package com.allen.dayup.高并发程序设计.chap1;

/**
 * @Auther: allen
 * @Date: 2020-03-20 08:11
 * @Description:
 */
public class PriorityDemo {

    public static class HighPriority extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (true){
                synchronized (PriorityDemo.class){
                    count++;
                    if( count > 100000 ){
                        System.out.println("High priority thread complete!");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (true){
                synchronized (PriorityDemo.class){
                    count++;
                    if( count > 100000 ){
                        System.out.println("Low priority thread complete!");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        HighPriority highPriority = new HighPriority();
        LowPriority lowPriority = new LowPriority();
        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        highPriority.start();
        lowPriority.start();
    }
}
