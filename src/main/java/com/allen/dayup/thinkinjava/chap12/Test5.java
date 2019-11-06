package com.allen.dayup.thinkinjava.chap12;

/**
 * @Auther: 20190598
 * @Date: 2019/11/4 09:55
 * @Description:
 */
public class Test5 {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            if( i == 10){
                System.out.println("this is normal block.");
                return;
            }
            try {
                int s = 0;
                throw new Exception();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
