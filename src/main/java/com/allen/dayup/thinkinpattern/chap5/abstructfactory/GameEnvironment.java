package com.allen.dayup.thinkinpattern.chap5.abstructfactory;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 10:52
 * @Description:
 */
public class GameEnvironment {

    private GameElementFactory gef;
    private Player player;
    private Obstacle obstacle;

    public GameEnvironment(GameElementFactory gef) {
        this.gef = gef;
        this.player = gef.makePlayer();
        this.obstacle = gef.makeObstacle();
    }

    public void play(){
        player.interactWith(obstacle);
    }

    public static void main(String[] args) {
        GameElementFactory kittyAndPuzzle = new KittyAndPuzzle();
        GameElementFactory killAndDismember = new KillAndDismember();

        GameEnvironment g1 = new GameEnvironment(killAndDismember);
        GameEnvironment g2 = new GameEnvironment(kittyAndPuzzle);

        g1.play();
        g2.play();
    }
}
