package com.allen.dayup.thinkinpattern.chap5.simplefactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/8 11:39
 * @Description:
 */
public class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw");
    }

    @Override
    public void earse() {
        System.out.println("Square.earse");
    }
}
