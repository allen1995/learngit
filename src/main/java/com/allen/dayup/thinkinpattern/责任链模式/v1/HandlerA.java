package com.allen.dayup.thinkinpattern.责任链模式.v1;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:18
 * @Description:
 */
public class HandlerA extends Handler {


    @Override
    public void handle() {
        boolean handled = false;

        System.out.println("HandlerA execute.");
        handled = true;

        if( !handled && successor != null ) {
            successor.handle();
        }
    }
}
