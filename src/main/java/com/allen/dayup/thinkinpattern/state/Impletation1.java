package com.allen.dayup.thinkinpattern.state;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 13:52
 * @Description:
 */
public class Impletation1 implements StateBase {


    @Override
    public void g() {
        System.out.println("Impletation1.g()");
    }

    @Override
    public void h() {
        System.out.println("Impletation1.h()");
    }

    @Override
    public void f() {
        System.out.println("Impletation1.f()");
    }
}
