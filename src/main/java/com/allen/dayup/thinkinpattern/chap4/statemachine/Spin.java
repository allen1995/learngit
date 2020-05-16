package com.allen.dayup.thinkinpattern.chap4.statemachine;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 14:40
 * @Description:
 */
public class Spin implements State {
    @Override
    public void run() {
        System.out.println("Spin");
    }
}
