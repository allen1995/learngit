package com.allen.dayup.thinkinpattern.责任链模式.v1;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 15:53
 * @Description:
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void  handle();

}
