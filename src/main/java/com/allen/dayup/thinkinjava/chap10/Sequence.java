package com.allen.dayup.thinkinjava.chap10;

import java.util.NoSuchElementException;

/**
 * @Auther: 20190598
 * @Date: 2019/10/28 10:34
 * @Description:
 */
public class Sequence {
    private Object[] items;
    private int size = 0;

    public Sequence(int capacity) {
        items = new Object[capacity];
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }

        Selector selector = sequence.selector();
        while ( selector.hasNext()){
            System.out.println(selector.current() + " ");
            selector.next();
        }

    }

    public Object add(Object o){
        //异常处理
        if( size >= items.length){
            return null;
        }

        items[size++] = o;

        return o;
    }

    public SequeceSelector selector(){
        return  new SequeceSelector();
    }

    private class SequeceSelector implements Selector {
        private int i = 15;

        @Override
        public boolean hasNext() {
            if( i >= size){
                throw new  NoSuchElementException();
            }

            return i < size;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
             i++;
        }
    }
}

interface Selector{
    boolean hasNext();
    Object current();
    void next();
}


