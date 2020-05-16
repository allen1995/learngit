package com.allen.dayup.thinkinpattern.chap5.abstructfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 10:43
 * @Description:
 */
public interface GameElementFactory {

    Player makePlayer();
    Obstacle makeObstacle();
}
