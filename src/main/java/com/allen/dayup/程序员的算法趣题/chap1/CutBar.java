package com.allen.dayup.程序员的算法趣题.chap1;

/**
 * @Auther: allen
 * @Date: 2020-04-29 23:33
 * @Description: 切分木棒
 */
public class CutBar {

    public static void main(String[] args) {
        int result = cutBar(3,8,1);
        System.out.println(result);
    }

    public static int cutBar(int m, int n, int current){
        int time = 0;
        if( current >= n ){
            return 0;
        } else if ( current < m ){
            time = 1 + cutBar(m,n, 2*current);
        } else {
            time = 1 + cutBar(m, n, current+m);
        }

        return time;
    }
}
