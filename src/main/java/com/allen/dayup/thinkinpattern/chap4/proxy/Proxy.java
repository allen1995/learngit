package com.allen.dayup.thinkinpattern.chap4.proxy;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 13:48
 * @Description:
 */
public class Proxy implements ProxyBase{

    private Implemetation implemetation;

    public Proxy() {
        this.implemetation = new Implemetation();
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.g();
        proxy.h();
        proxy.f();
    }

    @Override
    public void f() {
        implemetation.f();
    }

    @Override
    public void g() {
        implemetation.g();
    }

    @Override
    public void h() {
        implemetation.h();
    }
}
