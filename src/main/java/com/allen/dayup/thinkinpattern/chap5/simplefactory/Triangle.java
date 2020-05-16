package com.allen.dayup.thinkinpattern.chap5.simplefactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 11:01
 * @Description:
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw");
    }

    @Override
    public void earse() {
        System.out.println("Triangle.earse");
    }
}
