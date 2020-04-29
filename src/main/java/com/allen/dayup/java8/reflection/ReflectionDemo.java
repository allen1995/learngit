package com.allen.dayup.java8.reflection;

/**
 * @Auther: allen
 * @Date: 2020-04-04 11:48
 * @Description:
 */
public class ReflectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取反射的三种方式

        //1.通过类的静态域
        Class cls = String.class;

        //2.通过实例对象的getClass()
        String s = "Hello";
        Class classStr = s.getClass();

        //3.通过类的完整类名
        Class clsP = Class.forName("java.lang.String");

        //instanceof 和 class实例比较的区别
        Integer n = new Integer(123);

        System.out.println((n instanceof Integer));
        System.out.println(n instanceof Number);

        System.out.println(n.getClass() == Integer.class);
        //System.out.println(n.getClass() == Number.class);

        //通过class对象创建实例
        String instance = String.class.newInstance();
        System.out.println(instance);
    }
}
