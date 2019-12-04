package com.allen.dayup.thinkinjava.chap16;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: 20190598
 * @Date: 2019/11/28 17:27
 * @Description:
 */
public class Test1 {

    public static void main(String[] args) {
        //String[] myArray = { "this", "is", "a", "sentence" };
        // String result = Arrays.stream(myArray)
        //        .reduce((a,b) -> a + b).get();
        //System.out.println(result);
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "allen"));
        users.add(new User(2L, "wz"));
        users.stream().collect(Collectors.toMap( user -> {return user.getId();}, user ->{
            return user.getName();
        })).forEach( (key, value) -> {
            System.out.println(key + ":" + value );
        });


        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("Dolores");
        //创建一个空实例
        Optional empty = Optional.ofNullable(null);
        //创建一个不允许值为空的空实例
        Optional noEmpty = Optional.of("test");

        //如果值不为null，orElse方法返回Optional实例的值。
        //如果为null，返回传入的消息。
        //输出：Dolores
        System.out.println(name.orElse("There is some value!"));
        //输出：There is no value present!
        System.out.println(empty.orElse("There is no value present!"));
        //抛NullPointerException
        System.out.println(noEmpty.orElse("There is no value present!"));

        //orElseGet与orElse方法类似，区别在于orElse传入的是默认值，


        //orElseGet可以接受一个lambda表达式生成默认值。
        //输出：Dolores
        System.out.println(name.orElseGet(() -> "it's value"));
        //输出：No value
        System.out.println(empty.orElseGet(() -> "No value"));
        //抛出NullPointerException
        System.out.println(noEmpty.orElseGet(() -> "it's value"));
    }
}
