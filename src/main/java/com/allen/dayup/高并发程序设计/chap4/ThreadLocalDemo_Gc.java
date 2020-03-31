package com.allen.dayup.高并发程序设计.chap4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: allen
 * @Date: 2020-03-27 22:01
 * @Description:
 */
public class ThreadLocalDemo_Gc {

    static volatile ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.toString() + " is gc.");
        }
    };

    static volatile CountDownLatch cdt = new CountDownLatch(10000);

    static class ParseDate implements  Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {

            try {

                if ( t1.get() == null ){
                    t1.set(new SimpleDateFormat("YYYY-MM-DD HH:mm:ss"){
                        @Override
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString() + " is gc.");
                        }
                    });
                    System.out.println(Thread.currentThread().getId() + " create SimpleDateFormat.");
                }

                Date t = t1.get().parse("2015-02-14 12:21:" + i%60);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                cdt.countDown();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            es.execute(new ParseDate(i));
        }
        cdt.await();
        System.out.println("mission complete!");
        t1 = null;
        System.gc();
        System.out.println("first gc complete.");

        t1 = new ThreadLocal<SimpleDateFormat>();
        cdt = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            es.execute(new ParseDate(i));
        }

        cdt.await();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second gc complete.");
        es.shutdown();
    }

}
