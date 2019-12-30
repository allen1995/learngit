package com.allen.dayup.thinkinjava.chap17.section6;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Auther: 20190598
 * @Date: 2019/12/30 13:15
 * @Description:
 */
public class SortedSetDemo {

    public static void main(String[] args) {

        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet, "one two three four five six seven".split(" "));

        System.out.println(sortedSet);
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());

        Iterator<String> it = sortedSet.iterator();
        while ( it.hasNext() ){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println( ((TreeSet<String>) sortedSet).headSet("four") );
        System.out.println(((TreeSet<String>) sortedSet).tailSet("four"));
    }
}
