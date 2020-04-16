package com.allen.dayup.thinkinpattern.proxy;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 13:47
 * @Description:
 */
public class Implemetation implements ProxyBase {
    @Override
    public void f() {
        System.out.println("Implemetation.f()");
    }

    @Override
    public void g() {
        System.out.println("Implemetation.g()");
    }

    @Override
    public void h() {
        System.out.println("Implemetation.h()");
    }
}
