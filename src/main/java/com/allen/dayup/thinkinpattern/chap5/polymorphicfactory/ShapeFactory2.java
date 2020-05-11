package com.allen.dayup.thinkinpattern.chap5.polymorphicfactory;

import com.allen.dayup.thinkinpattern.chap5.simplefactory.BadShapeException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/5/8 14:32
 * @Description:
 */
public class ShapeFactory2 {

    public static void main(String[] args) throws BadShapeException {
        String[] strList = {"Circly","Square","Circly","Square","Circly","Square","Triangle"};

        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < strList.length; i++) {
            shapes.add(ShapeFactory.createShape(strList[i]));
        }

        shapes.stream().forEach( shape -> {
            shape.draw();
            shape.earse();
            System.out.println("------------------------------------");
        });
    }
}
