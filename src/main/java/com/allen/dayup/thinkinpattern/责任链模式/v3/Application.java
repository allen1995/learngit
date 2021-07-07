package com.allen.dayup.thinkinpattern.责任链模式.v3;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:54
 * @Description:
 */
public class Application {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();

        HandlerA handlerA = new HandlerA();
        HandlerB handlerB = new HandlerB();

        chain.addHandler(handlerA);
        chain.addHandler(handlerB);

        chain.handle();
    }
}
