package com.allen.dayup.arithmetic;

/**
 * @Auther: allen
 * @Date: 2020-05-23 11:05
 * @Description:
 */
public class StringSort {

    public static void main(String[] args) {
        String str = "abbacb";
        char[] arr = str.toCharArray();
        int[] sortArr = converCharToInt(arr);
        quickSort(sortArr,0,sortArr.length-1);
        char[] resultArr = converIntToChar(sortArr);
        System.out.println(new String(resultArr));
    }

    private static int[] converCharToInt(char[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (int) arr[i];
        }
        return result;
    }

    private static char[] converIntToChar(int[] arr){
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (char) arr[i];
        }
        return result;
    }


    private static void quickSort(int[] arr,int startIndex, int endIndex){
        if( startIndex >= endIndex){
            return;
        }

        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex,pivotIndex-1);
        quickSort(arr, pivotIndex+1, endIndex);

    }

    private static int partition(int[]arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while ( left != right){

            while ( left < right && arr[right] > pivot){
                right--;
            }

            while ( left < right && arr[left] <= pivot ){
                left++;
            }

            if( left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }
}
