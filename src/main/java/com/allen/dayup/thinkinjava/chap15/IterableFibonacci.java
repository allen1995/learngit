package com.allen.dayup.thinkinjava.chap15;

import java.util.Iterator;

/**
 * @Auther: 20190598
 * @Date: 2019/11/12 14:25
 * @Description:
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    private int count;

    public IterableFibonacci(int count) {
        this.count = count;
    }

    public Iterator<Integer> iterator(){

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count-- > 0;
            }

            @Override
            public Integer next() {
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        IterableFibonacci fibonacci = new IterableFibonacci(18);
        for ( int i : fibonacci){
            System.out.print(i + " ");
        }
    }

}
