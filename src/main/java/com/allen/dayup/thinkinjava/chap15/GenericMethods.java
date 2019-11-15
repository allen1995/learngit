package com.allen.dayup.thinkinjava.chap15;

/**
 * @Auther: 20190598
 * @Date: 2019/11/12 14:51
 * @Description:
 */
public class GenericMethods {

    public <T> void f(T t){
        System.out.println(t.getClass().getName());
    }

    public <A,B,C>  void g(A a, B b, String c){
        System.out.format("参数A类型: %s.\n 参数B类型: %s.\n 参数C类型: %s",a.getClass().getName(),b.getClass().getName(),c.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods methods = new GenericMethods();
        methods.f(1.0f);
        methods.f(1);
        methods.f("1");

        methods.g(1,1L, "df");
    }
}
