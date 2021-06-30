package com.allen.dayup.面经手册.chap2.threadlocal;

import java.lang.ref.WeakReference;

/**
 * @Auther: allen
 * @Date: 2021-06-30 22:57
 * @Description:
 */
public class Salad extends WeakReference<Apple> {

    public Salad(Apple referent) {
        super(referent);
    }

    public static void main(String[] args) {
        Salad salad = new Salad(new Apple("红富士"));

        System.out.println("Apple:" + salad.get());

        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if( salad.get() == null ) {
            System.out.println("clear Apple.");
        }
    }
}
