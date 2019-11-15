package com.allen.dayup.thinkinjava.chap15;

import java.util.Iterator;

/**
 * @Auther: 20190598
 * @Date: 2019/11/12 14:40
 * @Description:
 */
public class ConbinationFibonacci implements Iterable<Integer> {
    //末端哨兵
    private int count;

    //数列对象
    private Fibonacci fibonacci;

    public ConbinationFibonacci(int count, Fibonacci fibonacci) {
        this.count = count;
        this.fibonacci = fibonacci;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count-- > 0;
            }

            @Override
            public Integer next() {
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {

        ConbinationFibonacci fibonacci = new ConbinationFibonacci(18, new Fibonacci());
        for ( int i : fibonacci){
            System.out.print(i + " ");
        }
    }
}
