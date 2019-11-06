package com.allen.dayup.thinkinjava.chap10.section10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2019/10/30 09:53
 * @Description:
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    /**
     * 添加事件
     * @param event
     */
    public void add(Event event){
        eventList.add(event);
    }

    /**
     * 触发事件
     */
    public void run(){
        for ( Event event : new ArrayList<>(eventList)){
            if( event.ready() ){
                System.out.println(event);
                event.action();
                eventList.remove(event);
            }
        }
    }

}
