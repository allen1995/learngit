package com.allen.dayup.thinkinpattern.责任链模式.v2;



/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:41
 * @Description:
 */
public class Application {

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();

        HandlerA handlerA = new HandlerA();
        HandlerB handlerB = new HandlerB();
        handlerChain.addHadnler(handlerB);
        handlerChain.addHadnler(handlerA);

        handlerChain.handle();
    }
}
