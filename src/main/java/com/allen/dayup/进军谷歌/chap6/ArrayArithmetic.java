package com.allen.dayup.进军谷歌.chap6;

import java.util.Arrays;

/**
 * @Auther: allen
 * @Date: 2020-03-31 23:36
 * @Description:
 */
public class ArrayArithmetic {

    public static void main(String[] args) {
        int[] arr = {7,5,8,1};
        System.out.println(hasSum(arr,21));
    }


    public static boolean hasSum(int[] arr, int target){
        boolean result = false;

        if( arr == null || arr.length < 2 ){
            return result;
        }

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;
        while ( i < j ){
            if( arr[i] + arr[j] < target ){
                i++;
            } else if( arr[i] + arr[j] > target ){
                j--;
            } else if( arr[i] + arr[j] == target ){
                result = true;
                break;
            }
        }

        return result;
    }
}
