package com.allen.dayup.高并发程序设计.chap4;

import com.allen.dayup.高并发程序设计.chap1.DaemonDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: allen
 * @Date: 2020-03-27 20:52
 * @Description:
 */
public class ThreadLocalDemo{

    //public static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();

    static class ParseDate implements Runnable {

        private int i;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                //Date t = sdf.parse("2015-03-30 12:21:" + i%60);
                if( t1.get() == null ){
                    t1.set(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"));
                }

                Date t = t1.get().parse("2015-03-30 12:21:" + i%60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService pools = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            pools.execute(new ParseDate(i));
        }

        pools.shutdown();
    }
}
