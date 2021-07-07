package com.allen.dayup.thinkinpattern.责任链模式.v1;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:22
 * @Description:
 */
public class HandlerChain {

    private Handler head = null;

    private Handler tail = null;

    public void addHadnler(Handler handler) {

        handler.setSuccessor(null);

        if( head == null ) {
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if( head != null ) {
            head.handle();
        }
    }
}
