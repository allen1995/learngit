package com.allen.dayup.dailyquestion;

/**
 * @Auther: allen
 * @Date: 2020-06-03 22:10
 * @Description:
 * 现象：线程阻塞，没有返回结果
 * 原因分析：对象在初始化的时候（包括字段和代码块的初始化），会调用cinit方法，为了保证字段初始化的线程安全，其它线程均会阻塞。
 *
 * 这里新建的线程t启动后就阻塞了，初始化线程又调用了t.join()等待t线程运行后，最后导致都不能执行完。
 *
 */
public class Lazy {

    private static boolean initialized = false;

    static {
        Thread t = new Thread(()->{
            initialized = true;
        });
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println(initialized);
    }
}
