package com.allen.dayup.arithmetic.leetcode;

/**
 * @Auther: 20190598
 * @Date: 2021/6/9 10:13
 * @Description:
 */
public class Solution_509 {

    public static void main(String[] args) {
        System.out.println(fib2(4));
    }

    public static int fib(int n) {

        if( n == 1 || n == 2) {
            return 1;
        }

        int[] dptable = new int[n+1];

        if( dptable[n] != 0 ) {
            return dptable[n];
        }

        dptable[n] = fib(n-1) + fib(n-2);

        return dptable[n];
    }

    public static int fib2(int n) {
        if( n == 0 ) {
            return 0;
        }

        if( n == 1 || n == 2) {
            return 1;
        }

        int[] dptable = new int[n+1];

        dptable[1] = 1;
        dptable[2] = 1;
        for( int i = 3; i <= n; i++ ) {
            dptable[i] = dptable[i-1] + dptable[i-2];
        }

        return dptable[n];
    }
}
