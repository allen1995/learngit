package com.allen.dayup.高并发程序设计.chap1;

/**
 * @Auther: allen
 * @Date: 2020-03-20 08:02
 * @Description:
 */
public class DaemonDemo {

    public static class DaemonThread extends Thread {

        @Override
        public void run() {

            while (true){
                System.out.println("I am alive!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
