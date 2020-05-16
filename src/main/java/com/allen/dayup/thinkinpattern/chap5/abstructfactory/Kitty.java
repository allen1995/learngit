package com.allen.dayup.thinkinpattern.chap5.abstructfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 10:37
 * @Description:
 */
public class Kitty implements Player {

    @Override
    public void interactWith(Obstacle obstacle) {
        System.out.println("Kitty has encountered a ");
        obstacle.action();
    }
}
