package com.allen.dayup.thinkinpattern.chap5.polymorphicfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/8 14:18
 * @Description:
 */
public class Circly implements Shape {

    private Circly(){};

    @Override
    public void draw() {
        System.out.println("Circly.draw");
    }

    @Override
    public void earse() {
        System.out.println("Circly.earse");
    }

    private static class Factroy extends ShapeFactory {

        @Override
        protected Shape create() {
            return new Circly();
        }
    }

    static {
        ShapeFactory.addFactory("Circly", new Circly.Factroy());
    }
}
