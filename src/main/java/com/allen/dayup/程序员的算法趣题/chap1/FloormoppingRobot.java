package com.allen.dayup.程序员的算法趣题.chap1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: 20190598
 * @Date: 2020/5/28 09:13
 * @Description: 优秀的扫地机器人
 * 现在市面上有很多扫地机器人，能够为我们分担家务，但是我们很难理解，有时候扫地机器人会重复清扫同一块地方。
 *
 * 假设现在有一款扫地机器人，不会重复扫过的地方，如果它要走四步，在走了第一步后，移动三步有如下9种路径；
 * 第一步可以走4种路径，总共情况有 9*4=36 种路径。
 *
 * 思路：
 * 1.可以(0,0)来表示初始位置，每次可以有四个方向可以选择 上（1，0），下（-1，0），左（0，-1），右（0，1）
 * 2.用一个集合保存所有已经走过的位置，过滤重复走的位置
 */
public class FloormoppingRobot {

    private static int N = 12;
    //移动方向的列表，对应上下左右
    private static List<Position> step = new ArrayList<>(4);;

    static {
        step.add(new Position(0,1));
        step.add(new Position(0,-1));
        step.add(new Position(1,0));
        step.add(new Position(-1,0));
    }

    private static int move(List<Position> historyPos){
        //移动部署为N，则历史列表集合size为4时结束
        if( historyPos.size() == N + 1){
            return 1;
        }

        int cnt = 0;
        for( Position move : step ){
            //取出列表里最后一个元素
            int lastIndex = historyPos.size()-1;
            Position currentPosition = historyPos.get(lastIndex);

            //计算机器人下一步的位置
            Position nextPosition = new Position(currentPosition.x+move.x, currentPosition.y + move.y);

            if( !historyPos.contains(nextPosition) ){
                historyPos.add(nextPosition);
                cnt += move(historyPos);
                historyPos.remove(nextPosition);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        List<Position> pos = new ArrayList<>();
        pos.add(new Position(0,0));

        List<Position> historyPos = new ArrayList<>();

        int cnt = move(pos);
        System.out.println(cnt);
    }

}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
