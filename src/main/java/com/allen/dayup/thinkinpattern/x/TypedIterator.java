package com.allen.dayup.thinkinpattern.x;

import java.util.Iterator;

/**
 * @Auther: 20190598
 * @Date: 2020/4/22 17:00
 * @Description: 类型安全的迭代器
 */
public class TypedIterator implements Iterator {
    private Iterator iterator;

    private Class type;

    public TypedIterator(Iterator iterator, Class type) {
        this.iterator = iterator;
        this.type = type;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public void remove() {
        iterator.remove();
    }

    @Override
    public Object next() {

        Object object = iterator.next();

        if( !type.isInstance(object)){
            throw new RuntimeException("element type error.");
        }

        return object;
    }
}
