package com.allen.dayup.java8.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: allen
 * @Date: 2020-04-04 22:01
 * @Description:
 */
public class HelloDynamicProxy {

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("开始执行代理任务");
                //if( method.getName().equals("hello")){
                //    System.out.println("hello," + args[0]);
                //}
                method.invoke(new Person(), args);

                System.out.println("结束执行代理任务");

                return null;
            }
        };


        Hello he = (Hello) java.lang.reflect.Proxy.newProxyInstance(Person.class.getClassLoader(),
               Person.class.getInterfaces() ,handler);

        he.hello("bob");

    }


    public interface Hello {
        void hello(String name);
    }

     static class Person implements Hello {

        @Override
        public void hello(String name) {
            System.out.println("hello," + name);
        }
    }
}
