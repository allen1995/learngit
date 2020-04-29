package com.allen.dayup.java8.stream;

import java.util.function.Consumer;

/**
 * @Auther: allen
 * @Date: 2020-04-18 19:39
 * @Description: Consumer用来抽象只有入参没有返回参数的函数方法
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        //抽象print函数
        Consumer<String> print = System.out::println;
        print.accept("print:Hello,World!");

        Consumer<String> print2 = System.out::println;
        print2.accept("print2:Hello,World");

        print.andThen(print2).accept("addThen:Hello,World");


    }
}
