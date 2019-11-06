package com.allen.dayup.thinkinjava.chap12;

/**
 * @Auther: 20190598
 * @Date: 2019/11/4 09:47
 * @Description:
 */
public class test2 {

    private void f(){
        System.out.println("test2.f()");
    }

    public static void main(String[] args) {
        try {
            test2 test2 = null;
            test2.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
