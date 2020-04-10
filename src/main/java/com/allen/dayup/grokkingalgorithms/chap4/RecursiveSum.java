package com.allen.dayup.grokkingalgorithms.chap4;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2019/12/31 14:06
 * @Description:
 */
public class RecursiveSum {


    /**
     * 用分治法的思想求数组的和
     * @param arrs
     * @return
     */
    public int sum(int[] arrs){

        if( arrs.length == 0 ){
            return 0;
        }else {
            return arrs[0] + sum(Arrays.copyOfRange(arrs, 1, arrs.length));
        }
    }

    /**
     * 分治思想求数组最大值
     * @param arrs
     * @return
     */
    public int max(int[] arrs){
        if( arrs.length == 2 ){
            return arrs[0] > arrs[1] ? arrs[0] : arrs[1];
        }

        int subMax = max(Arrays.copyOfRange(arrs, 1, arrs.length));

        return arrs[0] > subMax ? arrs[0] : subMax;
    }
}
