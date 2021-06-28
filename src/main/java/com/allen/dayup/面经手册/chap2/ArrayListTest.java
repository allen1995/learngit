package com.allen.dayup.面经手册.chap2;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @Auther: allen
 * @Date: 2021-06-26 15:12
 * @Description:
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayListTest.test_copy_remove();
    }

    private static void test_copy_remove() {
        int[] oldArr = {1,2,3,4,5,6,7,8,9,10};

        int index = 2;
        int numMoved = oldArr.length - index - 1;

        System.arraycopy(oldArr, index+1, oldArr, index, numMoved);
        System.out.println("数组元素:" + JSON.toJSONString(oldArr));
    }
}
