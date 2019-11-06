package com.allen.dayup.thinkinjava.chap10;

/**
 * @Auther: 20190598
 * @Date: 2019/10/28 15:56
 * @Description:
 */
public class AnonymousConstrutors {

    public static Base getBase(int i){
        return new Base(i) {
            {
                System.out.println("In anonymous constructor.");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        getBase(10);
    }
}


abstract class Base{

    public Base(int i) {
        System.out.println("Base Construtor.i = " + i);
    }

    public abstract void f();
}
