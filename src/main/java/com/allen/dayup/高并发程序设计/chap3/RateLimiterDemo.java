package com.allen.dayup.高并发程序设计.chap3;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Auther: allen
 * @Date: 2020-03-21 09:43
 * @Description:
 */
public class RateLimiterDemo {
    static RateLimiter limiter = RateLimiter.create(1000);

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            //limiter.acquire();

            //当负载超过时，直接丢弃任务
            if( !limiter.tryAcquire()){
                continue;
            }
            new Thread(new Task()).start();
        }
    }
}
