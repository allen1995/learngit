package com.allen.dayup.thinkinpattern.责任链模式.v4;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:39
 * @Description:
 */
public class HandlerB implements Handler {


    @Override
    public void handle() {
        System.out.println("v4 HandlerB execute.");
    }
}
