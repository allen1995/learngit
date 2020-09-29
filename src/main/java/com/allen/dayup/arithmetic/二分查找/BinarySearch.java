package com.allen.dayup.arithmetic.二分查找;

/**
 * @Auther: 20190598
 * @Date: 2020/9/29 10:38
 * @Description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,6,10};
        System.out.println(binarySearch(arr, 4));
    }

    private static int binarySearch(int[] arr, int target){
        int left = 0;
        //注意搜索区间是[left,right)，左开右闭，所以这里不是arr.length-1
        int right = arr.length;

        //小于而不是小于等于
        while ( left < right ){

            int mid = (left + right)/2;
            if( arr[mid] == target ){
                //同样是搜索区间的问题
                right = mid;
            } else if( arr[mid] < target ){
                left = mid + 1;
            } else if( arr[mid] > target ){
                //注意
                right = mid;
            }

        }

        return left;
    }
}
