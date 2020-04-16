package com.allen.dayup.thinkinpattern.template;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 13:36
 * @Description:
 */
public class MyApp extends AbstractionFramework {

    @Override
    void customize1() {
        System.out.println("Hello,");
    }

    @Override
    void customize2() {
        System.out.println("World!");
    }

    public static void main(String[] args) {
        MyApp app = new MyApp();
    }
}
