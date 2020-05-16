package com.allen.dayup.thinkinpattern.chap5.polymorphicfactory;


import com.allen.dayup.thinkinpattern.chap5.simplefactory.BadShapeException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 20190598
 * @Date: 2020/5/8 13:58
 * @Description:
 */
public abstract class ShapeFactory {
    protected abstract Shape create();

    private static Map<String,ShapeFactory> factories = new HashMap<>();

    public static void addFactory(String id, ShapeFactory factory){
        factories.put(id, factory);
    }

    public static Shape createShape(String id) throws BadShapeException{
        if( !factories.containsKey(id)){
            try {
                Class.forName("com.allen.dayup.thinkinpattern.chap5.polymorphicfactory." + id);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if( !factories.containsKey(id)){
                throw new BadShapeException(id);
            }
        }
        return factories.get(id).create();
    }

}
