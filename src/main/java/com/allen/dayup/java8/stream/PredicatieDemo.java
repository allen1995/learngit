package com.allen.dayup.java8.stream;

import java.util.function.Predicate;

/**
 * @Auther: allen
 * @Date: 2020-04-18 19:44
 * @Description:
 */
public class PredicatieDemo {

    public static void main(String[] args) {
        Predicate<String> perdicate = file -> true;
        System.out.println(perdicate.test("12"));
    }
}
