package com.allen.dayup.thinkinpattern.statemachine;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 14:39
 * @Description:
 */
public class Wash implements State {
    @Override
    public void run() {
        System.out.println("Wash");
    }
}
