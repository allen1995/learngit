package com.allen.dayup.thinkinjava.chap8;

import java.util.Random;

/**
 * @Auther: 20190598
 * @Date: 2019/10/21 11:24
 * @Description:
 */
public class RandomShapeGenerator {
    private static Random random = new Random(47);

    public static Shape generator(){
        switch ( random.nextInt(3) ){
            case 0 : return new Cycle();
            case 1 : return new Triangle();
            case 2 : return new Square();
            default:
        }

        return null ;
    }

    public static void main(String[] args) {
        //for (int i = 0; i < 10; i++) {
        //    Shape shape = generator();
        //    shape.draw();
        //}
        Shape s = new Cycle();
        System.out.println(s);
    }
}


class Shape{

    public void draw(){
        System.out.println("Shape.draw()");
    }

    public void erase(){
        System.out.println("Shape.erase()");
    }
}

class Cycle extends Shape{

    @Override
    public void draw() {
        System.out.println("Cycle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Cycle.erase()");
    }

    @Override
    public String toString() {
        return "Cycle{}";
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }
}

class Square extends Shape{
    @Override
    public void draw() {
        System.out.println("Sequare.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Sequare.erase()");
    }
}