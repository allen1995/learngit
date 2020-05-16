package com.allen.dayup.thinkinpattern.chap5.polymorphicfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 11:04
 * @Description:
 */
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw");
    }

    @Override
    public void earse() {
        System.out.println("Triangle.earse");
    }

    private static class Factory extends ShapeFactory {

        @Override
        protected Shape create() {
            return new Triangle();
        }
    }

    static {
        ShapeFactory.addFactory("Triangle", new Factory());
    }
}
