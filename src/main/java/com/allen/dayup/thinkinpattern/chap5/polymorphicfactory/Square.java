package com.allen.dayup.thinkinpattern.chap5.polymorphicfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/8 14:27
 * @Description:
 */
public class Square implements Shape {

    private Square(){};

    @Override
    public void draw() {
        System.out.println("Square.draw");
    }

    @Override
    public void earse() {
        System.out.println("Square.earse");
    }

    private static class Factory extends ShapeFactory{

        @Override
        protected Shape create() {
            return new Square();
        }
    }

    static {
        ShapeFactory.addFactory("Square",new Square.Factory());
    }
}
