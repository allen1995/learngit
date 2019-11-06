package com.allen.dayup.thinkinjava.chap12;

/**
 * @Auther: 20190598
 * @Date: 2019/11/4 09:49
 * @Description:
 */
public class Test3 {

    public static void main(String[] args) {


        try {
            int[] arrs = new int[]{1,2,3};

            for (int i = 0; i < 4; i++) {
                System.out.println(arrs[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
