package com.allen.dayup.thinkinjava.chap12;

/**
 * @Auther: 20190598
 * @Date: 2019/11/4 09:44
 * @Description:
 */
public class test1 {

    public static void main(String[] args) {

        try {
            int i = 19;
            throw new Exception("This is a exception.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("This is finally block.");
        }
    }
}
