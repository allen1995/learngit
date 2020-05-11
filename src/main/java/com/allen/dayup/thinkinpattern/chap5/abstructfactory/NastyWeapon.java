package com.allen.dayup.thinkinpattern.chap5.abstructfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 10:42
 * @Description:
 */
public class NastyWeapon implements Obstacle {
    @Override
    public void action() {
        System.out.println("NastyWeapon");
    }
}
