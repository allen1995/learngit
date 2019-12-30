package com.allen.dayup.thinkinjava.chap17.section6;

import java.util.LinkedList;

/**
 * @Auther: 20190598
 * @Date: 2019/12/30 17:20
 * @Description:
 */
public class MySortedSet<E> extends LinkedList<E> {

    int compare(E o1, E o2){
        int c = o1.hashCode() - o2.hashCode();

        return c < 0 ? -1 : c == 0 ? 0 : 1;
    }


}
