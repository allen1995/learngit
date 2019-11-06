package com.allen.dayup.thinkinjava.cahp13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2019/11/6 11:42
 * @Description:
 */
public class InfiniteRecursion {

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> infiniteRecursions = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            infiniteRecursions.add(new InfiniteRecursion());
        }

        System.out.println(infiniteRecursions);
    }
}
