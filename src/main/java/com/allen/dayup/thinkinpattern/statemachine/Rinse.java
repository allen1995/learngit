package com.allen.dayup.thinkinpattern.statemachine;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 14:40
 * @Description:
 */
public class Rinse implements State{
    @Override
    public void run() {
        System.out.println("rinse");
    }
}
