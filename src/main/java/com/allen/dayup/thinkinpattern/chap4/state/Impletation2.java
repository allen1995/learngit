package com.allen.dayup.thinkinpattern.chap4.state;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 13:53
 * @Description:
 */
public class Impletation2 implements StateBase {
    @Override
    public void g() {
        System.out.println("Impletation2.g()");
    }

    @Override
    public void h() {
        System.out.println("Impletation2.h()");
    }

    @Override
    public void f() {
        System.out.println("Impletation2.f()");
    }
}
