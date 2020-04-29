package com.allen.dayup.java8.annotion;

/**
 * @Auther: allen
 * @Date: 2020-04-04 23:03
 * @Description:
 */
public class Person {

    @Range(min = 0, max = 20)
    private String name;

    @Range(min = 0, max = 22)
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
