package com.allen.dayup.thinkinpattern.chap5.simplefactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/5/8 11:40
 * @Description:
 */
public class ShapeFactory {

    public static void main(String[] args) {

        String[] shlist = {"Circly","Square","Circly","Circly","Square","Triangle"};

        try {
            List<Shape> shapes = new ArrayList<>();
            for (int i = 0; i < shlist.length; i++) {
                shapes.add(Shape.factory(shlist[i]));
            }

            shapes.stream().forEach( shape -> {
                shape.draw();
                shape.earse();
                System.out.println("-------------------------");
            });
        } catch (BadShapeException e) {
            e.printStackTrace();
        }
    }
}
