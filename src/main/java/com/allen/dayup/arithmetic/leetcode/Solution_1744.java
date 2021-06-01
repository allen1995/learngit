package com.allen.dayup.arithmetic.leetcode;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2021/6/1 10:31
 * @Description:
 */
public class Solution_1744 {
    public static void main(String[] args) {
        int[] candiesCount = {7,4,5,3,8};

        int[][] queries = {{4,2,4}};

        Solution_1744 solution = new Solution_1744();

        boolean[] result = solution.canEat2(candiesCount, queries);

        Arrays.asList(result).stream().forEach(System.out::println);
    }

    public boolean[] canEat2(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;

        // 前缀和
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];

            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] result = new boolean[queries.length];

        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for( int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i-1] + candiesCount[i];
        }

        for(int i = 0; i < queries.length; i++ ) {
            int[] q = queries[i];

            int favorityType = q[0];
            int favorityDay = q[1];
            int dailyCap = q[2];

            long needMinEat = favorityType == 0 ? 1 : sum[favorityType-1] + 1;
            long needMaxEat = sum[favorityType];

            long daysEatCount =(long)(favorityDay+1)*dailyCap;
            result[i] = !(needMaxEat < (favorityDay+1) || daysEatCount < needMinEat);
        }

        return result;
    }



}
