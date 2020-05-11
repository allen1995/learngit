package com.allen.dayup.thinkinpattern.chap5.simplefactory;


/**
 * @Auther: 20190598
 * @Date: 2020/5/8 11:30
 * @Description:
 */
public abstract class Shape {

    public abstract void draw();
    public abstract void earse();
    public static Shape factory(String type) throws BadShapeException{
        switch (type) {
            case "Circly":
                return new Circle();
            case "Square":
                return new Square();
            case "Triangle":
                return new Triangle();
            default:
                throw new BadShapeException( type +  ":没有匹配到工厂支持的类型。");
        }
    }
}
