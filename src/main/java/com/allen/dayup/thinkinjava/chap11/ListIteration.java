package com.allen.dayup.thinkinjava.chap11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Auther: 20190598
 * @Date: 2019/10/30 14:44
 * @Description:
 */
public class ListIteration {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("allen");
        names.add("aben");
        names.add("alun");

        ListIterator it = names.listIterator();

        while (it.hasNext()){
            System.out.println(it.next() + "," + it.nextIndex() + "," + it.previousIndex());
        }

        while (it.hasPrevious()){
            System.out.println(it.previous().toString() + " ");
        }

        System.out.println();
        System.out.println(names);
        it = names.listIterator(1);
        while (it.hasNext()){
            it.next();
            it.set("bob" + Math.random()*10);
        }

        System.out.println(names);
    }
}
