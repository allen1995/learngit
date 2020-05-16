package com.allen.dayup.thinkinpattern.chap5.abstructfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 10:47
 * @Description:
 */
public class KillAndDismember implements GameElementFactory {
    @Override
    public Player makePlayer() {
        return new KungFuGuy();
    }

    @Override
    public Obstacle makeObstacle() {
        return new NastyWeapon();
    }
}
