package com.allen.dayup.java8.entity;

import sun.util.resources.cldr.ewo.CurrencyNames_ewo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 20190598
 * @Date: 2021/6/28 11:13
 * @Description:
 */
public class TestDelayed implements Delayed {

    /**
     * 数据
     */
    private String data;

    /**
     * 延时
     */
    private long delay;

    public TestDelayed(String data, long delay, TimeUnit unit) {
        this.data = data;
        this.delay = System.currentTimeMillis() + (delay > 0 ? unit.toMillis(delay) : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return delay - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        TestDelayed work = (TestDelayed) o;
        long diff = this.delay - work.delay;

        if( diff <= 0 ) {
            return -1;
        } else {
            return 1;
        }

    }

    public String getData() {
        return data;
    }
}
