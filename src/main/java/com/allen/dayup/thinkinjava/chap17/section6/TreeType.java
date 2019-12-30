package com.allen.dayup.thinkinjava.chap17.section6;

/**
 * @Auther: 20190598
 * @Date: 2019/12/30 11:00
 * @Description:
 */
public class TreeType extends SetType implements Comparable<TreeType> {

    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType arg) {
        return arg.i < i ? -1 : ( arg.i == i ? 0 : 1) ;
    }
}
