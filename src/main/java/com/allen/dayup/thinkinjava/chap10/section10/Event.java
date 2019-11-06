package com.allen.dayup.thinkinjava.chap10.section10;

/**
 * @Auther: 20190598
 * @Date: 2019/10/29 10:14
 * @Description:
 */
public abstract class Event {
    //事件时间
    private long eventTime;

    //延时时间
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    protected void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
