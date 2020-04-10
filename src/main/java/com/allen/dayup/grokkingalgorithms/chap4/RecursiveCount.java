package com.allen.dayup.grokkingalgorithms.chap4;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2019/12/31 14:27
 * @Description:
 */
public class RecursiveCount {

    /**
     * 用分治法统计数组元素个数
     * @param arrs
     * @return
     */
    public int resursiveCount(int[] arrs){

        if( arrs.length == 0 ){
            return 0;
        }else {
            return 1 + resursiveCount(Arrays.copyOfRange(arrs, 1, arrs.length));
        }
    }
}
