package com.allen.dayup.manhuasuanfa.chap4;

/**
 * @Auther: allen
 * @Date: 2020-03-31 23:52
 * @Description:
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {4,2,12,35,32,1};
        quickSort(arr,0,arr.length-1);
        printArr(arr);
    }


    public static void quickSort(int[] arr, int startIndex, int endIndex){
        if( startIndex >= endIndex){
            return;
        }

        int pivotIndex =  partition(arr,startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex-1);
        quickSort(arr, pivotIndex+1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while ( left != right ){

            while ( left < right && arr[right] > pivot ){
                right--;
            }

            while ( left < right && arr[left] < pivot ){
                left++;
            }

            if( left < right ){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }


        return left;
    }

    private static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
