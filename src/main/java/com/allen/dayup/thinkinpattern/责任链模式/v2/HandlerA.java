package com.allen.dayup.thinkinpattern.责任链模式.v2;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:39
 * @Description:
 */
public class HandlerA extends Handler {


    @Override
    public boolean doHandle() {
        System.out.println("v2 HandlerA execute.");

        return true;
    }
}
