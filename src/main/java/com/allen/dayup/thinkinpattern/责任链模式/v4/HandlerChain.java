package com.allen.dayup.thinkinpattern.责任链模式.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2021/7/7 16:45
 * @Description:
 */
public class HandlerChain {

    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        if( handler == null ) {
            return;
        }

        this.handlers.add(handler);
    }

    public void handle() {

        for( Handler handler : handlers ){
             handler.handle() ;
        }
    }
}
