package com.allen.dayup.程序员的算法趣题.chap1;

/**
 * @Auther: 20190598
 * @Date: 2020/5/26 10:56
 * @Description:
 * 考兹曼猜想：
 * 一个正整数，无论它为多少
 * 1.如果它是偶数，就除以2
 * 2.如果它是基数，就乘以3+1
 * 一直重复运算，最后结果一定为1
 *
 * 5 16 8 4 2 1
 *
 * 现在改进考兹曼猜想：
 * 一个正整数，无论它为多少
 * 1.首先将它乘以3加1
 * 2.如果它是偶数，就除以2
 * 3.如果它是基数，就乘以3+1
 * 重复运算，最后结果等于自己本身
 *
 * 4 13 40 20 10 5 16 8 4
 */
public class CowesMannGuess {

    public static void main(String[] args) throws Exception {

        System.out.println(countIsCowesMannNumber());
    }

    private static int countIsCowesMannNumber() throws Exception {
        int count = 0;

        for (int i = 2; i < 10000; i++) {
            if( checkCowesMannGuess(i)){
                count++;
            }
        }

        return count;
    }

    private static boolean checkCowesMannGuess(int n) throws Exception {
        if( n <= 0 ){
            throw new Exception("不支持负数");
        }

        int check = n*3+1;
        while ( check != 1 ){
            if( check%2 == 0 ){
                check = check/2;
            } else {
                check = check*3 + 1;
            }

            if( check == n ){
                return true;
            }
        }

        return false;
    }
}
