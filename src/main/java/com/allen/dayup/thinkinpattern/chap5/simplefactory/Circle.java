package com.allen.dayup.thinkinpattern.chap5.simplefactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/8 11:35
 * @Description:
 */
public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle.draw");
    }

    @Override
    public void earse() {
        System.out.println("Circle.earse");
    }
}
