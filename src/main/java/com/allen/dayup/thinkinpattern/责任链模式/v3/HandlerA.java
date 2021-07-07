package com.allen.dayup.thinkinpattern.责任链模式.v3;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:39
 * @Description:
 */
public class HandlerA implements Handler {


    @Override
    public boolean handle() {
        System.out.println("v3 HandlerA execute.");

        return true;
    }
}
