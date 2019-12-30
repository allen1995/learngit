package com.allen.dayup.thinkinjava.chap17.section6;

/**
 * @Auther: 20190598
 * @Date: 2019/12/30 10:51
 * @Description:
 */
public class SetType {

    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SetType && i == ((SetType)o).i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
