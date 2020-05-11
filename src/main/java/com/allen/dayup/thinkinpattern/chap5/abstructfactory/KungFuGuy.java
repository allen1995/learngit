package com.allen.dayup.thinkinpattern.chap5.abstructfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 10:40
 * @Description:
 */
public class KungFuGuy implements Player {

    @Override
    public void interactWith(Obstacle obstacle) {
        System.out.println("KunFuGuy now battles a ");
        obstacle.action();
    }
}
