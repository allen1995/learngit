package com.allen.dayup.高并发程序设计.chap1;

/**
 * @Auther: allen
 * @Date: 2020-03-20 07:54
 * @Description:
 */
public class ThreadGroupName implements Runnable{

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg,new ThreadGroupName(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupName(), "T2");
        t1.start();
        t2.start();
        tg.activeCount();
        tg.list();
    }

    @Override
    public void run() {
        String threadGroupName = Thread.currentThread().getThreadGroup().getName()
                + "-" + Thread.currentThread().getName();

        while (true){
            System.out.println(threadGroupName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
