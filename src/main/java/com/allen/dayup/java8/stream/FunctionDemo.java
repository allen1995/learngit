package com.allen.dayup.java8.stream;

import java.util.function.Function;

/**
 * @Auther: allen
 * @Date: 2020-04-18 18:02
 * @Description: 抽象出有输入又要输出的函数
 */
public class FunctionDemo {

    public static void main(String[] args) {
        Function<String,Long> stringToLong = Long::valueOf;
        System.out.println(stringToLong.apply("1"));

        Function<Long,String> longToString = String::valueOf;
        System.out.println(longToString.apply(1L));

        // "1" -> 1L -> "1"
        System.out.println(longToString.compose(stringToLong).apply("1"));

        // lL -> "1" -> 1L
        System.out.println(longToString.andThen(stringToLong).apply(1L));
    }


}
