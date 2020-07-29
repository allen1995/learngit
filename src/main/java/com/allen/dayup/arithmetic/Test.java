package com.allen.dayup.arithmetic;

import java.io.IOException;

/**
 * @Auther: 20190598
 * @Date: 2020/1/9 09:42
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {


        int starttimeInt = 2200;
        int endtimeInt = 800;
        int nowTimeInt = 900;

        int b = 0;
         boolean result = (starttimeInt < endtimeInt && (starttimeInt <= nowTimeInt && nowTimeInt <= endtimeInt)) || (starttimeInt > endtimeInt && (starttimeInt <= nowTimeInt || nowTimeInt <= endtimeInt));
        System.out.println(result);
    }



    private static void count(int a){
        a++;
    }
}
