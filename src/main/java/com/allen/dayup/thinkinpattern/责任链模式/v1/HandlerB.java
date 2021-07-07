package com.allen.dayup.thinkinpattern.责任链模式.v1;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:21
 * @Description:
 */
public class HandlerB extends Handler {

    @Override
    public void handle() {
        boolean handled = false;

        //业务逻辑
        System.out.println("HandlerB execute.");

        if( !handled && successor != null ) {
            successor.handle();
        }
    }
}
