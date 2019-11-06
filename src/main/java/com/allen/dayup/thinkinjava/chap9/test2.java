package com.allen.dayup.thinkinjava.chap9;

/**
 * @Auther: 20190598
 * @Date: 2019/10/23 10:55
 * @Description:
 */
public class test2 {
    public static void main(String[] args) {

        DemoSon son = new DemoSon();
        son.print();
    }
}


abstract class Demo{

    public Demo() {
        print();
    }

    abstract void f();

    abstract void print();
}

class DemoSon extends Demo {

    private int i = 10;

    @Override
    void f() {

    }

    @Override
    void print() {
        System.out.println(i);
    }
}