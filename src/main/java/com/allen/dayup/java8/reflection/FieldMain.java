package com.allen.dayup.java8.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

/**
 * @Auther: allen
 * @Date: 2020-04-04 12:38
 * @Description:
 */
public class FieldMain {

    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;

        //获取public字段
        System.out.println(stdClass.getField("score"));

        //获取符类的public字段
        System.out.println(stdClass.getField("name"));

        //获取private字段grade
        System.out.println(stdClass.getDeclaredField("grade"));

        //获取字段信息
        getFieldInfo();

        //获取字段的值
        Person p = new Person();
        p.name = "allen";
        Class pCla = p.getClass();
        Field f = pCla.getDeclaredField("name");
        System.out.println("name字段的值：" + f.get(p));

    }

    private static void getFieldInfo() throws Exception{
        Field field = String.class.getDeclaredField("value");
        System.out.println("Field name:" + field.getName());
        System.out.println("Field type:" + field.getType());
        int m = field.getModifiers();
        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isStatic(m));


    }

    static class Student extends Person {
        public int score;
        private int grade;
    }

    static class Person {
        public String name;

    }
}
