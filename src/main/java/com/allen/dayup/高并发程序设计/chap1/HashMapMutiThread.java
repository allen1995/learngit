package com.allen.dayup.高并发程序设计.chap1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allen
 * @Date: 2020-03-20 08:45
 * @Description:
 */
public class HashMapMutiThread {

    static Map<String,String> map = new HashMap<>();

    public static class AddThread extends Thread {

        private int start = 0;

        public AddThread(String name,int start) {
            super(name);
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i+=2) {
                map.put(String.valueOf(i), String.valueOf(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread("Add_1", 0);
        //AddThread addThread2 = new AddThread("Add_2", 1);
        addThread.start();
        //addThread2.start();

        addThread.join();
        //addThread2.join();

        System.out.println("Map的size:" + map.size());
    }
}
