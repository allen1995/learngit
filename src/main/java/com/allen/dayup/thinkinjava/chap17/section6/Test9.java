package com.allen.dayup.thinkinjava.chap17.section6;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Auther: 20190598
 * @Date: 2019/12/30 13:44
 * @Description:
 */
public class Test9 {
    static String[] LETTER_TABLE = "a b c d e f g h i j k l".split(" ");
    static Random rand = new Random(32);

    public static void main(String[] args) {

        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < 20; i++) {
            set.add(LETTER_TABLE[rand.nextInt(12)]);
        }

        System.out.println(set);
    }
}


