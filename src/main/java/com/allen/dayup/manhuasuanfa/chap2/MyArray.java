package com.allen.dayup.manhuasuanfa.chap2;

/**
 * @Auther: allen
 * @Date: 2020-03-15 23:33
 * @Description:
 */
public class MyArray {

    private int[] arr;
    private int size;

    public MyArray(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
    }

    public void insert(int element, int index) throws Exception{
        if( index < 0 || index > size){
            throw new Exception("超出数组容量范围！");
        }

        if( size >= arr.length ){
            resize();
        }

        System.arraycopy(arr,index, arr,index+1,size-index);
        arr[index] = element;
        size++;
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr,0, newArr,0, arr.length);
        this.arr = newArr;

    }

    public void outputArray(){
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+",");
        }
    }

    public void delete(int index) throws Exception{
        if( index < 0 || index > size){
            throw new Exception("超出数组容量范围！");
        }

        System.arraycopy(arr,index+1,arr,index,size-index-1);
        size--;
    }

    public static void main(String[] args) throws Exception{
        MyArray arr = new MyArray(2);
        arr.insert(3,0);
        arr.insert(2,1);
        arr.insert(2,1);
        arr.insert(2,1);
        arr.delete(0);
        arr.outputArray();
    }
}

