package com.allen.dayup.thinkinpattern.chap5.abstructfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 10:49
 * @Description:
 */
public class KittyAndPuzzle implements GameElementFactory {
    @Override
    public Player makePlayer() {
        return new Kitty();
    }

    @Override
    public Obstacle makeObstacle() {
        return new Puzzle();
    }
}
